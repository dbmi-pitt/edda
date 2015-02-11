package edu.pitt.dbmi.edda.operator.regexop.rank;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.regex.Matcher;

import edu.pitt.dbmi.edda.operator.regexop.Annotation;
import edu.pitt.dbmi.edda.operator.regexop.document.DocumentFetcher;
import edu.pitt.dbmi.edda.operator.regexop.document.LabeledDocument;
import edu.pitt.dbmi.edda.operator.regexop.regex.RegularExpression;
import edu.pitt.dbmi.edda.operator.regexop.regex.RegularExpressionList;

public abstract class RankerRegularExpression {
	
	protected boolean isGeneratingDiagnostics = false;
	
	protected RankList ranks =  RankListFactory.newRankerList();
	
	protected DocumentFetcher documentFetcher;
	
	protected RegularExpressionList regularExpressions;

	private boolean isEliminatingSubsumedAnnotations;
	
	private Integer requiredNumberOfNonZeroRanksPerRegEx = 0;
	
	public void execute() {
			documentFetcher.startIteration();
			Long totalComputationTime = 0L;
			Long numberDocumentsProcessedSoFar = 0L;
			while (true) {
				LabeledDocument currentDocument = documentFetcher.getNext();
				if (currentDocument == null) {
					break;
				}
				Date computationStartTime = new Date();
				if (isGeneratingDiagnostics()) {
					System.out.println("Processing document " + currentDocument.documentNumber);
				}
				final TreeSet<Annotation> cumulativeAnnotations = new TreeSet<Annotation>(Annotation.annotationComparator) ;
				for (Iterator<RegularExpression> regExIterator = this.regularExpressions.iterator(); regExIterator.hasNext();) {
					RegularExpression regularExpression = regExIterator.next();
					String documentContent = currentDocument.getContent();
					currentDocument.clearContent();
					cumulativeAnnotations.addAll(findRegExMatches(documentContent, regularExpression)) ;
				}
				if (isGeneratingDiagnostics()) {
					System.out.println("Accumulated " + cumulativeAnnotations.size() + " potentially overlapping annotations.");
				}
				if (isEliminatingSubsumedAnnotations) {
					eliminateSubsumedAnnotations(cumulativeAnnotations) ;
					System.out.println(cumulativeAnnotations.size() + " remain after overlap elimination.");
				}
				ranks.addAll(rankDocument(currentDocument, this.regularExpressions, cumulativeAnnotations)) ;
				if (isGeneratingDiagnostics()) {
					numberDocumentsProcessedSoFar++;
					Date completeTime = new Date();
					Long computationTime = completeTime.getTime() - computationStartTime.getTime();
					totalComputationTime += computationTime;
					Long averageComputationTime = totalComputationTime / numberDocumentsProcessedSoFar;
					System.out.println("Sparse rank list size is " + ranks.size());
					System.out.println("Time to process document is " + computationTime + " milliseconds.");
					System.out.println("Average time per document is " + averageComputationTime + " milliseconds.");
				}
			}
			tallyRegExStatsOverDocumentSet();
			eliminatePredominantlyZeroRankedRegExs() ;
			System.out.println("After eliminating predominantly zero producing regExs there are " + regularExpressions.size() + " regExs.");
			System.out.println("After eliminating predominantly zero producing regExs there are " + ranks.size() + " nonzero ranks.");
	}
	
	private void eliminatePredominantlyZeroRankedRegExs() {
		final RegularExpressionList regExsToEliminate = new RegularExpressionList();
		final ArrayList<Rank> ranksToEliminate = new ArrayList<Rank>() ;
		for (Iterator<RegularExpression> regExIterator = this.regularExpressions.iterator(); regExIterator.hasNext();) {
			RegularExpression regularExpression = regExIterator.next();
			Integer numberOfNonZeroRanks = 0 ;
			ranks.iterate();
			while (ranks.hasNext()) {
				Rank rank = ranks.getNext();
				if (regularExpression == rank.regularExpression) {
					if (rank.value > 0.0d) {
						numberOfNonZeroRanks++;
					}
				}
			}
			if (numberOfNonZeroRanks < requiredNumberOfNonZeroRanksPerRegEx) {
				regExsToEliminate.add(regularExpression) ;
				ranks.iterate();
				while (ranks.hasNext()) {
					Rank rank = ranks.getNext();
					if (regularExpression == rank.regularExpression) {
						ranksToEliminate.add(rank) ;
					}
				}
			}
		}
		regularExpressions.removeAll(regExsToEliminate) ;
		ranks.removeAll(ranksToEliminate) ;
	}

	abstract protected RankList rankDocument(LabeledDocument currentDocument,
			RegularExpressionList regularExpressions, TreeSet<Annotation> cumulativeAnnotations) ;
	
	abstract protected void tallyRegExStatsOverDocumentSet() ;
	
	protected TreeSet<Annotation> filterAnnotsForRegEx(
			RegularExpression regularExpression,
			TreeSet<Annotation> cumulativeAnnotations) {
		final TreeSet<Annotation> annotsForThisRegEx = new TreeSet<Annotation>(Annotation.annotationComparator);
		for (Annotation annotation : cumulativeAnnotations) {
			if (annotation.kind.equals(regularExpression.name)) {
				annotsForThisRegEx.add(annotation) ;
			}
		}
		return annotsForThisRegEx;
	}

	protected TreeSet<Annotation> eliminateSubsumedAnnotations(
			TreeSet<Annotation> cumulativeAnnotations) {
		final ArrayList<Annotation> topLevelAnnotations = new ArrayList<Annotation>();
		final ArrayList<Annotation> subsumedAnnotations = new ArrayList<Annotation>();
		while (!cumulativeAnnotations.isEmpty()) {
			Annotation firstAnnotation = cumulativeAnnotations.first();
			cumulativeAnnotations.remove(firstAnnotation) ;
			topLevelAnnotations.add(firstAnnotation) ;
			final ArrayList<Annotation> localSubsumedAnnotations = new ArrayList<Annotation>();
			for (Annotation annotation : cumulativeAnnotations) {
				if (firstAnnotation.subsumes(annotation)) {
					localSubsumedAnnotations.add(annotation) ;
				}
			}
			subsumedAnnotations.addAll(localSubsumedAnnotations) ;
			cumulativeAnnotations.removeAll(localSubsumedAnnotations);
		}
		cumulativeAnnotations.addAll(topLevelAnnotations) ;
		return cumulativeAnnotations;
	}

	protected TreeSet<Annotation> findRegExMatches(String documentContent,
			RegularExpression regularExpression) {
		Matcher matcher = regularExpression.pattern.matcher(documentContent);
		final TreeSet<Annotation> sortedAnnotations = new TreeSet<Annotation>(
				Annotation.annotationComparator);
		while (matcher.find()) {
			Annotation token = new Annotation();
			token.kind = regularExpression.name;
			token.sPos = new Long(matcher.start());
			token.ePos = new Long(matcher.end());
			token.str = matcher.group();
			sortedAnnotations.add(token);
		}
		return sortedAnnotations;
	}
	
	public boolean isEliminatingSubsumedAnnotations() {
		return isEliminatingSubsumedAnnotations;
	}

	public void setEliminatingSubsumedAnnotations(
			boolean isEliminatingSubsumedAnnotations) {
		this.isEliminatingSubsumedAnnotations = isEliminatingSubsumedAnnotations;
	}
	
	public Integer getRequiredNumberOfNonZeroRanksPerRegEx() {
		return requiredNumberOfNonZeroRanksPerRegEx;
	}

	public void setRequiredNumberOfNonZeroRanksPerRegEx(
			Integer requiredNumberOfNonZeroRanksPerRegEx) {
		this.requiredNumberOfNonZeroRanksPerRegEx = requiredNumberOfNonZeroRanksPerRegEx;
	}
	
	public RankList getRanks() {
		return this.ranks;
	}

	public void setDocumentFetcher(DocumentFetcher documentFetcher) {
		this.documentFetcher = documentFetcher;
	}
	
	public DocumentFetcher getDocumentFetcher() {
		return documentFetcher;
	}

	public RegularExpressionList getRegularExpressions() {
		return regularExpressions;
	}

	public void setRegularExpressions(
			RegularExpressionList regularExpressions) {
		this.regularExpressions = regularExpressions;
	}
	
	public boolean isGeneratingDiagnostics() {
		return isGeneratingDiagnostics;
	}

	public void setGeneratingDiagnostics(boolean isGeneratingDiagnostics) {
		this.isGeneratingDiagnostics = isGeneratingDiagnostics;
	}

	
}
