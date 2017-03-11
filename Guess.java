/* Joey Wilson
	2/9/2017
	Guessing game program
*/
import java.util.Scanner;

public class Guess {

  public static void main(String[] args) {
	Scanner myScanner = new Scanner(System.in);
	int guess = -1, random, tries = 5;
	boolean yn = true;

    System.out.println("Welcome to the guessing game! Guess a number between 1 and 20 \n") ; 

    while (yn == true){
		random = (int )(Math.random() * 20 + 1);
		while (tries > 0 && guess != random) {
			System.out.println("You have "+ tries +" tries.");
			guess = myScanner.nextInt();
			while (guess > 20 || guess < 1) {
				System.out.println("Invalid guess try again.");
				guess = myScanner.nextInt();

        }

        tries--;
		if (guess > random){
		System.out.println("You guessed too high.");
		}else if (guess < random){
		System.out.println("You guessed too low");
		}
       

      }	

      if (guess == random){

      	System.out.println("You win! Guessed it in "+ (5-tries) +"  tries."); 

      }else {

        System.out.println("You lose.");

      } 

      System.out.println("Would you like to play again?");

      yn = myScanner.nextBoolean();

    }

  }

} 