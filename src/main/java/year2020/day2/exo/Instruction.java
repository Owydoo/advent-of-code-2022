package year2020.day2.exo;

import lombok.Data;

@Data
public class Instruction {
    int first;
    int second;
    char letter;
    String password;

    public boolean isPasswordValidForOldJob() {
        int nbOccurrencesLetter = this.getNbOccurrencesLetterInPassword();

        return (nbOccurrencesLetter >= first && nbOccurrencesLetter <= second);
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

    public boolean isPasswordValidForOTCP() {
        return (password.charAt(first - 1) == letter ^ password.charAt(second - 1) == letter);
    }
}
