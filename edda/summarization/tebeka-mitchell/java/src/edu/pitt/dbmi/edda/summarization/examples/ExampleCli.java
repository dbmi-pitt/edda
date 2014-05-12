package edu.pitt.dbmi.edda.summarization.examples;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class ExampleCli {

	public static void main(String[] args) {
		testAntCommand(args);
		testLsCommand(args);

	}
	
	private static void testAntCommand(String[] args) {
		Option help = new Option("help", "print this message");
		Option projecthelp = new Option("projecthelp",
				"print project help information");
		Option version = new Option("version",
				"print the version information and exit");
		Option quiet = new Option("quiet", "be extra quiet");
		Option verbose = new Option("verbose", "be extra verbose");
		Option debug = new Option("debug", "print debugging information");
		Option emacs = new Option("emacs",
				"produce logging information without adornments");

		Option logfile = OptionBuilder.withArgName("file").hasArg()
				.withDescription("use given file for log").create("logfile");

		Option logger = OptionBuilder.withArgName("classname").hasArg()
				.withDescription("the class which it to perform " + "logging")
				.create("logger");

		Option listener = OptionBuilder
				.withArgName("classname")
				.hasArg()
				.withDescription(
						"add an instance of class as " + "a project listener")
				.create("listener");

		Option buildfile = OptionBuilder.withArgName("file").hasArg()
				.withDescription("use given buildfile").create("buildfile");

		Option find = OptionBuilder
				.withArgName("file")
				.hasArg()
				.withDescription(
						"search for buildfile towards the "
								+ "root of the filesystem and use it")
				.create("find");
		Option property  = OptionBuilder.withArgName( "property=value" )
                .hasArgs(2)
                .withValueSeparator()
                .withDescription( "use value for given property" )
                .create( "D" );
		
		Options options = new Options();

		options.addOption( help );
		options.addOption( projecthelp );
		options.addOption( version );
		options.addOption( quiet );
		options.addOption( verbose );
		options.addOption( debug );
		options.addOption( emacs );
		options.addOption( logfile );
		options.addOption( logger );
		options.addOption( listener );
		options.addOption( buildfile );
		options.addOption( find );
		options.addOption( property );
		
		  // create the parser
	    CommandLineParser parser = new BasicParser();
	    try {
	        // parse the command line arguments
	        CommandLine line = parser.parse( options, args );
	        
	     // has the buildfile argument been passed?
	        if( line.hasOption( "buildfile" ) ) {
	            // initialise the member variable
	             line.getOptionValue( "buildfile" );
	        }
	    }
	    catch( ParseException exp ) {
	        // oops, something went wrong
	        System.err.println( "Parsing failed.  Reason: " + exp.getMessage() );
	    }
	    
	 // automatically generate the help statement
	    HelpFormatter formatter = new HelpFormatter();
	    formatter.printHelp( "ant", options );
	}
	
	private static void testLsCommand(String[] args) {
		// create the command line parser
		CommandLineParser parser = new BasicParser();

		// create the Options
		Options options = new Options();
		options.addOption( "a", "all", false, "do not hide entries starting with ." );
		options.addOption( "A", "almost-all", false, "do not list implied . and .." );
		options.addOption( "b", "escape", false, "print octal escapes for nongraphic "
		                                         + "characters" );
		options.addOption( OptionBuilder.withLongOpt( "block-size" )
		                                .withDescription( "use SIZE-byte blocks" )
		                                .hasArg()
		                                .withArgName("SIZE")
		                                .create() );
		options.addOption( "B", "ignore-backups", false, "do not list implied entried "
		                                                 + "ending with ~");
		options.addOption( "c", false, "with -lt: sort by, and show, ctime (time of last " 
		                               + "modification of file status information) with "
		                               + "-l:show ctime and sort by name otherwise: sort "
		                               + "by ctime" );
		options.addOption( "C", false, "list entries by columns" );

		try {
		    // parse the command line arguments
		    CommandLine line = parser.parse( options, args );

		    // validate that block-size has been set
		    if( line.hasOption( "block-size" ) ) {
		        // print the value of block-size
		        System.out.println( line.getOptionValue( "block-size" ) );
		    }
		}
		catch( ParseException exp ) {
		    System.out.println( "Unexpected exception:" + exp.getMessage() );
		}
		
	    HelpFormatter formatter = new HelpFormatter();
	    formatter.printHelp( "ls", options );
	}
	


}
