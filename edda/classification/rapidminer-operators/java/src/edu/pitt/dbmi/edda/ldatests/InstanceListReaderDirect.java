package edu.pitt.dbmi.edda.ldatests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cc.mallet.pipe.SerialPipes;
import cc.mallet.types.Instance;
import cc.mallet.types.InstanceList;

public class InstanceListReaderDirect implements InstanceListReaderInf {

	private Pattern pattern = Pattern
			.compile("^([\\S~,]+)[\\s,]+([\\S~,]+)[\\s,]+(include|exclude)[\\s,]+(.*)$");

	private String oneInstancePerLineFilePath;
	private SerialPipes pipeLine;

	private InstanceList instances;

	private TargetCacher targetCacher;

	private boolean isIncludingClassifications;

	private String targetLabelFilter;

	public InstanceListReaderDirect() {
		;
	}

	public void readInstances() throws LdaException {
		try {
			targetCacher = new TargetCacher();
			instances = new InstanceList(pipeLine);
			FileReader fileReader = new FileReader(new File(
					oneInstancePerLineFilePath));
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			while (true) {
				String line = bufferedReader.readLine();
				if (line == null) {
					break;
				}
				Matcher matcher = pattern.matcher(line);
				if (matcher.find()) {
					String id = chompComma(matcher.group(1));
					String path = chompComma(matcher.group(2));
					String classification = chompComma(matcher.group(3));
					String text = matcher.group(4);
					if (targetLabelFilter == null
							|| targetLabelFilter.equals(classification)) {
						Instance instanceToAdd = new Instance(text,
								classification, path, null);
						targetCacher.cacheTarget(instanceToAdd);
						if (!isIncludingClassifications) {
							instanceToAdd = new Instance(text, "X", path, null);
						}
						instances.addThruPipe(instanceToAdd);
					}
				}
			}
		} catch (IOException e) {
			throw new LdaException(e);
		}
	}

	private String chompComma(String src) {
		return (src == null) ? src : src.replaceAll(",$", "");
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

	public boolean isIncludingClassifications() {
		return isIncludingClassifications;
	}

	public void setIncludingClassifications(boolean isIncludingClassifications) {
		this.isIncludingClassifications = isIncludingClassifications;
	}

	public void setTargetLabelFilter(String targetLabelFilter) {
		this.targetLabelFilter = targetLabelFilter;
	}

	

}
