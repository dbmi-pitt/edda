package edu.pitt.dbmi.edda.summarization;

import java.sql.SQLException;

import org.hibernate.Transaction;

import edu.pitt.dbmi.edda.summarization.rdbms.DataSourceManager;

public class SentenceScorer {

	private DataSourceManager dataSourceManager;
	
	public static void main(String[] args) {
	} 

	public SentenceScorer() {
	}
	
	public void initialize() throws SummarizationException {
		try {
			normalizeWords();
			activateSentences();
			scoreAllSentences();		
		} catch (SQLException se) {
			throw new SummarizationException(se.getMessage());
		} catch (Exception e) {
			throw new SummarizationException(e.getMessage());
		}
	}

	public void scoreAllSentences() throws SummarizationException {
		try {
			dropSentenceFreqs();
			createSentenceFreqs();
			zeroActiveSentences();
			scoreSentences();
		} catch (SQLException e) {
			throw new SummarizationException(e.getMessage());
		}
	}
	
	private void normalizeWords() throws SQLException {
		
		StringBuffer sb = new StringBuffer();
		sb.append("update word_mention set normalized_word_id = null");
		executeUpdateStatement(sb);

		sb = new StringBuffer();
		sb.append("delete from normalized_word\n");
		executeUpdateStatement(sb);
		
		sb = new StringBuffer();
		sb.append("insert into normalized_word (CLUSTER, CONTENT, IS_KEYWORD, FREQ)\n");
		sb.append("	select wm.cluster, \n");
		sb.append("		   wm.stemmed_content,\n");
		sb.append("		   wm.is_keyword,\n");
		sb.append("		   count(*)\n");
		sb.append("		   from word_mention wm \n");
		sb.append("		   where wm.stemmed_content is not null \n");
		sb.append("		   group by wm.cluster, wm.stemmed_content");
		executeUpdateStatement(sb);

		sb = new StringBuffer();
		sb.append("update normalized_word set is_active = true");
		executeUpdateStatement(sb);

		sb = new StringBuffer();
		sb.append("update word_mention wm, normalized_word nw set wm.normalized_word_id = nw.id where wm.stemmed_content = nw.content and wm.cluster = nw.cluster");
		executeUpdateStatement(sb);
	}
	
	private void executeUpdateStatement(StringBuffer sb) throws SQLException {
		Transaction tx = dataSourceManager.getSession().beginTransaction();
		dataSourceManager.getSession().createSQLQuery(sb.toString()).executeUpdate();
		tx.commit();
	}
	
	private void activateSentences() throws SQLException {
		StringBuffer sb = new StringBuffer();
		sb.append("update sentence set is_active = true");
		executeUpdateStatement(sb);
	}
	
	private void dropSentenceFreqs() throws SQLException {
		StringBuffer sb = new StringBuffer();
		sb.append("drop table if exists sentence_freqs");
		executeUpdateStatement(sb);
	}
	
	private void createSentenceFreqs() throws SQLException {
		StringBuffer sb = new StringBuffer();
		sb.append("   create table sentence_freqs as select\n");
		sb.append("		s.id, \n");
		sb.append("		sum(distinct(nw.freq)) freq,\n");
		sb.append("		count(distinct(nw.id)) word_count\n");
		sb.append("   from\n");
		sb.append("	    sentence s,\n");
		sb.append("	    word_mention w,\n");
		sb.append("	    normalized_word nw\n");
		sb.append("    where\n");
		sb.append("        s.is_active = true and\n");
		sb.append("        w.sentence_id = s.id and\n");
		sb.append("        w.normalized_word_id = nw.id and\n");
		sb.append("        nw.is_keyword = true and\n");
		sb.append("        nw.is_active = true\n");
		sb.append("    group by \n");
		sb.append("        s.id\n");
		sb.append("    order by\n");
		sb.append("        s.id");
		executeUpdateStatement(sb);
	}
	
	private void zeroActiveSentences() throws SQLException {
		StringBuffer sb = new StringBuffer();
		sb.append("  update sentence s set \n");
		sb.append("         s.word_count = 0,\n");
		sb.append("         s.score = 0,\n");
		sb.append("         s.relative_score = 0\n");
		sb.append("         where is_active = true\n");
		executeUpdateStatement(sb);
	}
	
	private void scoreSentences() throws SQLException {
		StringBuffer sb = new StringBuffer();
		sb.append("  update sentence s, sentence_freqs sf set \n");
		sb.append("         s.is_active = true, \n");
		sb.append("         s.word_count = sf.word_count,\n");
		sb.append("         s.score = sf.freq,\n");
		sb.append("         s.relative_score = sf.freq / sf.word_count\n");
		sb.append("          where s.id = sf.id\n");
		executeUpdateStatement(sb);
	}
	
	public DataSourceManager getDataSourceManager() {
		return dataSourceManager;
	}

	public void setDataSourceManager(DataSourceManager dataSourceManager) {
		this.dataSourceManager = dataSourceManager;
	}
}
