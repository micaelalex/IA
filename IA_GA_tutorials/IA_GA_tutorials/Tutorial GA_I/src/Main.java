import java.util.*;

public class Main {

	public static ArrayList<ArrayList<String>> genPopulation(Random generator, int n, int m) {
		ArrayList<ArrayList<String>> N = new ArrayList<ArrayList<String>>();
		double u;
		// DecimalFormatSymbols unusualSymbols = new DecimalFormatSymbols();
		// unusualSymbols.setDecimalSeparator('.');
		// DecimalFormat df = new DecimalFormat("0.00", unusualSymbols);

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
			// System.out.println();
		}
		return N;

	}

	public static void main(String[] args) {
		Random generator = new Random(0);
		Scanner sc = new Scanner(System.in);

		// ArrayList<String> input = new ArrayList<String>();
		ArrayList<Double> fitness = new ArrayList<Double>();
		ArrayList<ArrayList<String>> output = new ArrayList<ArrayList<String>>();

		// n is the size of the population
		int n = sc.nextInt();
		// m is the string length
		int m = sc.nextInt();
		ArrayList<ArrayList<String>> N = genPopulation(generator, n, m);

		for (int i = 0; i < n; i++) {
			fitness.add(sc.nextDouble());
		}

		int a = 0;
		int b = n - 1;

		for (int i = 0; i < n; i++) {
			int x = (int) (a + Math.round(generator.nextDouble() * (b - a)));
			int y = (int) (a + Math.round(generator.nextDouble() * (b - a)));
			if (fitness.get(x) >= fitness.get(y)) {
				output.add(N.get(x));
			} else {
				output.add(N.get(y));
			}
		}

		sc.close();

		for (ArrayList<String> number : output) {
			for (String digit : number) {
				System.out.print(digit);
			}
			System.out.println();
		}
	}

}
