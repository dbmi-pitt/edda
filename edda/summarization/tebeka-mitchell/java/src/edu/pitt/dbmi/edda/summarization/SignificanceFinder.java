package edu.pitt.dbmi.edda.summarization;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import edu.pitt.dbmi.edda.summarization.rdbms.DataSourceManager;


public class SignificanceFinder {

	private DataSourceManager dataSourceManager;
	private Connection conn = null;

	public static void main(String[] args) {
	}

	public SignificanceFinder(DataSourceManager dataSourceManager) {
		this.dataSourceManager = dataSourceManager;
	}
	
	public void execute() {
		try {
			openJdbcConnection();
//			System.out.println("Normalizing words...");
			normalizeWords();
//			System.out.println("Assigning Significance...");
			determineSignificance();
			closeJdbcConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	private void openJdbcConnection() {
		try {
			Class.forName(dataSourceManager.getHibernateDriver());
			this.conn = DriverManager.getConnection(dataSourceManager.getHibernateConnectionUrl(),
					dataSourceManager.getHibernateUserName(), dataSourceManager.getHibernateUserPassword());
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void closeJdbcConnection() {
		try {
			this.conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
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
		sb.append("insert into normalized_word (CLUSTER, CONTENT, FREQ)\n");
		sb.append("	select wm.cluster, \n");
		sb.append("		   wm.stemmed_content,\n");
		sb.append("		   count(*)\n");
		sb.append("		   from word_mention wm \n");
		sb.append("		   group by wm.cluster, wm.stemmed_content");
		executeUpdateStatement(sb);

		sb = new StringBuffer();
		sb.append("update normalized_word set is_active = false");
		executeUpdateStatement(sb);

		sb = new StringBuffer();
		sb.append("update word_mention wm, normalized_word nw set wm.normalized_word_id = nw.id where wm.stemmed_content = nw.content and wm.cluster = nw.cluster");
		executeUpdateStatement(sb);
	}

	private void determineSignificance() throws SQLException {
		for (int cluster = 0; cluster < 10; cluster++) {
			rankCluster(cluster);
			findSignificance(cluster);
			activateSignificantWords();
		}
	}

	private void activateSignificantWords() throws SQLException {
		StringBuffer sb = new StringBuffer();
		sb.append("update normalized_word nw, significance s set nw.is_active = s.is_active");
		sb.append("				where nw.id = s.id");
		executeUpdateStatement(sb);
	}

	private void rankCluster(int cluster) throws SQLException {
		StringBuffer sb = new StringBuffer();
		sb.append("drop table if exists percentages");
		executeUpdateStatement(sb);
		
		sb = new StringBuffer();
		sb.append("create table percentages as SELECT\n");
		sb.append("  nw.id as id, \n");
		sb.append("  nw.cluster as cluster, \n");
		sb.append("  nw.content as content, \n");
		sb.append("  nw.freq as freq,\n");
		sb.append("  @prev := @curr AS prev,\n");
		sb.append("  @curr := freq AS curr,\n");
		sb.append("  @rank := IF(@prev = @curr, @rank, @rank+1) AS rank\n");
		sb.append("FROM\n");
		sb.append("  normalized_word nw,\n");
		sb.append("  (SELECT @curr := null, @prev := null, @rank := 0) sel1\n");
		sb.append("WHERE\n");
		sb.append("  cluster = ?\n");
		sb.append("ORDER BY freq DESC");
		PreparedStatement pStmt = conn.prepareStatement(sb.toString());
		pStmt.setInt(1, cluster);
		pStmt.executeUpdate();
		pStmt.close();

		sb = new StringBuffer();
		sb.append("ALTER TABLE percentages MODIFY rank double\n");
		executeUpdateStatement(sb);
	}

	private void findSignificance(int cluster) throws SQLException {
		StringBuffer sb = new StringBuffer();
		sb.append("drop table if exists significance\n");
		executeUpdateStatement(sb);
		
		sb = new StringBuffer();
		sb.append("create table significance as SELECT\n");
		sb.append("  p.id as id, \n");
		sb.append("  p.cluster as cluster, \n");
		sb.append("  p.content as content, \n");
		sb.append("  p.freq as freq,\n");
		sb.append("  p.rank as rank,\n");
		sb.append("  @isActive := IF(p.rank > @bottomFive AND p.rank < @topFive, true, false) AS is_active\n");
		sb.append("FROM\n");
		sb.append("  percentages p,\n");
		sb.append("  (select @bottomFive := floor(0.1 * count(distinct(rank))), \n");
		sb.append("          @topFive := ceil(.9 * count(distinct(rank))) from percentages) sel1\n");
		sb.append("WHERE\n");
		sb.append("  cluster = ?\n");
		sb.append("ORDER BY p.rank DESC\n");
		
		PreparedStatement pStmt = conn.prepareStatement(sb.toString());
		pStmt.setInt(1, cluster);
		pStmt.executeUpdate();
		pStmt.close();
	}

	private void executeUpdateStatement(StringBuffer sb) throws SQLException {
		PreparedStatement pStmt = conn.prepareStatement(sb.toString());
		pStmt.executeUpdate();
		pStmt.close();
	}

}
