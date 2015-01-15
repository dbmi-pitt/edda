package edu.pitt.dbmi.edda.operator.regexop.rank;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;

import edu.pitt.dbmi.edda.operator.regexop.document.LabeledDocument;
import edu.pitt.dbmi.edda.operator.regexop.regex.RegularExpression;

public class SparseRankList implements RankList {

	private HashMap<String, Rank> ranks = new HashMap<String, Rank>() ;
	private Iterator<Rank> rankIterator = null;

	public SparseRankList() {
		;
	}

	@Override
	public void iterate() {
		removeZeros();
		rankIterator = ranks.values().iterator();
	}

	private void removeZeros() {
		final ArrayList<String> zeroRanks = new ArrayList<String>();
		for (String key : ranks.keySet()) {
			Rank rank = ranks.get(key);
			if (rank != null && rank.value <= 0.0d) {
				zeroRanks.add(key);
			}
		}
		ranks.keySet().removeAll(zeroRanks);
	}

	@Override
	public boolean hasNext() {
		return rankIterator.hasNext();
	}

	@Override
	public Rank getNext() {
		return rankIterator.next();
	}

	@Override
	public void add(Rank rankToAdd) {
		if (rankToAdd.value > 0.0d) {
			ranks.put(rankToAdd.key, rankToAdd);
		}
	}

	@Override
	public void addAll(ArrayList<Rank> ranksToAdd) {
		for (Rank rankToAdd : ranksToAdd) {
			add(rankToAdd);
		}

	}

	@Override
	public void remove(Rank rankToRemove) {
		ranks.remove(rankToRemove.key);

	}

	@Override
	public void removeAll(ArrayList<Rank> ranksToRemove) {
		ranks.keySet().removeAll(ranksToRemove);
	}

	@Override
	public void setComparator(Comparator<Rank> comparator) {
		// not implemented
		;

	}

	@Override
	public void updateRank(Rank rankToUpdate) {
		// not implemented
		;
	}

	@Override
	public void addAll(RankList ranksToAdd) {
		ranksToAdd.iterate();
		while (ranksToAdd.hasNext()) {
			add(ranksToAdd.getNext());
		}

	}

	@Override
	public void initialize() {
		;

	}

	@Override
	public Rank getRankFor(LabeledDocument labeledDocument,
			RegularExpression regularExpression) {
		Rank zeroRank = Rank.newRank(labeledDocument, regularExpression);
		Rank existingRank = ranks.get(zeroRank.key);
		if (existingRank == null) {
			existingRank = zeroRank;
			existingRank.value = 0.0d;
		}
		return existingRank;
	}

	@Override
	public RankList getRanksFor(RegularExpression regularExpression) {
		final RankList matchingRanks = new SparseRankList();
		for (String rankKey : ranks.keySet()) {
			if (rankKey.endsWith(regularExpression.key)) {
				Rank matchingRank = ranks.get(rankKey);
				matchingRanks.add(matchingRank);
			}
		}
		return matchingRanks;
	}

	@Override
	public RankList getRanksFor(LabeledDocument labeledDocument) {
		final RankList matchingRanks = new SparseRankList();
		for (String rankKey : ranks.keySet()) {
			if (rankKey.startsWith(labeledDocument.key)) {
				Rank matchingRank = ranks.get(rankKey);
				matchingRanks.add(matchingRank);
			}
		}
		return matchingRanks;
	}

	@Override
	public int size() {
		return ranks.size();
	}

}
