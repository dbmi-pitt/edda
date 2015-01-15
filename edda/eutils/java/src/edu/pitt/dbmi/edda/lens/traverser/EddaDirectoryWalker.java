package edu.pitt.dbmi.edda.lens.traverser;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.io.DirectoryWalker;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.IOFileFilter;

public class EddaDirectoryWalker extends DirectoryWalker<Object> {

	private String startDirectoryPath;
	private String[] domains;

	private final Collection<Object> results = new ArrayList<Object>();

	public static void main(String[] args) {
		try {
			tryWalkDirectory();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void tryWalkDirectory() throws IOException {
		IOFileFilter allFiles = FileFilterUtils.trueFileFilter();
		EddaDirectoryWalker walker = new EddaDirectoryWalker(allFiles);
		final String[] domains = { "GALACTOMANNAN" };
		walker.setDomains(domains);
		walker.setStartDirectoryPath(Traverser.CONST_DATA_DIR_PATH);
		walker.walkDirectory();
	}

	public void setStartDirectoryPath(String startDirectoryPath) {
		this.startDirectoryPath = startDirectoryPath;

	}

	public EddaDirectoryWalker(FileFilter filter) {
		super(filter, -1);
	}

	protected boolean handleDirectory(File directory, int depth,
			Collection<Object> results) {
		boolean keepWalking = false;
		if (depth == 0 && directory.getPath().endsWith("DATA")) {
			keepWalking = true;
		} else if (depth == 1 && directory.getPath().endsWith("GALACTOMANNAN")) {
			keepWalking = true;
		} else if (depth == 2
				&& directory.getPath().endsWith("ReferenceFiler_Output")) {
			keepWalking = true;
		} else if (depth == 3 && directory.getPath().endsWith("5050_2xTitles")) {
			keepWalking = true;
		} else if (depth == 4
				&& (directory.getPath().endsWith("A_data")
						|| directory.getPath().endsWith("TRAIN_data") || directory
						.getPath().endsWith("TEST_data"))) {
			keepWalking = true;
		} else if (depth == 5
				&& (directory.getPath().endsWith("FULL_N_a")
						|| directory.getPath().endsWith("FULL_N_test")
						|| directory.getPath().endsWith("FULL_Y_test")
						|| directory.getPath().endsWith("FULL_N_train") || directory
						.getPath().endsWith("FULL_Y_train"))) {
			keepWalking = true;
		}
		return keepWalking;
	}

	protected void handleFile(File file, int depth, Collection<Object> results) {
		if (file.getPath().endsWith(".txt")) {
			results.add(file);
		}

	}

	public void walkDirectory() throws IOException {
		File startDirectory = new File(startDirectoryPath);
		walk(startDirectory, results);
		final ArrayList<File> resultsAsFiles = new ArrayList<File>();
		for (Object fileObj : results) {
			resultsAsFiles.add((File) fileObj);
		}
	}



	public Collection<Object> getResults() {
		return results;
	}

	public String[] getDomains() {
		return domains;
	}

	public void setDomains(String[] domains) {
		this.domains = domains;
	}
}
