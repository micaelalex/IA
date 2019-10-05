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
		double result=0;
		for(Individual i: member)
			result+=i.getFitness();
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
				x += member.get(j).getFitness()/getSumOfFitness();
				if(x >=u) {
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
		for(int i=0; i<member.size(); i++) {
			probability.add(member.get(i).getFitness()/getSumOfFitness());
			//System.out.println(member.get(i).getFitness()/getSumOfFitness());
		}
		
		double distance= 1.0/member.size();
		double y = generator.nextDouble() * distance;
		for(int i=0; i<member.size(); i++) {
			double pointer = y + i * distance;
			//System.out.println(y);
			//System.out.println(distance);
			//System.out.println(pointer);
			double sum = 0;
			for(int j=0; j<member.size(); j++) {
				//System.out.println(probability.get(j));
				sum+= probability.get(j);
				//System.out.println(sum);
				if(sum>=pointer) {
					selected.add(member.get(j));
					//System.out.println(member.get(j));
					break;
				}
					
			}
		}
		return selected;
	}
}
