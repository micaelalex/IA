import java.util.*;

public class Main {
	
	public static void generateRandomPermutation(List<Integer> v) {
		Random generator = new Random(0);
		int size = v.size();
		double u;
		for(int i = 0; i<size-1 ; i++) {
			u=  generator.nextDouble();
			int r = (int)(i+Math.round(u*(size-1-i)));
			Collections.swap(v, r, i);
		}		
}

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        List<Integer> v = new ArrayList<Integer>(size);
        
        for(int i =0; i<size; i++) {
			v.add(i);
		}
        generateRandomPermutation(v);
        for(int i=0; i<size; i++ ) {
        	System.out.println(v.get(i));
        }        
        sc.close();	
	}
}