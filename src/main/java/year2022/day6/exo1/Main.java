package year2022.day6.exo1;

import utils.Parsing;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static final int SMALL_MAKER_LENGTH = 4;
    public static final int BIG_MAKER_LENGTH = 14;

    public static void main(String[] args) {
        String filenameTest = "src/main/java/year2022/day6/inputs/input1.txt";
        String filename = "src/main/java/year2022/day6/inputs/input2.txt";

        List<String> lines = Parsing.parseTextFile(filenameTest);
        System.out.println(lines);

        String input = Parsing.parseInlineTextFileAsString(filename);

        System.out.println("res exo 1 for test inputs : " + getMakerPositions(lines, SMALL_MAKER_LENGTH));
        System.out.println("Actual res exo 1 : " + getFirstMakerPosition(input, SMALL_MAKER_LENGTH));

        System.out.println("res exo 2 for test inputs : " + getMakerPositions(lines, BIG_MAKER_LENGTH));
        System.out.println("Actual res exo 2 : " + getFirstMakerPosition(input, BIG_MAKER_LENGTH));

    }

    private static List<Integer> getMakerPositions(List<String> lines, int makerLength) {
        List<Integer> res = new ArrayList<>();
        for (String line : lines) {
            res.add(getFirstMakerPosition(line, makerLength));
        }
        return res;
    }

    private static Integer getFirstMakerPosition(String input, int makerLength) {
        boolean isMaker;
        for (int i = 0; i <= input.length() - makerLength; i++) {
            String potentialMaker = input.substring(i, i + makerLength);
            isMaker = checkPotentialMaker(potentialMaker, makerLength);
            if (isMaker) return i + makerLength;
        }
        return 0;
    }

    private static boolean checkPotentialMaker(String potentialMaker, int makerLength) {
        for (int index = 0; index < makerLength; index++) {
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
