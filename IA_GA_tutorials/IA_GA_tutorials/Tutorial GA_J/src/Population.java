import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Population {

	private List<Individual> member;
	private static Random generator = new Random(0);

	public Population(List<Individual> m) {
		member = m;
	}

	public List<Individual> getPopulation() {
		return member;
	}

	public Random getGenerator() {
		return generator;
	}

	public void genPopulation(int n, int m) {
		ArrayList<Individual> N = new ArrayList<Individual>();
		String space = "";
		for (int j = 0; j < n; j++) {
			for (int i = 0; i < m; i++) {
				// System.out.println(generator.nextDouble());
				if (generator.nextDouble() < 0.5)
					space += "0";
				else
					space += "1";
			}
			N.add(new Individual(space));
			space = "";
		}
		member = N;
	}

	public String toString() {

		String result = "";
		for (Individual i : member)
			result += i + "\n";
		return result;
	}

	public double sumOfFitness() {
		double allFitness = 0;
		for (Individual i : member) {
			allFitness += i.getFitness();
		}
		return allFitness;
	}

}
