/* Joey Wilson	
	1/26/2017
	QuadSolve.java
	Solves quadratic equation
*/

import java.util.Scanner;		

public class QuadSolve {
	public static void main (String args[]) {
		Scanner myScanner = new Scanner(System.in);
		double a, b, c, x1, x2;
		
		System.out.println("Please enter three variables");
		a = myScanner.nextDouble();
		b = myScanner.nextDouble();
		c = myScanner.nextDouble();
		
		x1 = (-b + Math.sqrt((b * b) - 4 * a * c)) / (2 * a);
		x2 = (-b - Math.sqrt((b * b) - 4 * a * c)) / (2 * a);
		
		System.out.println("Output: ");
		System.out.println(x1);
		System.out.println(x2);
	}
}

/*	Sample output

Please enter three variables
1
3
2
Output:
-1.0
-2.0

Please enter three variables
2
-5
2
Output:
2.0
0.5
*/