import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int roundsPlayed = 0;
        int totalScore = 0;
        boolean playAgain;

        System.out.println("Welcome to the Number Guessing Game!");

        do {
            int generatedNumber = random.nextInt(100) + 1; // Random number between 1 and 100
            int attemptsLeft = 5; // Maximum number of attempts
            boolean guessedCorrectly = false;
            roundsPlayed++;

            System.out.println("\nRound " + roundsPlayed + " starts! You have 5 attempts to guess the number.");

            while (attemptsLeft > 0) {
                System.out.print("Enter your guess (1-100): ");
                int userGuess = scanner.nextInt();

                if (userGuess == generatedNumber) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    totalScore += attemptsLeft; // Score based on remaining attempts
                    guessedCorrectly = true;
                    break;
                } else if (userGuess > generatedNumber) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Too low!");
                }

                attemptsLeft--;
                System.out.println("Attempts left: " + attemptsLeft);
            }

            if (!guessedCorrectly) {
                System.out.println("You ran out of attempts! The correct number was: " + generatedNumber);
            }

            System.out.print("Would you like to play another round? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");

        } while (playAgain);

        System.out.println("\nGame over! Total rounds played: " + roundsPlayed);
        System.out.println("Your total score: " + totalScore);
        System.out.println("Thank you for playing!");

        scanner.close();
    }
}
