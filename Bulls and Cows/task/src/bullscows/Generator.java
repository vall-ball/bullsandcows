package bullscows;

import java.util.Arrays;
import java.util.Random;

public class Generator {
    Random random = new Random();
    public static final char[] ARRAYOFCHARS = massOfAscii();

    public String generate(int lengthOfSecret, int lengthOfChars) {
        char[] source = Arrays.copyOf(ARRAYOFCHARS, lengthOfChars);
        char[] arrayOfSecret = shuffleArray(source, lengthOfSecret);
        return new String(arrayOfSecret);

    }

    public char[] shuffleArray(char[] source, int lengthOfSecret) {
        char[] answer = new char[lengthOfSecret];
        char number = source[random.nextInt(source.length)];
        answer[0] = number;
        for (int i = 1; i < answer.length; i++) {
            while (check(Arrays.copyOf(answer, i), number)) {
                number = source[random.nextInt(source.length)];
            }
            answer[i] = number;
        }
        return answer;
    }


    private boolean check(char[] mass, char number) {
        boolean answer = false;
        for (long l : mass) {
            if (l == number) {
                answer = true;
                break;
            }
        }
        return answer;
    }


    private static char[] massOfAscii() {
        char[] mass = new char[36];
        for (int i = 0; i < 10; i++) {
            mass[i] = (char) (i + 48);
        }
        for (int i = 10; i < 36; i++) {
            mass[i] = (char) (i + 87);
        }
        return mass;
    }

    public void printReady(int lengthOfSecret, int numberOfSimbols) {
        StringBuilder builder = new StringBuilder("The secret is prepared: ");
        for (int i = 0; i < lengthOfSecret; i++) {
            builder.append("*");
        }
        builder.append(" (");
        if (numberOfSimbols <=10) {
            builder.append("0-" + ARRAYOFCHARS[numberOfSimbols - 1] + ").");
        } else {
            builder.append("0-9, a-" + ARRAYOFCHARS[numberOfSimbols - 1] + ").");
        }
        System.out.println(builder.toString());
    }

}
