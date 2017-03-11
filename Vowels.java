/* Joey Wilson	
	2/16/2017
	Vowels.java
	Takes a string as input and tells how many of each Vowel is in the string and outputs the string with the Vowels taken out
*/

import javax.swing.JOptionPane;
import java.util.Scanner;

public class Vowels {
	public static void main (String args[]) {
		Scanner myScanner = new Scanner(System.in);
		char yn = 'y';
		
		while (yn == 'y'){
		
			String s = JOptionPane.showInputDialog(null,  "Enter a string ", "Vowels", JOptionPane.QUESTION_MESSAGE);
			s = s.toLowerCase();
			String cons = s;
			String out = "";
			int aCount = 0, eCount = 0, iCount = 0, oCount = 0, uCount = 0,lth;
			
			lth = s.length();
			
			for (int i = 0; i < lth; i++){
				
				if (s.charAt(i) == 'a'){
					aCount++;
				}else if (s.charAt(i) == 'e'){
					eCount++;
				}else if (s.charAt(i) == 'i'){
					iCount++;
				}else if (s.charAt(i) == 'o'){
					oCount++;
				}else if (s.charAt(i) == 'u'){
					uCount++;
				}
				
			}
			cons = cons.replaceAll("a","");
			cons = cons.replaceAll("e","");
			cons = cons.replaceAll("i","");
			cons = cons.replaceAll("o","");
			cons = cons.replaceAll("u","");
			out += " a: " + aCount + " e: " + eCount + " i: " + iCount + " o: " + oCount +" u: "+ uCount + " cons: " + cons;
			
			JOptionPane.showMessageDialog(null, out , "Vowels", JOptionPane.INFORMATION_MESSAGE);
			System.out.print("Would you like to play again? (y/n): ");
			yn = myScanner.next().trim().charAt(0);
		}	
	}
}


/*	Sample output
	Would you like to play again? (y/n): y
	Would you like to play again? (y/n): N
*/