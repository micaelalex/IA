import java.util.Scanner;

public class Main {

	public static int fitness(String number) {
		int fitness = 0;
		int decimal = Integer.parseInt(number, 2);
		fitness = (int) Math.pow(decimal, 2);

		return fitness;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String number = sc.next();
		int fitness = fitness(number);
		System.out.println(fitness);
		sc.close();
	}
}