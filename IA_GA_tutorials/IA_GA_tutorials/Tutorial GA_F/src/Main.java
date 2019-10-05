import java.util.*;

public class Main {
	
	
	public static ArrayList<ArrayList<String>> genPopulation(Random generator, int n, int m){
		ArrayList<ArrayList<String>> N = new ArrayList<ArrayList<String>>();
		double u;
		//DecimalFormatSymbols unusualSymbols = new DecimalFormatSymbols();
		//unusualSymbols.setDecimalSeparator('.');
		//DecimalFormat df = new DecimalFormat("0.00", unusualSymbols);
		
		for (int j = 0; j < n; j++) {
			ArrayList<String> line = new ArrayList<String>();
			for (int i = 0; i < m; i++) {
				u = generator.nextDouble();
				if (u < 0.5)
					line.add("0");
				else
					line.add("1");
				// System.out.println(df.format(d));
			}
			N.add(line);
			// System.out.println(N);
		}
		return N;
		
	}

	public static void main(String[] args) {
		Random generator = new Random(0);
		Scanner sc = new Scanner(System.in);
		// n is the size of the population
		int n = sc.nextInt();
		// m is the string length
		int m = sc.nextInt();
		
		ArrayList<ArrayList<String>> N = genPopulation(generator, n, m);
		for (ArrayList<String> number : N) {
			for (String digit : number) {
				System.out.print(digit);
			}
			System.out.println();
		}
		sc.close();
	}
}
