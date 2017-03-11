/**
Joey Wilson
TestDate.java
Lab #8A Due: 03/09/2017
Description: This program prompts the user to input a date and then verifies it.
*/

import javax.swing.*;

// TestDate.java: Demonstrate inputting and verifying a object
public class TestDate1 {
	public static void main(String[] args) {
		Date aDate = new Date();
		/* TODO
		Modify main to run at least once, and then ask the user in a yes/no dialog box
		if they would like to verify another date, and repeat if yes, or exit if no.
		*/
		int ans;

		do {
			if(aDate.getMonth()&&aDate.getDay()&&aDate.getYear()&&aDate.checkDate())
				aDate.displayDate();
			else
				JOptionPane.showMessageDialog(null, "That date is invalid", 
					"TestDate", JOptionPane.INFORMATION_MESSAGE);
				ans = JOptionPane.showConfirmDialog(null,"Would you like to check another date?", "Date Checker",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);

		} while (ans == JOptionPane.YES_OPTION );
		
		System.exit(0);
	}
}

// Define the Date class
class Date {
	public int day;
	public int month; 
	public int year;

	// Get a month from user and verify it
	public boolean getMonth() {
		boolean result = false;
		/* TODO
		Write code here to input the month and force or verify that the user input is either:
			1) an integer from 1 to 12, 
			2) a String that is the full and correct spelling of a month,
			3) or an exact match to the first three letters of a month.
		*/
		int i,num;
		boolean good = false;
		String[] months = {"january","february","march","april","may","june","july","august","september","october","november","december","jan", "feb","mar","apr","jun","jul","aug","sep","oct" ,"nov", "dec"};
		String userInput;
		
		do {
			
			userInput = JOptionPane.showInputDialog(null, "Please enter the month: " , "Month", JOptionPane.QUESTION_MESSAGE);
			try {
				num = Integer.parseInt(userInput);
				good = true;
				if (num > 0 && num < 13){
					month = num;
					result = true;
				}
				
			}
			catch (Exception ex){
				for (i=0;i<23;i++){
					if (months[i] == userInput){
						if (i < 13)
							month = i;
						else 
							month = (i - 12);
						good = true;
						result = true;
					}
				}
			}
			
		} while (!good);
		
		return result;
	}
	
	// Get a day from user and verify it
	public boolean getDay() {
		boolean result = true;
	   /* TODO
		Write code here to input and force or verify that the user input 
		is an integer and in the range of 1 to 31. Store the result in 
		the class data member day if it meets these conditions and return 
		true. Otherwise just return false.	
		*/	
		Object[] numberList = new Object[31];
		for (int d = 0; d < 31; d++){
			numberList[d] = new Integer (d + 1);
		}
		Object numberObject = JOptionPane.showInputDialog(null, "Select the day:", "Day", JOptionPane.QUESTION_MESSAGE,null,numberList,null);
		int number = ((Integer)numberObject).intValue();
		day = number;
		
		return result;		
	}
  
	// Get a year from user and verify it
	public boolean getYear() {
		boolean result = false;
	   /* TODO
		Write code here to input the year and force or verify that the 
		user input is an integer and that it has 4 digits. Store the 
		result in the class data member year if it meets these
		conditions and return true. Otherwise just return false.
		*/
		int yearNum = 1;
		String msg = "";
		while (yearNum/1000 < 1) {
			String yearInput = JOptionPane.showInputDialog(null, "Year");
				try{
					yearNum = Integer.parseInt (yearInput);
					boolean good = true;
					result = true;
					
				}
				catch (Exception ex){
					msg = ex.getMessage();
					msg += "Not an integer \n enter an integer";
				}
		}	
		year = yearNum;
 		return result;
  }
  
	// 
	public boolean checkDate() {
		boolean result = false;
		/* TODO
	   This method does a final check on the validity of the date by 
	   checking that the day does not exceed that allowed for a 
	   parcticular month. Consider using an array of the maximum 
		number of days in each month for comparison. 
		If month is February and day is 29, verification must be done 
		that the the year is really a leap year. Hint: The following 
		will be true if is year is a leap year:
		((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)
		*/
		if (month == 2 && day == 29){
			if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0))
				result = true;

		}else {
			result = true;
		}
		return result;
	}
  
	public void displayDate() {
		/* TODO
		Write code here to display the date as "Verified date is mo/dd/yyyy" in a   
		message dialog with Test Date and your name in the title bar and an information icon.
		*/
		Icon ufo = new ImageIcon("ufo.png");
		String date = String.format("Verified date is: %02d/%02d/%04d",month, day , year);
		JOptionPane.showMessageDialog(null, date , "Date",JOptionPane.INFORMATION_MESSAGE,ufo);
	}
}