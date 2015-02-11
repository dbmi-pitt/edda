package edu.pitt.dbmi.edda.operator.c45bayes.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import edu.pitt.dbmi.edda.operator.c45bayes.pojos.Experiment;

public class SerializerOfExperiment {

	private String fileName;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public static void main(String... aArguments) {
	}

	public SerializerOfExperiment() {
		;
	}

	public void serialize(Experiment experiment) {
		try {
			OutputStream file = new FileOutputStream(this.fileName);
			OutputStream buffer = new BufferedOutputStream(file);
			ObjectOutput output = new ObjectOutputStream(buffer);
			output.writeObject(experiment);
			output.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public Experiment deSerialize() {
		Experiment experiment = null;
		try {
			File f = new File(this.fileName);
			if (f.exists() & f.isFile()) {
				InputStream file = new FileInputStream(this.fileName);
				InputStream buffer = new BufferedInputStream(file);
				ObjectInput input = new ObjectInputStream(buffer);
				experiment = (Experiment) input.readObject();
				input.close();
			}
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return experiment;
	}

}