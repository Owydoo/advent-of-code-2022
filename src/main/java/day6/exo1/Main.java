package day6.exo1;

import utils.Parsing;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static final int MAKER_LENGTH = 4;

    public static void main(String[] args) {
        String filename = "src/main/java/day6/inputs/input2.txt";

//        List<String> lines = Parsing.parseTextFile(filename);
//        System.out.println(lines);

        String input = Parsing.parseInlineTextFileAsString(filename);

        System.out.println(getFirstMakerPosition(input));


//        List<Integer> firstMakerPositions = getMakerPositions(lines);
//
//        System.out.println(firstMakerPositions);
    }

    private static List<Integer> getMakerPositions(List<String> lines) {
        List<Integer> res = new ArrayList<>();
//        res.add(getFirstMakerPosition(lines.get(0)));
        for (String line : lines) {
            res.add(getFirstMakerPosition(line));
        }
        return res;
    }

    private static Integer getFirstMakerPosition(String input) {
        boolean isMaker;
        for (int i = 0; i <= input.length() - MAKER_LENGTH; i++) {
            String potentialMaker = input.substring(i, i + MAKER_LENGTH);
            System.out.println(potentialMaker);
            isMaker = true;
            for (int j = 0; j < MAKER_LENGTH; j++) {
                StringBuilder builder = new StringBuilder(potentialMaker);
                builder.deleteCharAt(j);
                System.out.println(builder);
                if (builder.toString().contains(String.valueOf(potentialMaker.charAt(j)))) {
                    isMaker = false;
                }
            }
            if (isMaker) return i + MAKER_LENGTH;

        }
        return 0;
    }
}
