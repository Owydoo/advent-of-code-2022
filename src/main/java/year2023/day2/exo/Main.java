package year2023.day2.exo;

import utils.Parsing;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<String> inputLines = Parsing.parseTextFile("src/main/java/year2023/day2/inputs/input.txt");

        System.out.println(inputLines);

        //group regex avec nombres de la carte à gauche | mes nombres à droites
        int counter = 0;
        for (String inputLine : inputLines) {
            String[] firstTab = inputLine.split(": ");
            String[] secondTab = firstTab[1].split("[|]");
            String[] cardTab = secondTab[0].split("\\s+");
            String[] myNumbersTab = secondTab[1].split("\\s+");

            Set<Integer> cardNumbers = new HashSet<>();
            Set<Integer> myNumbers = new HashSet<>();

            for (String cardString : cardTab) {
                if (!cardString.isEmpty()) {
                    cardNumbers.add(Integer.parseInt(cardString));
                }
            }

            for (String myNumberString : myNumbersTab) {
                if (!myNumberString.isEmpty()) {
                    myNumbers.add(Integer.parseInt(myNumberString));
                }
            }

            //compter le nombre de match
            int currentCounter = 0;
            for (Integer myNumber : myNumbers) {
                if (cardNumbers.contains(myNumber)){
                    currentCounter++;
                }
            }

            //ajouter au compteur 2^(nbMatch-1)
            counter += (int) Math.pow(2d, (double) (currentCounter-1));
        }

        System.out.println("counter : " + counter);
    }
}
