package bullscows;

import java.util.Scanner;

public class GameLoop {
    Generator generator = new Generator();
    Scanner scanner = new Scanner(System.in);
    Grader grader = new Grader();
    int lengthOfSecret = 0;
    int numberOfSimbols = 0;

    public boolean successStart() {
        System.out.println("Input the length of the secret code:");
        if (scanner.hasNextInt()) {
            lengthOfSecret = Integer.parseInt(scanner.nextLine());
        } else {
            System.out.println("Error: " + scanner.nextLine() + "  isn't a valid number.");
            return false;
        }
        System.out.println("Input the number of possible symbols in the code:");
        if (scanner.hasNextInt()) {
            numberOfSimbols = Integer.parseInt(scanner.nextLine());
        } else {
            System.out.println("Error: " + scanner.nextLine() + " isn't a valid number.");
            return false;
        }
        if (lengthOfSecret > numberOfSimbols || lengthOfSecret == 0 || numberOfSimbols == 0) {
            System.out.println("Error: it's not possible to generate a code with a length of " + lengthOfSecret + " with " + numberOfSimbols + " unique symbols.");
            return false;
        }
        if (numberOfSimbols > 36) {
            System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
            return false;
        }
        return true;
    }
    public String start() {
        generator.printReady(lengthOfSecret, numberOfSimbols);
        System.out.println("Okay, let's start a game!");
        String secret = generator.generate(lengthOfSecret, numberOfSimbols);
        return secret;
    }

    public void loop(String secret) {
        int count = 1;
        Pair pair = new Pair();
        while (pair.bulls != secret.length()) {
            System.out.println("Turn " + count + ":");
            String answer = scanner.nextLine();
            pair = grader.grade(secret, answer);
            pair.printPair(secret);
            count++;
        }
        System.out.println("Congratulations! You guessed the secret code.");
    }


}
