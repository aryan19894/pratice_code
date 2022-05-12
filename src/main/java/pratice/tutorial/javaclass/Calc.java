package pratice.tutorial.javaclass;

import java.util.Scanner;

public class Calc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter first input \t");
		int n1 = in.nextInt();

		System.out.println("Please enter second input \t");
		char n2 = in.next().charAt(0);

		if (n2 >= 48 && n2 <= 57) {
			// This is number digit from 0 to 9.
			n1 = 10 * n1 + n2 - 48;
			System.out.println("Please enter operator \t");
			char n21 = in.next().charAt(0);
			System.out.println("Please enter data \t");
			int n3 = in.nextInt();

			switch (n21) {
			case '+':
				System.out.println(n1 + n3);
				break;
			case '-':
				System.out.println(n1 - n3);
				break;
			case '*':
				System.out.println(n1 * n3);
				break;
			case '/':
				System.out.println(n1 / n3);
				break;
			case '%':
				System.out.println(n1 % n3);
				break;
			default:
				System.out.println("Invalid operator");
			}

			// if (n21 == '+')
			// System.out.println(n1 + n3);
			// else if (n21 == '-')
			// System.out.println(n1 - n3);
			// else if (n21 == '*')
			// System.out.println(n1 * n3);
			// else if (n21 == '/')
			// System.out.println(n1 / n3);
			// else if (n21 == '%')
			// System.out.println(n1 % n3);
		} else {
			// operator section
			System.out.println("Please enter data \t");
			int n3 = in.nextInt();

			if (n2 == '+')
				System.out.println(n1 + n3);
			else if (n2 == '-')
				System.out.println(n1 - n3);
			else if (n2 == '*')
				System.out.println(n1 * n3);
			else if (n2 == '/')
				System.out.println(n1 / n3);
			else if (n2 == '%')
				System.out.println(n1 % n3);

		}
	}

}
