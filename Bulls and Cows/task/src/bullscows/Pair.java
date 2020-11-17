package bullscows;

public class Pair {
    public int bulls = 0;
    public int cows = 0;

    public void printPair(String secret) {
        if (bulls == 0 && cows == 0) {
            System.out.println("Grade: None.");
        }  else if (cows == 0) {
            System.out.println("Grade: " + bulls + " bull(s).");
        } else if (bulls == 0) {
            System.out.println("Grade: " +cows + " cow(s).");
        } else {
            System.out.println("Grade: " + bulls + " bull(s) and " + cows + " cow(s).");
        }
    }

}
