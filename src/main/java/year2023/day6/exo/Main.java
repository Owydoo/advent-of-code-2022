package year2023.day6.exo;

import utils.Parsing;
import year2017.day2.exo.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        String filename = "src/main/java/year2023/day6/inputs/input.txt";
//        String filename = "src/main/java/year2023/day6/inputs/inputTest.txt";

        List<String> inputLines = Parsing.parseTextFile(filename);

        int answerExo1 = getAnswerExo1(inputLines);

        Pattern numberPattern = Pattern.compile("\\d+");
        List<String> timeListInString = numberPattern.matcher(inputLines.get(0)).results()
                .map(MatchResult::group)
                .toList();
        StringBuilder timeInString = new StringBuilder();
        for (String s : timeListInString) {
            timeInString.append(s);
        }
        int time = Integer.parseInt(timeInString.toString());

        List<String> distanceListInString = numberPattern.matcher(inputLines.get(1)).results()
                .map(MatchResult::group)
                .toList();
        StringBuilder distanceInString = new StringBuilder();
        for (String s : distanceListInString) {
            distanceInString.append(s);
        }
        long distance = Long.parseLong(distanceInString.toString());
        System.out.println(time);
        System.out.println(distance);

        Pair<Long, Long> race = new Pair<>((long) time, distance);

        long nbRecordInRace = 0;
        for (long nbSecondsHeldAndSpeed = 0; nbSecondsHeldAndSpeed < race.getFirst(); nbSecondsHeldAndSpeed++) {
            if (nbSecondsHeldAndSpeed * (race.getFirst() - nbSecondsHeldAndSpeed) > race.getSecond()) {
                nbRecordInRace++;
            }
        }

        System.out.println(nbRecordInRace);


        System.out.println("exo 1 : " + answerExo1);
    }

    private static int getAnswerExo1(List<String> inputLines) {
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
        return nbPotentialRecords.stream().reduce(1, (a, b) -> a * b);
    }
}
