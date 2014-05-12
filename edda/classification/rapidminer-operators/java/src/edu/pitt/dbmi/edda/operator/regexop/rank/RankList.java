package edu.pitt.dbmi.edda.operator.regexop.rank;

import java.util.ArrayList;
import java.util.Comparator;

import edu.pitt.dbmi.edda.operator.regexop.document.LabeledDocument;
import edu.pitt.dbmi.edda.operator.regexop.regex.RegularExpression;

public interface RankList {
	public void initialize();
	public void setComparator(Comparator<Rank> comparator);
	public void iterate();
	public boolean hasNext();
	public Rank getNext();
	public Rank getRankFor(LabeledDocument d, RegularExpression r);
	public RankList getRanksFor(RegularExpression r);
	public RankList getRanksFor(LabeledDocument d);
	public void add(Rank rankToAdd);
	public void addAll(ArrayList<Rank> ranksToAdd);
	public void remove(Rank rankToRemove);
	public void removeAll(ArrayList<Rank> ranksToRemove);
	public void updateRank(Rank rankToUpdate);
	public void addAll(RankList ranksToAdd);
	public int size();
}
