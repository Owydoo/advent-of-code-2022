package day2.exo1;

import utils.Parsing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static int win = 6;
    public static int draw = 3;
    public static int loss = 0;

    private static List<Match> linesToMatches(List<String> lines) {
        List<Match> matches = new ArrayList<>();
        for (String line :
                lines) {
            String[] values = line.split(" ");
            matches.add(new Match(values[0], new PlayerInput(values[1])));
        }
        return matches;
    }

    public static void main(String[] args) {
        //https://adventofcode.com/2022/day/2
//        String filename = "src/main/java/day2/inputs/input1.txt";
        String filename = "src/main/java/day2/inputs/input2.txt";

        List<String> lines = Parsing.parseTextFile(filename);

        List<Match> matches = linesToMatches(lines);

        List<Integer> scores = matches.stream().map(Match::getMyScore).toList();

        Integer totalScore = scores.stream().reduce(0, Integer::sum);
        System.out.println("total score : " + totalScore);

        List<Integer> scoresExo2 = matches.stream().map(Match::rigMatch).toList();

        Integer totalScoreExo2 = scoresExo2.stream().reduce(0, Integer::sum);
        System.out.println("total score Exo 2 : " + totalScoreExo2);
    }
}
