import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tournament {
	
	private static Random generator;
	private static int number;
	private static Population pop;
	
	
	public Tournament(Population A, int n) {
		pop = A;
		number = n;
		generator= A.getGenerator();
	}
	
	public Tournament(int n, Population A) {
		pop = A;
		number= A.getPopulation().size()/ n;
		generator= A.getGenerator();
	}
	
	public List<Individual> binaryTournament (){
		List<Individual> selected = new ArrayList<Individual>();
		Individual p1, p2;
		int key1= 0;
		int key2 = 0;
		int a = 0;
		int b = number-1;
		
		for(int i=0; i<number; i++) {
			key1= a + (int)Math.round(generator.nextDouble()*(b-a));
			key2= a + (int)Math.round(generator.nextDouble()*(b-a));
			p1 = pop.getPopulation().get(key1);
			p2 = pop.getPopulation().get(key2);
			
			if(p1.getFitness()>=p2.getFitness())
				selected.add(p1);
			else
				selected.add(p2);
		}
		
		return selected;
	}


}
