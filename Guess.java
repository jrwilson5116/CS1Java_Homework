/* Joey Wilson
    2/9/2017
    Guessing game program
*/
import java.util.Scanner;

public class Guess {
    public static   void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int guess = -1, random, tries = 5;
        char yn = 'y';
        
        System.out.println("*****************************************************************");
        System.out.println("**Welcome to the guessing game! Guess a number between 1 and 20**");
        System.out.println("*****************************************************************\n\n");

        while (yn == 'y'){
            random = (int   )(Math.random() * 20 + 1);
			tries = 5;
            while   (tries > 0 && guess != random) {
                System.out.println("You have "+ tries +" tries.");
                guess = myScanner.nextInt();
                while (guess    > 20 || guess < 1) {
                    System.out.println("Invalid guess try again.");
                    guess = myScanner.nextInt();
                }
				tries--;
        		if (guess   > random){
        		System.out.println("You guessed too high.");
        		}else   if (guess < random){
        		System.out.println("You guessed too low");
        		}
       		} 
	      	if (guess ==  random){
			System.out.println("You win! Guessed it in "+ (5-tries) +"  tries."); 
			}else {
			System.out.println("You lose.");
			} 
			System.out.println("Would you like to play again? y/n");
			yn = myScanner.next().trim().charAt(0);
		}
	}

} 

/* Sample Output 
*****************************************************************
**Welcome to the guessing game! Guess a number between 1 and 20**
*****************************************************************


You have 5 tries.
10
You guessed too low
You have 4 tries.
15
You guessed too low
You have 3 tries.
17
You guessed too high.
You have 2 tries.
16
You win! Guessed it in 4  tries.
Would you like to play again? y/n
y
You have 5 tries.
25
Invalid guess try again.
1
You guessed too low
You have 4 tries.
2
You guessed too low
You have 3 tries.
3
You guessed too low
You have 2 tries.
4
You guessed too low
You have 1 tries.
5
You guessed too low
You lose.
Would you like to play again? y/n
n

