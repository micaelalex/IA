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

	public double getSumOfFitness() {
		double result = 0;
		for (Individual i : member)
			result += i.getFitness();
		return result;
	}

	public String toString() {

		String result = "";
		for (Individual i : member)
			result += i + "\n";
		return result;
	}

	public List<Individual> roulette() {
		List<Individual> newPop = new ArrayList<Individual>();
		double u;

		for (int i = 0; i < member.size(); i++) {
			u = generator.nextDouble();
			double x = 0;
			for (int j = 0; j < member.size(); j++) {
				x += member.get(j).getFitness() / getSumOfFitness();
				if (x >= u) {
					newPop.add(member.get(j));
					break;
				}
			}
		}

		return newPop;
	}

	public List<Individual> rouletteSUS() {
		List<Individual> selected = new ArrayList<Individual>();
		ArrayList<Double> probability = new ArrayList<Double>();
		for (int i = 0; i < member.size(); i++) {
			probability.add(member.get(i).getFitness() / getSumOfFitness());
			// System.out.println(member.get(i).getFitness()/getSumOfFitness());
		}

		double distance = 1.0 / member.size();
		double y = generator.nextDouble() * distance;
		for (int i = 0; i < member.size(); i++) {
			double pointer = y + i * distance;
			// System.out.println(y);
			// System.out.println(distance);
			// System.out.println(pointer);
			double sum = 0;
			for (int j = 0; j < member.size(); j++) {
				// System.out.println(probability.get(j));
				sum += probability.get(j);
				// System.out.println(sum);
				if (sum >= pointer) {
					selected.add(member.get(j));
					// System.out.println(member.get(j));
					break;
				}

			}
		}
		return selected;
	}

	public List<Individual> onePointCrossover() {
		List<Individual> population = new ArrayList<Individual>();
		String parent01 = member.get(0).getInd();
		String parent02 = member.get(1).getInd();
		int size = parent01.length();
		int a = 0;
		int b = size;
		int cross_point = a + (int) Math.round(generator.nextDouble() * b - a);
		// System.out.println(size);
		// System.out.println(generator.nextDouble());
		// System.out.println(cross_point);
		String child1 = parent01.substring(0, cross_point) + parent02.substring(cross_point, size);
		String child2 = parent02.substring(0, cross_point) + parent01.substring(cross_point, size);
		population.add(new Individual(child1));
		population.add(new Individual(child2));

		return population;
	}

	public List<Individual> uniformCrossover(){
		List<Individual> population = new ArrayList<Individual>();
		String parent1 = member.get(0).getInd();
		String parent2 = member.get(1).getInd();
		int size = parent1.length();
		//int a = 0;
		//int b = size;
		String child1 = "";
		String child2 = "";
		//System.out.println(size);
		//System.out.println(generator.nextDouble());
		//System.out.println(cross_point);
		for(int i=0; i<=size-1; i++) {
			double r = generator.nextDouble();
			//System.out.println(r);
			if(r>=0.5) {
				child1 += parent1.charAt(i);
				child2 += parent2.charAt(i);
		}
			else {
				child1 +=parent2.charAt(i);
				child2 +=parent1.charAt(i);
			}
	}
		population.add(new Individual(child1));
		population.add(new Individual(child2));
		
		return population;
	}
	
	public Individual bitFlipMutation(double pm){
		String parent1 = member.get(0).getInd();
		int size = parent1.length();
		String child1 = "";
		for(int i=0; i<=size-1; i++) {
			double r = generator.nextDouble();
			if(r<pm) {
					child1 += parent1.charAt(i) == '0' ? '1' : '0';
				}
			else {
				child1 +=parent1.charAt(i);
			}
	}
		
		return new Individual(child1);
	}
	
	
}
