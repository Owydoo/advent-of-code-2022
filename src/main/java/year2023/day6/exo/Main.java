package year2023.day6.exo;

import utils.Parsing;
import year2017.day2.exo.Pair;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        String filename = "src/main/java/year2023/day6/inputs/input.txt";

        List<String> inputLines = Parsing.parseTextFile(filename);

        List<Pair<Integer, Integer>> races = new ArrayList<>();

        String[] timeTab = inputLines.get(0).split("\\s+");
        String[] distanceTab = inputLines.get(1).split("\\s+");

        for (int i = 1; i < timeTab.length; i++) {
            races.add(new Pair<>(Integer.parseInt(timeTab[i]), Integer.parseInt(distanceTab[i])));
        }

        List<Integer> nbPotentialRecords = new ArrayList<>();

        for (Pair<Integer, Integer> race : races) {
            int nbRecordInRace = 0;
            for (int nbSecondsHeldAndSpeed = 0; nbSecondsHeldAndSpeed < race.getFirst(); nbSecondsHeldAndSpeed++) {
                if (nbSecondsHeldAndSpeed * (race.getFirst() - nbSecondsHeldAndSpeed) > race.getSecond()) {
                    nbRecordInRace++;
                }
            }
            nbPotentialRecords.add(nbRecordInRace);
        }

        int answerExo1 = nbPotentialRecords.stream().reduce(1, (a, b) -> a * b);

        System.out.println("exo 1 : " + answerExo1);
    }
}
