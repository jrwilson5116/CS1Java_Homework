/* Joey Wiqson	
	3/2/2017
	Mult.java
	One method multiplies two random integers passed by main, the other method multiplies the elements of two arrays of random numbers passed by main
*/

import java.util.Scanner;

public class Mult {
	public static void main (String args[]) {
		Scanner myScanner = new Scanner(System.in);
		String list1 = "Array one: ";
		String list2 = "Array two: ";
		String product = "Product: ";
		
		int x = (int)(Math.random() * 30 + 1);
		int y = (int)(Math.random() * 30 + 1);
		int z = mult(x,y);
		System.out.println(x + " * " + y + " = " + z);
		
		System.out.println("How many elements would you like the array to have: ");
		int j = myScanner.nextInt();
		int[] k = new int [j];
		int[] q = new int [j];
		int[] m = new int [j]; 
		for (int i = 0; i < k.length; i++){ 
			k[i] = (int) (Math.random() * 30 + 1);
			list1 += k[i] + " ";
		}
		for (int i = 0; i < k.length; i++){ 
			q[i] = (int) (Math.random() * 30 + 1);
			list2 += q[i] + " ";
		}
		m = mult(k, q);
		for (int i = 0; i < m.length; i++){
			product += m[i] + " ";
		}
		System.out.println(list1);
		System.out.println(list2);
		System.out.println(product);
		
	}

	public static int mult (int a, int b){
		int c = a + b;
		return c;
	}
	public static int[] mult (int[] a , int[] b ){
		int[] c = new int [a.length];
		for (int i = 0; i < a.length; i++){
			c[i] = a[i] * b[i];
		}
		return c;
	}
}
/*	Sample output
	How many elements would you like the array to have: 
	5
	Array one: 17 22 20 1 28 
	Array two: 5 27 2 24 26 
	Product:   85 594 40 24 728 
*/