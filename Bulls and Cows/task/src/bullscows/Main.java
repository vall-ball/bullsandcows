package bullscows;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameLoop loop = new GameLoop();
        if (loop.successStart()) {
            String secret = loop.start();
            loop.loop(secret);
        }

    }

    public static void printArrayOfChars(char[] array) {
        for (char c : array) {
            System.out.print(c);
        }
    }
}
