package edu.pitt.dbmi.edda.pico.tools;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import edu.pitt.dbmi.nlp.noble.extract.model.Template;
import edu.pitt.dbmi.nlp.noble.extract.model.TemplateCreator;
import edu.pitt.dbmi.nlp.noble.extract.model.TemplateFactory;
import edu.pitt.dbmi.nlp.noble.ontology.IOntology;
import edu.pitt.dbmi.nlp.noble.ontology.IOntologyException;
import edu.pitt.dbmi.nlp.noble.terminology.TerminologyException;

public class DomainTemplateCreator {

	/**
	 * create extraction model for a domain in OWL format 
	 * @param inputFile
	 * @param outputFile
	 * @throws TerminologyException 
	 * @throws IOException 
	 * @throws IOntologyException 
	 * @throws FileNotFoundException 
	 */
	public static IOntology createDomainOntology(File inputFile,File outputFile) throws FileNotFoundException, IOntologyException, IOException, TerminologyException{
		// create ontology and save the template
		TemplateCreator termCreator = new TemplateCreator();
		System.out.println("initializing ..");
		IOntology ontology = termCreator.createOntology(inputFile);
		System.out.println("saving ontology "+outputFile.getAbsolutePath()+" ...");
		ontology.write(new FileOutputStream(outputFile),IOntology.OWL_FORMAT);
		return ontology;
	}
	
	/**
	 * create domain template file
	 * @param ontologyFile
	 * @param templateFile
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOntologyException
	 * @throws IOException
	 * @throws TerminologyException
	 * @throws Exception
	 */
	public static Template createDomainTemplate(File ontologyFile, File templateFile) throws FileNotFoundException, IOntologyException, IOException, TerminologyException, Exception{
		TemplateFactory tf = TemplateFactory.getInstance();
		for(Template template : TemplateFactory.importOntologyTemplate(ontologyFile.getAbsolutePath())){
			tf.exportTemplate(template,new FileOutputStream(templateFile));
			return template;
		}
		return null;
	}
	
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		File dataDirectory = new File("/home/tseytlin/Work/EDDA/edda/pico/data");
		File seedTerminology = new File(dataDirectory,"OrganTransplant.txt");
		File outputOntology = new File(dataDirectory,"OrganTransplant.owl");
		File templateFile = new File(dataDirectory,"OrganTransplant.template");
		
		// create domain
		createDomainOntology(seedTerminology, outputOntology);
		// create template
		createDomainTemplate(outputOntology, templateFile);
		
	}

}
