import java.util.Random;
import java.util.Scanner;

class GuessTheNumber {
    private int targetNumber;
    private int maxAttempts;
    private int score;
    private boolean gameOver;

    public GuessTheNumber() {
        targetNumber = generateRandomNumber(1, 100);
        maxAttempts = 5;
        score = 0;
        gameOver = false;
    }

    private int generateRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);

        while (!gameOver) {
            System.out.println("\nNew Round - Guess the Number!");
            System.out.println("Score: " + score);
            System.out.println("Attempts Left: " + maxAttempts);

            System.out.print("Enter your guess (1-100): ");
            int guess = scanner.nextInt();

            if (guess < targetNumber) {
                System.out.println("Higher! Try again.");
                maxAttempts--;
            } else if (guess > targetNumber) {
                System.out.println("Lower! Try again.");
                maxAttempts--;
            } else {
                System.out.println("Congratulations! You guessed the number correctly.");
                score += maxAttempts;
                maxAttempts = 5; // Reset max attempts for the next round

                System.out.print("Do you want to play again? (y/n): ");
                String choice = scanner.next();
                if (choice.equalsIgnoreCase("n")) {
                    gameOver = true;
                } else {
                    targetNumber = generateRandomNumber(1, 100);
                }
            }

            if (maxAttempts == 0) {
                System.out.println("Oops! You have run out of attempts.");
                System.out.print("Do you want to play again? (y/n): ");
                String choice = scanner.next();
                if (choice.equalsIgnoreCase("n")) {
                    gameOver = true;
                } else {
                    maxAttempts = 5;
                    targetNumber = generateRandomNumber(1, 100);
                }
            }
        }

        System.out.println("Game Over!");
        System.out.println("Final Score: " + score);
    }
}

public class Game1 {
    public static void main(String[] args) {
        GuessTheNumber game = new GuessTheNumber();
        game.play();
    }
}