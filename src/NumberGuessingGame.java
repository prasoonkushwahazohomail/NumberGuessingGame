import jdk.swing.interop.SwingInterOpUtils;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();

    private int round = 0;
    private int totalScore = 0;

    public void startGame(){
        System.out.println("====================================");
        System.out.println("        NUMBER GUESSING GAME        ");
        System.out.println("====================================");

        boolean playAgain = true;

        while(playAgain){
            round++;

            System.out.print("\nSelect Difficulty Level: ");
            System.out.println("1. Easy (number: 1- 50, attempts: 10)");
            System.out.println("2. Medium (number: 1 - 100, attempts: 7)");
            System.out.println("3. Hard (number: 1 - 200, attempts: 3)");

            System.out.print("Enter Your Choice: ");

            int choice = scanner.nextInt();

            int maxNumber;
            int maxAttempts;

            switch (choice){
                case 1:
                    maxNumber = 50;
                    maxAttempts = 10;
                    break;
                case 2:
                    maxNumber = 100;
                    maxAttempts = 7;
                    break;
                case 3:
                    maxNumber = 200;
                    maxAttempts = 3;
                    break;
                default:
                    System.out.println("Invalid choice! Medium selected.");
                    maxNumber = 100;
                    maxAttempts = 7;
            }

            int target = random.nextInt(maxNumber) + 1;
            int attempts = 0;
            boolean guessed = false;

            System.out.print("\nEnter a number between 1 and "+ maxNumber+": ");

            while (attempts<maxAttempts){
                System.out.print("\nEnter your guess: ");
                int guess = scanner.nextInt();

                attempts++;

                System.out.println("Attempts: "+attempts+"/"+maxAttempts);

                if(guess>target){
                    System.out.println("Too High!");
                } else if (guess<target) {
                    System.out.println("Too Low!");
                }else {
                    System.out.println("Correct!");
                    System.out.println("You guessed it in "+attempts+ " attempts!");

                    guessed = true;
                    totalScore++;
                    break;
                }

                if(attempts==maxAttempts){
                    System.out.println("\nYou Lost!");
                    System.out.println("Correct number was: "+target);
                }
            }

            System.out.println("\n===========ROUND SUMMARY===========");
            System.out.println("Rounds: "+round);

            if(guessed){
                System.out.println("Guessed in "+attempts+" attempts");
            }else {
                System.out.println("Failed after "+attempts+ " attempts");
            }

            System.out.println("Total round won: "+totalScore);

            System.out.print("\nPlay again? (yes/no): ");
            String answer = scanner.next();

            playAgain = answer.equalsIgnoreCase("yes");
        }

        System.out.println("\n=============================");
        System.out.println("          GAME OVER!            ");
        System.out.println("Total rounds played: "+round);
        System.out.println("Total rounds won: "+totalScore);
        System.out.println("Thank you for playing!");
        System.out.println("\n=============================");

        scanner.close();
    }
}
