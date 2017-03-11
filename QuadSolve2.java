/* Joey Wilson	
	2/1/2017
	QuadSolve2.java
	Solves quadratic equation
*/

import java.util.Scanner;

public class QuadSolve2 {
	public static void main (String args[]) {
		Scanner myScanner = new Scanner(System.in);
		double a, b, c, x1, x2;
		
		System.out.println("Please enter three variables");
		a = myScanner.nextDouble();
		b = myScanner.nextDouble();
		c = myScanner.nextDouble();
		
		if (((b * b) - 4 * a * c) == 0) {
			x1 = (-b / (2 * a));
			System.out.println("Output: ");
			System.out.println(x1);
		} else if (((b * b) - 4 * a * c) < 0) {
			System.out.println("Output: ");
			System.out.println(-b+" + i \u221A"+(4 * c - b * b)+"/2" );
			System.out.println(-b+" - i \u221A"+(4 * c - b * b)+"/2" );
					
		} else {
			x1 = (-b + Math.sqrt((b * b) - 4 * a * c)) / (2 * a);
			x2 = (-b - Math.sqrt((b * b) - 4 * a * c)) / (2 * a);
			System.out.println("Output: ");
			System.out.println(x1);
			System.out.println(x2);
		}	
	}
}

/* Sample Output:
	Please enter three variables
	1
	3
	2
	Output: 
	-1.0
	-2.0
	
	Please enter three variables
	1
	2
	3
	Output: 
	-2.0 + i √8.0/2
	-2.0 - i √8.0/2

	Please enter three variables
	1
	2
	1
	Output: 
	-1.0
*/


