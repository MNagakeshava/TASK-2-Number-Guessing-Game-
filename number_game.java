import java.util.Random;
import java.util.Scanner;

public class number_game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerBound = 1;
        int upperBound = 100;
        int targetNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;

        int maxAttempts = 10;
        int currentAttempt = 0;

        int score = 0;
        int rounds = 0;

        System.out.println("Welcome to Guess the Number Game!");
        System.out.println("Guess a number between " + lowerBound + " and " + upperBound);

        do {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            currentAttempt++;

            if (userGuess == targetNumber) {
                System.out.println("Congratulations! You guessed the number in " + currentAttempt + " attempts.");
                score += maxAttempts - currentAttempt + 1;
                rounds++;

                System.out.print("Do you want to play again? (yes/no): ");
                String playAgain = scanner.next().toLowerCase();

                if (playAgain.equals("yes")) {
                    targetNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
                    currentAttempt = 0;
                    System.out.println("New round started!");
                    System.out.println("Guess a number between " + lowerBound + " and " + upperBound);
                } else {
                    System.out.println("Thanks for playing! Your total score: " + score);
                }
            } else {
                if (userGuess < targetNumber) {
                    System.out.println("Try again! The number is higher.");
                } else {
                    System.out.println("Try again! The number is lower.");
                }

                if (currentAttempt == maxAttempts) {
                    System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was: " + targetNumber);
                    System.out.print("Do you want to play again? (yes/no): ");
                    String playAgain = scanner.next().toLowerCase();

                    if (playAgain.equals("yes")) {
                        targetNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
                        currentAttempt = 0;
                        System.out.println("New round started!");
                        System.out.println("Guess a number between " + lowerBound + " and " + upperBound);
                    } else {
                        System.out.println("Thanks for playing! Your total score: " + score);
                    }
                }
            }
        } while (currentAttempt < maxAttempts);
    }
}