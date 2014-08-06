package edu.pitt.dbmi.edda.summarization;

import java.io.IOException;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import edu.pitt.dbmi.edda.summarization.rdbms.DataSourceManager;
import edu.pitt.dbmi.edda.summarization.rdbms.pojos.NormalizedWord;
import edu.pitt.dbmi.edda.summarization.rdbms.pojos.NounPhraseMention;
import edu.pitt.dbmi.edda.summarization.rdbms.pojos.Sentence;
import edu.pitt.dbmi.edda.summarization.rdbms.pojos.WordMention;

public class SingleDocumentTebekaSummarizer {

	private int medianCharactersPerAbstract; 
	private String outputDirectoryPath;
	private boolean isRelativeScoring = false;
	
	private String accumulatingSummary = "";

	private DataSourceManager dataSourceManager;

	private int currentCluster = 0;
	private SentenceScorer sentenceScorer;

	public SingleDocumentTebekaSummarizer() {
	}

	public void execute() throws SummarizationException {
		try {
			sentenceScorer = new SentenceScorer();
			sentenceScorer.setDataSourceManager(dataSourceManager);
			sentenceScorer.initialize();
			summarizeCluster();
		} catch (Exception e) {
			throw new SummarizationException(e.getMessage());
		}
	}

	private void summarizeCluster() throws IOException, SummarizationException {
		setAccumulatingSummary(prepareSummary());
	}

	private String prepareSummary() throws SummarizationException {
		String accumulatingSummary = "";
		while (accumulatingSummary.length() < getMedianCharactersPerAbstract()) {
			Sentence highScoringSentence = findNextBestScoredSentence();
			if (highScoringSentence == null) {
				break;
			} else if (getScoreForSentence(highScoringSentence) >= 0.0d) {
				accumulatingSummary += unPackHighScorer(highScoringSentence)
						+ "\n";
				inActivateHighScorer(highScoringSentence);
				sentenceScorer.scoreAllSentences();
			} else {
				break;
			}
		}
		return accumulatingSummary;
	}

	private void inActivateHighScorer(Sentence highScoringSentence) {
		try {
			highScoringSentence.setIsActive(new Boolean(false));
			updatePojo(highScoringSentence);
			inActivateContributingWords(highScoringSentence);
		} catch (Exception x) {
			x.printStackTrace();
		}
	}

	private String unPackHighScorer(Sentence highScoringSentence) {
		return highScoringSentence.getContent();
	}

	private void updatePojo(Object pojo) {
		Transaction tx = dataSourceManager.getSession().beginTransaction();
		dataSourceManager.getSession().saveOrUpdate(pojo);
		dataSourceManager.getSession().flush();
		tx.commit();
	}

	private double getScoreForSentence(Sentence s) {
		if (isRelativeScoring()) {
			return s.getRelativeScore();
		} else {
			return s.getScore();
		}
	}

	private Sentence findNextBestScoredSentence() {
		if (isRelativeScoring()) {
			return findNextBestRelativelyScoredSentence();
		} else {
			return findNextBestSimplyScoredSentence();
		}
	}

	private Sentence findNextBestSimplyScoredSentence() {
		Criteria sentenceSearcher = dataSourceManager
				.getSession()
				.createCriteria(Sentence.class)
				.add(Restrictions.and(
						Restrictions.eq("cluster", currentCluster),
						Restrictions.eq("isActive", true)))
				.addOrder(Order.desc("score"));
		sentenceSearcher.setMaxResults(1);
		return (Sentence) sentenceSearcher.uniqueResult();
	}
	
	@SuppressWarnings("unused")
	private Sentence findBestSentenceByHql() {
		String queryString = "SELECT s FROM Sentence s where s.cluster = :currentCluster and s.isActive = :isActive ORDER BY s.score desc";
		Query q = dataSourceManager.getSession().createQuery(queryString);
		q.setLong("currentCluster", currentCluster);
		q.setBoolean("isActive", true);
		q.setMaxResults(1);
		return (Sentence) q.uniqueResult();
	}

	private Sentence findNextBestRelativelyScoredSentence() {
		String queryString = "SELECT s FROM Sentence s where s.cluster = :currentCluster and s.isActive = :isActive ORDER BY s.relativeScore desc";
		Query q = dataSourceManager.getSession().createQuery(queryString);
		q.setLong("currentCluster", currentCluster);
		q.setBoolean("isActive", true);
		q.setMaxResults(1);
		return (Sentence) q.uniqueResult();
	}

	private void inActivateContributingWords(Sentence sentence) {
		StringBuffer sb = new StringBuffer();
		sb.append("update \n");
		sb.append("       normalized_word n, \n");
		sb.append("       word_mention w, \n");
		sb.append("       sentence s \n");
		sb.append("set\n");
		sb.append("       n.is_active = false\n");
		sb.append("where\n");
		sb.append("       n.id = w.normalized_word_id and\n");
		sb.append("       w.sentence_id = s.id and\n");
		sb.append("       s.id = ?");
		String sql = sb.toString();
		Transaction tx = dataSourceManager.getSession().beginTransaction();
		SQLQuery query = dataSourceManager.getSession().createSQLQuery(sql);
		query.setLong(0, sentence.getId());
		query.executeUpdate();
		tx.commit();
	}

	@SuppressWarnings("unused")
	private void inActivateContributingWordsOriginal(Sentence sentence) {
		for (NounPhraseMention nounPhraseMention : sentence
				.getNounPhraseMentionCollection()) {
			for (WordMention wordMention : nounPhraseMention
					.getWordMentionCollection()) {
				NormalizedWord normalizedWord = wordMention.getNormalizedWord();
				normalizedWord.setIsActive(false);
				updatePojo(normalizedWord);
			}
		}
	}

	public void setDataSourceManager(DataSourceManager dataSourceManager) {
		this.dataSourceManager = dataSourceManager;
	}

	public int getMedianCharactersPerAbstract() {
		return medianCharactersPerAbstract;
	}

	public void setMedianCharactersPerAbstract(int medianCharactersPerAbstract) {
		this.medianCharactersPerAbstract = medianCharactersPerAbstract;
	}

	public String getOutputDirectoryPath() {
		return outputDirectoryPath;
	}

	public void setOutputDirectoryPath(String outputDirectoryPath) {
		this.outputDirectoryPath = outputDirectoryPath;
	}

	public boolean isRelativeScoring() {
		return isRelativeScoring;
	}

	public void setRelativeScoring(boolean isRelativeScoring) {
		this.isRelativeScoring = isRelativeScoring;
	}

	public String getAccumulatingSummary() {
		return accumulatingSummary;
	}

	public void setAccumulatingSummary(String accumulatingSummary) {
		this.accumulatingSummary = accumulatingSummary;
	}

}
