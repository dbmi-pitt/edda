package edu.pitt.dbmi.edda.operator.c45bayes.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

import org.apache.commons.lang.StringUtils;

import com.rapidminer.example.Attribute;
import com.rapidminer.example.Example;
import com.rapidminer.example.ExampleSet;

import edu.pitt.dbmi.edda.operator.c45bayes.C45BayesModel;
import edu.pitt.dbmi.edda.operator.c45bayes.comparator.ComparatorOfGene;
import edu.pitt.dbmi.edda.operator.c45bayes.comparator.ComparatorOfSpecimenSporeNumber;

public class Experiment implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private Date runDate;
	private Double numberOfWells = 0.0d;
	private Double meanWell;
	private Double standardDeviationWell;
	private Well maximumWell;
	private Well minimumWell;
	private Double averageLowerBound = 0.0d;
	private Double averageUpperBound = 0.0d;
	private ArrayList<Specimen> specimens = new ArrayList<Specimen>();
	private HashMap<String, Gene> genes = new HashMap<String, Gene>();
	private HashMap<String, Well> sparseWells = new HashMap<String, Well>();


	private Well emptyWell = Well.newWell();
	
	public static Experiment singleton = null;
	
	public static Experiment getInstance(ExampleSet exampleSet) {
		if (singleton == null) {
			singleton = new Experiment(exampleSet);
		}
		return singleton;
	}
	
	public static void clearInstance() {
		singleton = null;
	}

	private Experiment(ExampleSet exampleSet) {
		
		System.out.println("Beginning Experiment Construction.");
		initializeEmptyWell();
		numberOfWells = 0.0d;
		for (Example example : exampleSet) {
			Specimen specimen = Specimen.newSpecimen();
			specimen.setOverAllOutcome(pullLabelFromExample(example));
			for (Attribute attribute : example.getAttributes()) {
				if (attribute.isNumerical()) {
					Gene gene = pullOrCreateGeneForAttribute(attribute);
					double value = example.getValue(attribute);
					numberOfWells++;
					if (value > 0.0d) {
						Well wellToAdd = Well.newWell();
						String key = buildKey(specimen, gene);
						wellToAdd.setAverageValue(value);
						wellToAdd.setKey(key);
						sparseWells.put(key, wellToAdd);
						if (sparseWells.size() % 10000 == 0) {
							System.out.println("Sparse Wells size is " + sparseWells.size());
						}
					}
				}
			}
			specimens.add(specimen);
		}
		System.out.println("Exiting Experiment Construction.");
	}
	
	@SuppressWarnings("unused")
	private void displayStats(ExampleSet exampleSet) {
		int numberOfExamples = exampleSet.size();
		int numberOfAttributes = 0;
		for (Example example : exampleSet) {
			numberOfAttributes = example.getAttributes().size();
			break;
		}
		int totalWells = numberOfExamples * numberOfAttributes;
		System.out.println("Rows = " + numberOfExamples + " Cols = " + numberOfAttributes + " Rows X Cols = " + totalWells) ;
		System.out.println("Number of rows processed = " + numberOfWells);
		System.out.println("Range of well values = [" + minimumWell.getAverageValue() + ", " + maximumWell.getAverageValue() + "]");
		System.out.println("averageLowerBound = " + averageLowerBound);
		System.out.println("averageUpperBound = " + averageUpperBound);
	}

	private void initializeEmptyWell() {
		emptyWell.setAverageValue(1e-4);
		emptyWell.setNominalValue(C45BayesModel.CONST_C45_BAYES_MODEL_FTR_LOW);
	}

	private String buildKey(Specimen specimen, Gene gene) {
		String specimenPart = StringUtils.leftPad(specimen.getId() + "", 10,
				"0");
		String genePart = StringUtils.leftPad(gene.getId() + "", 10, "0");
		return specimenPart + ":" + genePart;
	}

	public Specimen buildSpecimenFromTestExample(Example testExample) {
		Specimen specimen = Specimen.newSpecimen();
		specimen.setOverAllOutcome(pullLabelFromExample(testExample));
		for (Attribute attribute : testExample.getAttributes()) {
			if (attribute.isNumerical()) {
				Gene gene = pullGeneForAttribute(attribute);
				if (gene != null) {
					double value = testExample.getValue(attribute);
					if (value > 0.0d) {
						Well wellToAdd = Well.newWell();
						String key = buildKey(specimen, gene);
						wellToAdd.setAverageValue(value);
						wellToAdd.setKey(key);
						sparseWells.put(key, wellToAdd);
					}
				}
			}
		}
		return specimen;
	}

	private String pullLabelFromExample(Example example) {
		String label = "unknown";
		try {
			Attribute labelAttribute = example.getAttributes().getLabel();
			label = example.getNominalValue(labelAttribute);
		} catch (Exception x) {
			;
		}
		return label;
	}

	private Gene pullOrCreateGeneForAttribute(Attribute attribute) {
		String attributeName = attribute.getName();
		Gene existingGene = genes.get(attributeName);
		if (existingGene == null) {
			existingGene = Gene.newGene();
			existingGene.setName(attributeName);
			genes.put(attributeName, existingGene);
		}
		return existingGene;
	}

	private Gene pullGeneForAttribute(Attribute attribute) {
		String attributeName = attribute.getName();
		Gene existingGene = genes.get(attributeName);
		return existingGene;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getRunDate() {
		return runDate;
	}

	public void setRunDate(Date runDate) {
		this.runDate = runDate;
	}

	public ArrayList<Specimen> getSpecimens() {
		return specimens;
	}

	public void setSpecimens(ArrayList<Specimen> specimens) {
		this.specimens = specimens;
	}

	public HashMap<String, Gene> getGenes() {
		return genes;
	}

	public void setGenes(HashMap<String, Gene> genes) {
		this.genes = genes;
	}

	public void displaySpecimens() {
		TreeSet<Specimen> sortedSpecimens = sortSpecimenBySporeNumber();
		for (Specimen specimen : sortedSpecimens) {
			System.out.println(specimen);
		}
	}

	private TreeSet<Specimen> sortSpecimenBySporeNumber() {
		final TreeSet<Specimen> sortedSpecimens = new TreeSet<Specimen>(
				new ComparatorOfSpecimenSporeNumber());
		sortedSpecimens.addAll(specimens);
		return sortedSpecimens;
	}

	public void displayGenes() {
		Iterator<Gene> geneIterator = sortGenesByName().iterator();
		for (int idx = 0; idx < 100; idx++) {
			System.out.println(geneIterator.next());
		}
	}

	private TreeSet<Gene> sortGenesByName() {
		final TreeSet<Gene> sortedGenes = new TreeSet<Gene>(
				new ComparatorOfGene());
		sortedGenes.addAll(genes.values());
		return sortedGenes;
	}

	public void calculateWellStatitics() {
		meanWell = calculateWellMean();
		standardDeviationWell = calculateWellStandardDeviation(meanWell);
		minimumWell = findMinimumWell();
		maximumWell = findMaximumWell();
		Double range = maximumWell.getAverageValue() - minimumWell.getAverageValue() ;
		averageLowerBound = range / 3.0d;
		averageUpperBound = 2.0d * (range / 3.0d);
	}
	
	public void nominalizeWells() {
		for (Specimen specimen : specimens) {
			for (String geneKey : genes.keySet()) {
				Gene gene = genes.get(geneKey);
				Well well = findWellForGene(specimen, gene);
				if (well == emptyWell) {
					;
				}
				else if (well.getAverageValue() <= averageLowerBound) {
					well.setNominalValue(C45BayesModel.CONST_C45_BAYES_MODEL_FTR_LOW);
				} else if (well.getAverageValue() >= averageUpperBound) {
					well.setNominalValue(C45BayesModel.CONST_C45_BAYES_MODEL_FTR_HGH);
				} else {
					well.setNominalValue(C45BayesModel.CONST_C45_BAYES_MODEL_FTR_AVG);
				}
			}
		}
	}
	
	
	public void nominalizeWellForSpecimen(
			Specimen specimen) {
		for (String geneKey : genes.keySet()) {
			Gene gene = genes.get(geneKey);
			Well well = findWellForGene(specimen, gene);
			if (well == emptyWell) {
				;
			}
			else if (well.getAverageValue() <= averageLowerBound) {
				well.setNominalValue(C45BayesModel.CONST_C45_BAYES_MODEL_FTR_LOW);
			} else if (well.getAverageValue() >= averageUpperBound) {
				well.setNominalValue(C45BayesModel.CONST_C45_BAYES_MODEL_FTR_HGH);
			} else {
				well.setNominalValue(C45BayesModel.CONST_C45_BAYES_MODEL_FTR_AVG);
			}
		}

	}
	
	public void nominalizeWellsWithMeanCutoff() {
		for (Specimen specimen : specimens) {
			for (String geneKey : genes.keySet()) {
				Gene gene = genes.get(geneKey);
				Well well = findWellForGene(specimen, gene);
				if (well == emptyWell) {
					;
				}
				else if (well.getAverageValue() <= averageLowerBound) {
					well.setNominalValue(C45BayesModel.CONST_C45_BAYES_MODEL_FTR_AVG);
				} 
				else {
					well.setNominalValue(C45BayesModel.CONST_C45_BAYES_MODEL_FTR_HGH);
				}
			}
		}
	}
	
	
	public void nominalizeWellForSpecimenWithMeanCutoff(
			Specimen specimen) {
		for (String geneKey : genes.keySet()) {
			Gene gene = genes.get(geneKey);
			Well well = findWellForGene(specimen, gene);
			if (well == emptyWell) {
				;
			}
			else if (well.getAverageValue() <= averageLowerBound) {
				well.setNominalValue(C45BayesModel.CONST_C45_BAYES_MODEL_FTR_AVG);
			} 
			else {
				well.setNominalValue(C45BayesModel.CONST_C45_BAYES_MODEL_FTR_HGH);
			}
		}

	}

	public void nominalizeWellsUsingStandardDeviation() {
		double lowerBoundary = meanWell - standardDeviationWell;
		double upperBoundary = meanWell + standardDeviationWell;
		for (Specimen specimen : specimens) {
			for (String geneKey : genes.keySet()) {
				Gene gene = genes.get(geneKey);
				Well well = findWellForGene(specimen, gene);
				if (well == emptyWell) {
					;
				}
				else if (well.getAverageValue() <= lowerBoundary) {
					well.setNominalValue(C45BayesModel.CONST_C45_BAYES_MODEL_FTR_LOW);
				} else if (well.getAverageValue() >= upperBoundary) {
					well.setNominalValue(C45BayesModel.CONST_C45_BAYES_MODEL_FTR_HGH);
				} else {
					well.setNominalValue(C45BayesModel.CONST_C45_BAYES_MODEL_FTR_AVG);
				}
			}
		}
	}

	public void nominalizeWellForSpecimenUsingStandardDeviation(
			Specimen specimen) {
		double lowerBoundary = meanWell - standardDeviationWell;
		double upperBoundary = meanWell + standardDeviationWell;
		for (String geneKey : genes.keySet()) {
			Gene gene = genes.get(geneKey);
			Well well = findWellForGene(specimen, gene);
			if (well == emptyWell) {
				;
			}
			else if (well.getAverageValue() <= lowerBoundary) {
				well.setNominalValue(C45BayesModel.CONST_C45_BAYES_MODEL_FTR_LOW);
			} else if (well.getAverageValue() >= upperBoundary) {
				well.setNominalValue(C45BayesModel.CONST_C45_BAYES_MODEL_FTR_HGH);
			} else {
				well.setNominalValue(C45BayesModel.CONST_C45_BAYES_MODEL_FTR_AVG);
			}
		}

	}

	private Well findMaximumWell() {
		Well maximumWell = Well.newWell();
		maximumWell.setAverageValue(Double.MIN_VALUE);
		for (Specimen specimen : specimens) {
			for (String geneKey : genes.keySet()) {
				Gene gene = genes.get(geneKey);
				Well well = findWellForGene(specimen, gene);
				if (well.getAverageValue() >= maximumWell.getAverageValue()) {
					maximumWell = well;
				}
			}
		}
		return maximumWell;
	}

	private Well findMinimumWell() {
		Well minimumWell = Well.newWell();
		minimumWell.setAverageValue(Double.MAX_VALUE);
		for (Specimen specimen : specimens) {
			for (String geneKey : genes.keySet()) {
				Gene gene = genes.get(geneKey);
				Well well = findWellForGene(specimen, gene);
				if (well.getAverageValue() <= minimumWell.getAverageValue()) {
					minimumWell = well;
				}
			}
		}
		return minimumWell;
	}

	private double calculateWellStandardDeviation(double wellMean) {
		double sumOfDerivativesSquared = 0;
		double numberOfWells = 0.0d;
		for (Specimen specimen : specimens) {
			for (String geneKey : genes.keySet()) {
				Gene gene = genes.get(geneKey);
				Well well = findWellForGene(specimen, gene);
				sumOfDerivativesSquared += Math.pow(well.getAverageValue()
						- wellMean, 2.0d);
				numberOfWells += 1.0d;
			}
		}
		double wellStandardDeviation = Math.sqrt(sumOfDerivativesSquared
				/ numberOfWells);
		return wellStandardDeviation;
	}

	private double calculateWellMean() {
		double sum = 0.0d;
		double numberOfWells = 0.0d;
		for (Specimen specimen : specimens) {
			for (String geneKey : genes.keySet()) {
				Gene gene = genes.get(geneKey);
				Well well = findWellForGene(specimen, gene);
				sum += well.getAverageValue();
				numberOfWells += 1.0d;
			}
		}
		double mean = sum / numberOfWells;
		return mean;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Experiment:");
		sb.append("\n\tNumber of wells = " + numberOfWells);
		sb.append("\n\tMean over wells = " + meanWell);
		sb.append("\n\tStandard Deviation over wells = "
				+ standardDeviationWell);
		sb.append("\n\tminimumWell = " + minimumWell.getAverageValue());
		sb.append("\n\tmaximumWell = " + maximumWell.getAverageValue());
		sb.append("\n\taverageLowerBound = " + averageLowerBound + "\n");
		sb.append("\n\taverageUpperBound = " + averageUpperBound + "\n");
		sb.append("\n    ");
		return sb.toString();
	}

	private TreeSet<Gene> sortGenes() {
		final TreeSet<Gene> sortedGenes = new TreeSet<Gene>();
		sortedGenes.addAll(genes.values());
		return sortedGenes;
	}

	private void appendWellValuesForSpecimens(StringBuffer sb,
			TreeSet<Gene> sortedGenes) {
		for (Specimen specimen : specimens) {
			sb.append(specimen.getId() + " ");
			for (Gene gene : sortedGenes) {
				Well wellForGene = findWellForGene(specimen, gene);
				sb.append(wellForGene.getNominalValue() + " ");
			}
			sb.append("\n");
		}
	}

	public Well findWellForGene(Specimen specimen, Gene gene) {
		Well resultWell = sparseWells.get(buildKey(specimen, gene)) ;
		if (resultWell == null) {
			resultWell = emptyWell;
		}
		return resultWell;
	}

	private void appendGeneNamesToStringBuffer(StringBuffer sb,
			TreeSet<Gene> sortedGenes) {
		for (Gene gene : sortedGenes) {
			sb.append(gene.getName() + " ");
		}
		sb.append("\n");
	}

	private StringBuffer appendWellToStringBuffer(StringBuffer sb, Well well,
			String label) {
		if (well.getKey() != null) {
			sb.append("\n\t key: ");
			sb.append(well.getKey());
		}
		return sb;
	}

	

}
