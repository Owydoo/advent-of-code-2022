package year2020.day2.exo;

import lombok.Data;

@Data
public class Instruction {
    int first;
    int second;
    char letter;
    String password;

    public Instruction(String input){
        //input = "x-y c: password"
        String[] inputTab = input.split(" ");

        //inputTab = ["x-y", "c:", "password"]
        String[] ruleTab = inputTab[0].split("-");

        this.first = Integer.parseInt(ruleTab[0]);
        this.second = Integer.parseInt(ruleTab[1]);

        this.letter = inputTab[1].charAt(0);

        this.password = inputTab[2];

    }

    public boolean isPasswordValidForOldJob() {
        int nbOccurrencesLetter = this.getNbOccurrencesLetterInPassword();
        return (nbOccurrencesLetter >= first && nbOccurrencesLetter <= second);
    }

    private int getNbOccurrencesLetterInPassword() {
        return (int) password.chars().filter(value -> value == letter).count();
    }

    public boolean isPasswordValidForOTCP() {
        return (password.charAt(first - 1) == letter ^ password.charAt(second - 1) == letter);
    }
}
