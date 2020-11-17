package bullscows;

public class Grader {

    public Pair grade(String secret, String answer) {
        char[] secretMass = secret.toCharArray();
        char[] answerMass = answer.toCharArray();
        Pair pair = new Pair();

        for (int i = 0; i < secretMass.length; i++) {
            if (secretMass[i] == answerMass[i]) {
                pair.bulls++;
            }
        }

        for (int i = 0; i < secretMass.length; i++) {
            for (int j = 0; j < secretMass.length; j++) {
                if (secretMass[i] == answerMass[j]) {
                    pair.cows++;
                }
            }
        }
        pair.cows = pair.cows - pair.bulls;
        return pair;
    }
}
