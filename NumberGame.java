import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame
 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int totalScore = 0;
        int roundsPlayed = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        boolean playAgain = true;
        while (playAgain) {
            // Set the range and maximum attempts for this round
            int minRange = 1;
            int maxRange = 100;
            int maxAttempts = 5;
            int attempts = 0;

            // Generate a random number between the specified range
            int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;

            System.out.println("\nA random number between " + minRange + " and " + maxRange + " has been generated.");
            System.out.println("You have " + maxAttempts + " attempts to guess the correct number.");

            boolean guessedCorrectly = false;

            // Loop for the allowed number of attempts
            while (attempts < maxAttempts) {
                attempts++;
                System.out.print("Attempt " + attempts + ": Enter your guess: ");
                int guess = scanner.nextInt();

                // Compare guess with the random number
                if (guess == randomNumber) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    totalScore += (maxAttempts - attempts + 1); // Score based on remaining attempts
                    guessedCorrectly = true;
                    break;
                } else if (guess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            // If the player didn't guess the number, show the correct answer.
            if (!guessedCorrectly) {
                System.out.println("You've run out of attempts! The correct number was " + randomNumber);
            }

            // Update rounds played
            roundsPlayed++;

            // Ask the player if they want to play another round
            System.out.print("\nWould you like to play another round? (yes/no): ");
            String response = scanner.next().toLowerCase();
            playAgain = response.equals("yes");

            // Display current score
            System.out.println("Your current score is: " + totalScore);
        }

        // Final score and game summary
        System.out.println("\nGame Over! You played " + roundsPlayed + " rounds with a total score of " + totalScore);
        System.out.println("Thanks for playing!");
        scanner.close();
    }
}

