/* Joey Wilson	
	2/14/2017
	MultTable.java
	
*/

import java.util.Scanner;		

public class MultTable {
	public static void main (String args[]) {
		Scanner myScanner = new Scanner(System.in);
		int size;
		char yn = 'y';
		
		while (yn == 'y'){
			System.out.print("What size would you like the multiplication table to be: ");
			size = myScanner.nextInt();
			while (size < 0){
				System.out.println("\nInvalid input. Try again with a positive integer: ");
				size = myScanner.nextInt();
			}
			System.out.println("*******************************************************************************************");
			System.out.println("Multiplication Table Of Size "+ size);
			System.out.println("*******************************************************************************************");
			System.out.print("  ");
			for (int k = 1; k <= size; k++){
				System.out.printf("%8d",k); //top labels
				}
			System.out.println("\n\n____________________________________________________________________________________________");
			for (int i = 1; i <= size; i++){ //rows
				System.out.printf("%-2d",i); //side labels
								 
				for (int j = 1; j <= size; j++){ //columns
					System.out.printf("%8d",i*j);
				}
				System.out.print("\n\n");	
			}
			System.out.print("Would you like to create another table (y/n): ");
			yn = myScanner.next().trim().charAt(0);
		}
		
		
	}
}


/*	Sample output
What size would you like the multiplication table to be: 10
*******************************************************************************************
Multiplication Table Of Size 10
*******************************************************************************************
         1       2       3       4       5       6       7       8       9      10

____________________________________________________________________________________________
1        1       2       3       4       5       6       7       8       9      10

2        2       4       6       8      10      12      14      16      18      20

3        3       6       9      12      15      18      21      24      27      30

4        4       8      12      16      20      24      28      32      36      40

5        5      10      15      20      25      30      35      40      45      50

6        6      12      18      24      30      36      42      48      54      60

7        7      14      21      28      35      42      49      56      63      70

8        8      16      24      32      40      48      56      64      72      80

9        9      18      27      36      45      54      63      72      81      90

10      10      20      30      40      50      60      70      80      90     100

Would you like to create another table (y/n): y
What size would you like the multiplication table to be: 5
*******************************************************************************************
Multiplication Table Of Size 5
*******************************************************************************************
         1       2       3       4       5

____________________________________________________________________________________________
1        1       2       3       4       5

2        2       4       6       8      10

3        3       6       9      12      15

4        4       8      12      16      20

5        5      10      15      20      25

Would you like to create another table (y/n): n


*/