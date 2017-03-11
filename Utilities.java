/* Joey Wilson	
	2/7/2017
	Utilities.java
	Stores bill $$$ then totals and averages them
*/

import java.util.Scanner;		

public class Utilities	{
	public static void main (String args[]) {
		Scanner myScanner = new Scanner(System.in);
		String gas = new String("Gas bill(s): ");
		String electric = new String("Electric bill(s): ");
		String phone = new String("Phone bill(s): ");
		double interimBalance, gasTotal = 0, electricTotal = 0, phoneTotal = 0, gasAvg, electricAvg, phoneAvg;
		int billType, numOfGas = 0, numOfElectric = 0, numOfPhone = 0;
		char yesNo = 'y';
		
		while (yesNo == 'y'){
			System.out.println("Please select a utility bill type: \n \t 1) Gas \n \t 2) Electric \n \t 3) Phone");
			billType = myScanner.nextInt();
			while (billType > 3 || billType <1){
				System.out.println("\nInvalid, please try again: \n \t 1) Gas \n \t 2) Electric \n \t 3) Phone");
				billType = myScanner.nextInt();
			}
			System.out.print("\nPlease enter bill amount: $");
			interimBalance = myScanner.nextDouble();
			while (interimBalance > 999.99 || interimBalance < -999.00){
				System.out.println("Invalid, please try again: $");
				interimBalance = myScanner.nextDouble();
			}		
			if (billType == 1){
				numOfGas++;
				gasTotal += interimBalance;
				gas = String.format(gas += "$%.2f \t ", interimBalance);
			}else if (billType == 2){
				numOfElectric++;
				electricTotal += interimBalance;
				electric = String.format(electric += "$%.2f \t ",  interimBalance);
			}else {
				numOfPhone++;
				phoneTotal += interimBalance;
				phone = String.format(phone += "$%.2f \t ", interimBalance);
			}
			System.out.println("Add more bills? y/n");
			yesNo = myScanner.next().trim().charAt(0);
	
		}
		gasAvg = (gasTotal/numOfGas);
		electricAvg = (electricTotal/numOfElectric);
		phoneAvg = (phoneTotal/numOfPhone);
		gas = String.format(gas += ("\n\nThe total gas bill charge is: $%.2f \t" , gasTotal));
		gas = String.format(gas += ("\nYour average gas bill is: $ " , gasAvg));
		electric = String.format(electric +=  ("\n\nThe total electric bill charge is: $%.2f \t" , electricTotal));
		electric = String.format(electric += ("\nYour average gas bill is: $%.2f \t" , electricAvg));
		phone = String.format(phone +=  ("\n\nThe total phone bill charge is: $%.2f \t" , phoneTotal));
		phone = String.format(phone += ("\nYour average phone bill is: $%.2f \t" , phoneAvg ));
		System.out.println(gas);
		System.out.println(electric);
		System.out.println(phone);
		}
}


/*	Sample output
	Please select a utility bill type:
         1) Gas
         2) Electric
         3) Phone
1

Please enter bill amount: $35.75
Add more bills? y/n
y
Please select a utility bill type:
         1) Gas
         2) Electric
         3) Phone
1

Please enter bill amount: $50.35
Add more bills? y/n
y
Please select a utility bill type:
         1) Gas
         2) Electric
         3) Phone
1

Please enter bill amount: $14.99
Add more bills? y/n
y
Please select a utility bill type:
         1) Gas
         2) Electric
         3) Phone
2

Please enter bill amount: $290.33
Add more bills? y/n
y
Please select a utility bill type:
         1) Gas
         2) Electric
         3) Phone
2

Please enter bill amount: $350.75
Add more bills? y/n
y
Please select a utility bill type:
         1) Gas
         2) Electric
         3) Phone
2

Please enter bill amount: $175.50
Add more bills? y/n
y
Please select a utility bill type:
         1) Gas
         2) Electric
         3) Phone
3

Please enter bill amount: $-5.50
Add more bills? y/n
y
Please select a utility bill type:
         1) Gas
         2) Electric
         3) Phone
3

Please enter bill amount: $90.11
Add more bills? y/n
y
Please select a utility bill type:
         1) Gas
         2) Electric
         3) Phone
3

Please enter bill amount: $45.80
Add more bills? y/n
n
Gas bill(s): $ 35.75, $ 50.35, $ 14.99,
The total gas bills charge is: $101.09
Your average gas bill is: $33.7

Electric bill(s): $ 290.33, $ 350.75, $ 175.5,
The total electric bill charge is: $816.58
Your average gas bill is: $272.19

Phone bill(s): $ -5.5, $ 90.11, $ 45.8,
The total phone bill charge is: $130.41
Your average phone bill is: $43.47
*/