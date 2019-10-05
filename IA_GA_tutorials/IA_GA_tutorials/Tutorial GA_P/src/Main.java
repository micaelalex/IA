import java.util.*;

public class Main {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String intgr = sc.nextLine();
		int s = Integer.parseInt(intgr);
		List<Individual> newInd = new ArrayList<Individual>();
		
		while(sc.hasNextLine()) {
			String ind = sc.nextLine();
			String[] individuo = ind.split(" ");
			Individual x = new Individual(individuo[0],Double.parseDouble(individuo[1]));
			newInd.add(x);
		}
		
		Population pop = new Population(newInd);
		List<Individual> selected = new ArrayList<Individual>();
		
		for(int i=0; i<s; i++) {
			Population newPop = pop.RandomPermutation(s);
			List<Individual> select =newPop.tournamentSelection(s);
			
			for(int j=0; j<select.size(); j++) {
				selected.add(select.get(j));
			}
		}
		for(Individual i: selected) {
			System.out.println(i.getInd());	
		}
		
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
