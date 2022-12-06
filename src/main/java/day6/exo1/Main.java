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
            isMaker = checkPotentialMaker(potentialMaker);
            if (isMaker) return i + MAKER_LENGTH;
        }
        return 0;
    }

    private static boolean checkPotentialMaker(String potentialMaker) {
        for (int index = 0; index < MAKER_LENGTH; index++) {
            String tempPotentialMaker = getStringWithoutCharacterAtIndex(potentialMaker, index);
            if (tempPotentialMaker.contains(String.valueOf(potentialMaker.charAt(index)))) {
                return false;
            }
        }
        return true;
    }

    private static String getStringWithoutCharacterAtIndex(String string, int index) {
        StringBuilder builder = new StringBuilder(string);
        return builder.deleteCharAt(index).toString();
    }
}
