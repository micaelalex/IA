import java.util.Scanner;

public class Main {

	public static int onemax(String number) {
		int count = 0;
		for (int i = 0; i < number.length(); i++) {
			if (number.charAt(i) == '1') {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String number = sc.next();
		int onemax = onemax(number);
		System.out.println(onemax);
		sc.close();
	}
}
