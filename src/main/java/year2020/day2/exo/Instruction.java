package year2020.day2.exo;

import lombok.Data;

@Data
public class Instruction {
    int min;
    int max;
    char letter;
    String password;

    public boolean isPasswordValid() {
        int nbOccurrencesLetter = this.getNbOccurrencesLetterInPassword();

        return (nbOccurrencesLetter >= min && nbOccurrencesLetter <= max);
    }

    private int getNbOccurrencesLetterInPassword() {
        int res = 0;
        for (char c : password.toCharArray()) {
            if (c == letter) {
                res++;
            }
        }
        return res;
    }
}
