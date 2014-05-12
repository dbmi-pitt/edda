package edu.pitt.dbmi.edda.summarization.rdbms;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import edu.pitt.dbmi.edda.summarization.rdbms.pojos.ArticleIdentifier;
import edu.pitt.dbmi.edda.summarization.rdbms.pojos.Document;
import edu.pitt.dbmi.edda.summarization.rdbms.pojos.EndNoteLibraryEntry;
import edu.pitt.dbmi.edda.summarization.rdbms.pojos.EndNoteLibraryOutput;
import edu.pitt.dbmi.edda.summarization.rdbms.pojos.NormalizedNounPhrase;
import edu.pitt.dbmi.edda.summarization.rdbms.pojos.NormalizedWord;
import edu.pitt.dbmi.edda.summarization.rdbms.pojos.NounPhraseMention;
import edu.pitt.dbmi.edda.summarization.rdbms.pojos.Publication;
import edu.pitt.dbmi.edda.summarization.rdbms.pojos.Sentence;
import edu.pitt.dbmi.edda.summarization.rdbms.pojos.WordMention;



public class DataSourceManager {

	private static Logger logger = Logger
			.getLogger(DataSourceManager.class);

	private String hibernateDialect = org.hibernate.dialect.MySQLDialect.class
			.getName();
	private String hibernateDriver = "com.mysql.jdbc.Driver";
	private String hibernateConnectionUrl = "jdbc:mysql://localhost:3306/obpbio1";
	private String hibernateUserName = "edda";
	private String hibernateUserPassword = "edda";

	// Very dangerous to have this set to create or update. Only available for
	// explicit use by the installer or other utility methods. Must always
	// default to null to avoid accidental database modifications.
	private String hibernateHbm2ddlAuto = "none";

	private String hibernateShowSql = "false";
	private String hibernateConnectionIsSecure = "true";

	private Configuration configuration;

	private SessionFactory sessionFactory;

	private Session session;

	public DataSourceManager() {
	}

	/*
	 * Configuration
	 */
	private void buildConfigurationBasedOnMode() {
		buildConfiguration();
		addAnnotatedClsesExplicitly();
	}

    
	/*
	 * Configuration from a list of Pojo Classes.
	 * 
	 * The class list differs depending on whether objects are used for heavy
	 * duty pipeline mechanisms or light weight hub/spoke communications
	 * Essentially COMM objects do not express connectivity to CTRM objects like
	 * OrderSets and Orders. Instead COMM Objects represent a view into the data
	 * model necessary and sufficient to establish nodes, authenticate and
	 * authorize.
	 */
	private void buildConfiguration() {
		configuration = new Configuration();
		configuration.setProperty("hibernate.dialect", getHibernateDialect());
		configuration.setProperty("hibernate.connection.driver_class",
				getHibernateDriver());
		configuration.setProperty("hibernate.show_sql", getHibernateShowSql());
		configuration.setProperty("hibernate.connection.url",
				getHibernateConnectionUrl());
		configuration.setProperty("hibernate.connection.username",
				getHibernateUserName());
		configuration.setProperty("hibernate.connection.password",
				getHibernateUserPassword());

		if (getHibernateHbm2ddlAuto() != null) {
			System.out.println("Setting hibernate.hbm2ddl.auto to " + getHibernateHbm2ddlAuto());
			configuration.setProperty("hibernate.hbm2ddl.auto",
					getHibernateHbm2ddlAuto());
		}
		
	}

	/**
	 * get or create configuration object to further customize it before calling
	 * getSession()
	 */
	public Configuration getConfiguration() {
		if (configuration == null)
			buildConfiguration();
		return configuration;
	}

	private void addAnnotatedClsesExplicitly() {
		configuration.addAnnotatedClass(Publication.class);
		configuration.addAnnotatedClass(ArticleIdentifier.class);
		configuration.addAnnotatedClass(EndNoteLibraryEntry.class);
		configuration.addAnnotatedClass(EndNoteLibraryOutput.class);
		configuration.addAnnotatedClass(Document.class);
		configuration.addAnnotatedClass(Sentence.class);
		configuration.addAnnotatedClass(NormalizedNounPhrase.class);
		configuration.addAnnotatedClass(NormalizedWord.class);
		configuration.addAnnotatedClass(NounPhraseMention.class);
		configuration.addAnnotatedClass(WordMention.class);
	}

	/*
	 * SessionFactory
	 */
	@SuppressWarnings("deprecation")
	private boolean buildSessionFactory(Configuration configuration) {
		sessionFactory = configuration.buildSessionFactory();
		return !sessionFactory.isClosed();
	}

	/*
	 * Session
	 */
	public Session getSession() {
		if (session == null) {
			if (configuration == null) {
				buildConfigurationBasedOnMode();
			}
			if (sessionFactory == null) {
				buildSessionFactory(configuration);
			}
			session = sessionFactory.openSession();
		}
		return session;
	}

	/*
	 * Clean up
	 */
	private void closeSession() throws HibernateException {
		if (session != null && session.isOpen()) {
			session.close();
			session = null;
		}
	}

	private void closeSessionFactory() throws HibernateException {
		if (sessionFactory != null && !sessionFactory.isClosed()) {
			sessionFactory.close();
		}
		sessionFactory = null;
	}

	public void destroy() {
		closeSession();
		closeSessionFactory();
		logger.debug("destroyed CaTIES_DataSourceManager : session and sessionFactory removed.");
	}

	protected void finalize() throws Throwable {
		destroy();
		super.finalize();
	}

	public String getHibernateDialect() {
		return hibernateDialect;
	}

	public void setHibernateDialect(String hibernateDialect) {
		this.hibernateDialect = hibernateDialect;
	}

	public String getHibernateDriver() {
		return hibernateDriver;
	}

	public void setHibernateDriver(String hibernateDriver) {
		this.hibernateDriver = hibernateDriver;
	}

	public String getHibernateConnectionUrl() {
		return hibernateConnectionUrl;
	}

	public void setHibernateConnectionUrl(String hibernateConnectionUrl) {
		this.hibernateConnectionUrl = hibernateConnectionUrl;
	}

	public String getHibernateUserName() {
		return hibernateUserName;
	}

	public void setHibernateUserName(String hibernateUserName) {
		this.hibernateUserName = hibernateUserName;
	}

	public String getHibernateUserPassword() {
		return hibernateUserPassword;
	}

	public void setHibernateUserPassword(String hibernateUserPassword) {
		this.hibernateUserPassword = hibernateUserPassword;
	}

	public String getHibernateHbm2ddlAuto() {
		return hibernateHbm2ddlAuto;
	}

	public void setHibernateHbm2ddlAuto(String hibernateHbm2ddlAuto) {
		this.hibernateHbm2ddlAuto = hibernateHbm2ddlAuto;
	}

	public String getHibernateShowSql() {
		return hibernateShowSql;
	}

	public void setHibernateShowSql(String hibernateShowSql) {
		this.hibernateShowSql = hibernateShowSql;
	}

	public String getHibernateConnectionIsSecure() {
		return hibernateConnectionIsSecure;
	}

	public void setHibernateConnectionIsSecure(
			String hibernateConnectionIsSecure) {
		this.hibernateConnectionIsSecure = hibernateConnectionIsSecure;
	}

}
