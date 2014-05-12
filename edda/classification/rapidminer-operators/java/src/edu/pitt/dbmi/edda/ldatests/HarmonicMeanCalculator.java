package edu.pitt.dbmi.edda.ldatests;

import java.util.ArrayList;

public class HarmonicMeanCalculator {

	public HarmonicMeanCalculator() {
		;
	}
	
	
	
	private double[] convertDoubleListToArray(ArrayList<Double> listOfDoubles) {
		final double[] arrayOfDoubles = new double[listOfDoubles.size()];
		int entryIdx = 0;
		for (Double entry : listOfDoubles) {
			arrayOfDoubles[entryIdx++] = entry.doubleValue();
		}
		return arrayOfDoubles;
	}
	
	public ArrayList<Double> convertDoubleArrayToList(double[] arrayOfDoubles) {
		final ArrayList<Double> listOfDoubles = new ArrayList<Double>();
		for (double entry : arrayOfDoubles) {
			listOfDoubles.add(entry);
		}
		return listOfDoubles;
	}
	
	public double harmonicMean(ArrayList<Double> listOfDoubles) {
		return harmonicMean(convertDoubleListToArray(listOfDoubles));
	}

	public double harmonicMean(double[] data) {
		double sum = 0.0;
		for (int i = 0; i < data.length; i++) {
			sum += 1.0 / data[i];
		}
		return data.length / sum;
	}

	public static void main(String[] args) {
		double[] x = { 2, 3, 4, 5, 6, 8, 10, 11.53542 };
		HarmonicMeanCalculator calculator = new HarmonicMeanCalculator();
		ArrayList<Double> xArrayList = calculator.convertDoubleArrayToList(x);
		System.out.println("Harmonic Mean = "
				+ calculator.harmonicMean(xArrayList));
	}
}
