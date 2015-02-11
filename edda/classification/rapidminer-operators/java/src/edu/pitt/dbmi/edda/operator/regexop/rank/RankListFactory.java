package edu.pitt.dbmi.edda.operator.regexop.rank;

public class RankListFactory {
	
	public static final String CONST_SPARSE_RANK_LIST = "SPARSE_RANK_LIST";

	public static String useMemoryScheme = CONST_SPARSE_RANK_LIST ;

	public static RankList newRankerList() {
		RankList rankList = null;
		if (useMemoryScheme.equals(CONST_SPARSE_RANK_LIST)) {
			rankList = new SparseRankList();
		} 
		rankList.initialize();
		return rankList;
	}

}
