package edu.pitt.dbmi.edda.ldatests;

import java.util.Formatter;
import java.util.Locale;

public class PerformanceMeasure {

	public double tp;
	public double fp;
	public double tn;
	public double fn;

	public PerformanceMeasure() {
		;
	}

	public String toString() {

		Formatter out = new Formatter(new StringBuilder(), Locale.US);
		out.format("%n%n%15s%20s%20s%n", "", "actual exclude", "actual include");
		out.format("%15s%15.0f%20.0f%n", "pred exclude: ", tn, fn);
		out.format("%15s%15.0f%20.0f%n%n", "pred include: ", fp, tp);

		String confusionMatrix = out.toString();

		StringBuffer sb = new StringBuffer();
		sb.append(confusionMatrix);

		double precision = tp / (tp + fp);
		double recall = tp / (tp + fn);
		sb.append("(include) precision = " + precision + "\n");
		sb.append("(include) recall = " + recall + "\n");

		precision = tn / (tn + fn);
		recall = tn / (tn + fp);
		sb.append("(exclude) precision = " + precision + "\n");
		sb.append("(exclude) recall = " + recall + "\n");

		return sb.toString();

	}

	public static void main(String[] args) {
		PerformanceMeasure performanceMeasure = new PerformanceMeasure();
		performanceMeasure.tp = 100.0;
		performanceMeasure.fp = 200.0;
		performanceMeasure.tn = 59.0;
		performanceMeasure.fn = 35.0;
		System.out.println(performanceMeasure);

	}
}
