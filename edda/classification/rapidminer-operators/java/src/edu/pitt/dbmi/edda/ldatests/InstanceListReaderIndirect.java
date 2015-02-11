package edu.pitt.dbmi.edda.ldatests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import cc.mallet.pipe.SerialPipes;
import cc.mallet.pipe.iterator.CsvIterator;
import cc.mallet.types.Instance;
import cc.mallet.types.InstanceList;

public class InstanceListReaderIndirect implements InstanceListReaderInf {
	
	private static final Logger logger = Logger
			.getLogger(InstanceListReaderIndirect.class);
	
	private final Pattern csvPattern = Pattern
			.compile("^(\\S*)[\\s,]*(\\S*)[\\s,]*(.*)$");

	private String oneInstancePerLineFilePath;
	
	private SerialPipes pipeLine;
	
	private InstanceList instances;

	private TargetCacher targetCacher;

	public InstanceListReaderIndirect() {
		;
	}

	public void readInstances() throws LdaException {
		try {
			logger.debug("reading instances.");
			instances = new InstanceList(pipeLine);
			File oneInstancePerLineFile = new File(oneInstancePerLineFilePath);
			FileInputStream oneInstancePerLineFileInputStream = new FileInputStream(
					oneInstancePerLineFile);
			Reader oneInstancePerLineFileReader = new InputStreamReader(
					oneInstancePerLineFileInputStream, "UTF-8");
			CsvIterator csvIterator = new CsvIterator(
					oneInstancePerLineFileReader, csvPattern, 3, 2, 1);
			instances.addThruPipe(csvIterator); // data,
												// label,
												// name
												// fields
			
			buildTargetCacher();
			
		} catch (UnsupportedEncodingException e) {
			throw new LdaException(e);
		} catch (FileNotFoundException e) {
			throw new LdaException(e);
		}
	}
	
	private void buildTargetCacher() {
		targetCacher = new TargetCacher();
		for (Instance instance : instances) {
			targetCacher.cacheTarget(instance);
		}
	}

	public TargetCacher getTargetCacher() {
		return targetCacher;
	}
	
	public InstanceList getInstances() {
		return instances;
	}

	public void setOneInstancePerLineFilePath(String oneInstancePerLineFilePath) {
		this.oneInstancePerLineFilePath = oneInstancePerLineFilePath;
	}

	public void setPipeLine(SerialPipes pipeLine) {
		this.pipeLine = pipeLine;
	}

	@Override
	public void setTargetLabelFilter(String targetLableFilter) {		
	}

	@Override
	public void setIncludingClassifications(boolean isIncludingClassifications) {
	}

}
