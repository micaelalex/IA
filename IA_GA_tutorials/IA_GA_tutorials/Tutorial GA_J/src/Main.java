import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//n=population size
		int n = sc.nextInt();
		//m=chromossome length
		int m= sc.nextInt();
		Population pop =new Population(null);
		pop.genPopulation(n, m);
		for(int i= 0; i<n; i++) {
			pop.getPopulation().get(i).setFitness(sc.nextDouble());
		}
		List<Individual> selected = new ArrayList<Individual>();
		Tournament torneio = new Tournament(pop, n);
		selected = torneio.binaryTournament();
		
		for(Individual i: selected) {
			System.out.println(i);	
		}
		sc.close();
	}
	

}
