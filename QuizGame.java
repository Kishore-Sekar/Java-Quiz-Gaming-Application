import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizGame {
    private static final int TIME_LIMIT = 30; // seconds

    public static void main(String[] args) {
        String[][] questions = {
            {"What is the capital of France?", "A) Berlin", "B) Madrid", "C) Paris", "D) Rome", "C"},
            {"Which planet is known as the Red Planet?", "A) Earth", "B) Jupiter", "C) Mars", "D) Venus", "C"},
            {"Who wrote 'To Kill a Mockingbird'?", "A) Harper Lee", "B) Mark Twain", "C) Ernest Hemingway", "D) J.K. Rowling", "A"},
            {"What is the chemical symbol for Gold?", "A) Au", "B) Ag", "C) Pb", "D) Fe", "A"},
            {"In which year did the Titanic sink?", "A) 1905", "B) 1912", "C) 1918", "D) 1923", "B"}
        };

        int score = 0;
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < questions.length; i++) {
            System.out.println("Question " + (i + 1) + ": " + questions[i][0]);
            for (int j = 1; j <= 4; j++) {
                System.out.println(questions[i][j]);
            }

            Timer timer = new Timer();
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    System.out.println("\nTime's up!");
                    scanner.close();
                    System.exit(0);
                }
            };
            timer.schedule(task, TIME_LIMIT * 1000);

            System.out.print("\nYour answer (A/B/C/D): ");
            String answer = scanner.nextLine().toUpperCase();

            timer.cancel(); // Stop the timer

            if (answer.equals(questions[i][5])) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer was: " + questions[i][5] + "\n");
            }
        }

        // Show result
        System.out.println("Quiz Completed!");
        System.out.println("Final Score: " + score + "/" + questions.length);

        scanner.close();
    }
}
