package edu.pitt.dbmi.edda.lens.digester;

import org.apache.commons.digester3.binder.AbstractRulesModule;

public class RulesEfetch extends AbstractRulesModule {

	@Override
	protected void configure() {

		// http://link.springer.com/content/pdf/10.1007/s10006-005-0605-9.pdf

		forPattern("*/ArticleId").createObject()
				.ofType(ArticleId.class.getName())
				.then().setProperties().then().callMethod("injectValue")
				.usingElementBodyAsArgument().then().setNext("addArticleId");
	}
}