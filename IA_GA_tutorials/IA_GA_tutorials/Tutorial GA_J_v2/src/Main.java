import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Individual> newPop = new ArrayList<Individual>();
		
		while(sc.hasNextLine()) {
			String ind = sc.nextLine();
			String[] individuo = ind.split(" ");
			Individual x = new Individual(individuo[0],Double.parseDouble(individuo[1]));
			newPop.add(x);
		}
		
		Collections.sort(newPop, Collections.reverseOrder());
	    //System.out.println("newPop =" + newPop);
		
		Population popul = new Population(newPop);
		
		List<Individual> selected = new ArrayList<Individual>();
		//selected =popul.rouletteSUS();
		selected =popul.roulette();
		selected.sort(Comparator.comparing(Individual::getInd));
		for(int i=0; i<selected.size();i++){
			System.out.println(selected.get(i));
		}
		/*for(Individual i: selected) {
			System.out.println(i);	
		}*/
		sc.close();
	}
	

}
