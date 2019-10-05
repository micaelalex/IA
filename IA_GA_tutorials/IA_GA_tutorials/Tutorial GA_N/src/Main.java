import java.util.*;

public class Main {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		
		double pm = Double.parseDouble(sc.next());
		Individual parent = new Individual(sc.next());
		List<Individual> list = new ArrayList<>();
		list.add(parent);
		Population pop = new Population(list);
		
		System.out.println(pop.bitFlipMutation(pm));
		sc.close();
		
		/*List<Individual> pop = new ArrayList<Individual>();
		Individual parent1 = new Individual (sc.next());
		Individual parent2 = new Individual (sc.next());
		pop.add(parent1);
		pop.add(parent2);
		Population popul = new Population(pop);
		
		List<Individual> newPop = popul.uniformCrossover();
		
		for(Individual i: newPop) {
			System.out.println(i);	
		}
		
		sc.close();
		*/
		/*while(sc.hasNextLine()) {
			String ind = sc.nextLine();
			String[] individuo = ind.split(" ");
			Individual x = new Individual(individuo[0],Double.parseDouble(individuo[1]));
			newPop.add(x);
		}*/
		
		//Collections.sort(newPop, Collections.reverseOrder());
		
		//Population popul = new Population(newPop);
		
		//List<Individual> selected = new ArrayList<Individual>();
		//selected =popul.rouletteSUS();
		//selected.sort(Comparator.comparing(Individual::getInd));
		//for(int i=0; i<selected.size();i++){
		//	System.out.println(selected.get(i));
		//}
	
	}
	

}
