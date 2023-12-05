package year2023.day2.exo;

import utils.Parsing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<String> inputLines = Parsing.parseTextFile("src/main/java/year2023/day2/inputs/input.txt");
//        List<String> inputLines = Parsing.parseTextFile("src/main/java/year2023/day2/inputs/inputTest.txt");

        //group regex avec nombres de la carte à gauche | mes nombres à droites
        int counterExo1 = 0;

        //init map for exo 2
        Map<Integer, Integer> scratchCardsInstances = new HashMap<>();
        for (int i = 1; i <= inputLines.size(); i++) {
            scratchCardsInstances.put(i, 1);
        }

        int cardNumber = 1;
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
            int nbMatchForCard = 0;
            for (Integer myNumber : myNumbers) {
                if (cardNumbers.contains(myNumber)) {
                    nbMatchForCard++;
                }
            }

            //ajouter au compteur 2^(nbMatch-1) -- exo 1
            counterExo1 += (int) Math.pow(2d, (double) (nbMatchForCard - 1));

            //exo 2
            for (int i = 1; i <= nbMatchForCard; i++) {
                scratchCardsInstances.put(
                        cardNumber + i,
                        scratchCardsInstances.get(cardNumber + i) + scratchCardsInstances.get(cardNumber)
                );
                System.out.println("yo");
            }

            cardNumber++;
        }


        System.out.println("counter : " + counterExo1);

        int counterExo2 = scratchCardsInstances.values().stream().reduce(0, Integer::sum);
        System.out.println("counter exo 2 : " + counterExo2);
    }
}
