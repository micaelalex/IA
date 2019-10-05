import java.util.*;

public class Individual implements Comparator<Individual>, Comparable<Individual> {

	private String ind;
	private static int chromossomeLength;
	private Double fitness;

	public Individual(String i, Double fit) {
		ind = i;
		fitness = fit;
		chromossomeLength = i.length();
	}
	
	public Individual(String i) {
		ind = i;
		fitness = null;
		chromossomeLength = i.length();
	}

	public double getFitness() {
		return fitness;
	}

	public String getInd() {
		return ind;
	}

	public void setFitness(double fit) {
		fitness = fit;
	}

	public int oneMax() {
		int count = 0;
		for (int i = 0; i < chromossomeLength; i++) {
			if (ind.charAt(i) == '1') {
				count++;
			}
		}
		return count;
	}

	public int fitness() {
		int fitness = 0;
		int decimal = Integer.parseInt(ind, 2);
		fitness = (int) Math.pow(decimal, 2);

		return fitness;
	}

	public String toString() {
		return ind;
	}

	@Override
	public int compareTo(Individual arg0) {
		// TODO Auto-generated method stub
		return this.fitness.compareTo(arg0.fitness);
	}

	@Override
	public int compare(Individual o1, Individual o2) {
		// TODO Auto-generated method stub
		return (int)(o1.fitness - o2.fitness);
	}
}
