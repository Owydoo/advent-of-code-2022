package year2017.day2.exo;

import utils.Parsing;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        String filename = "src/main/java/year2017/day2/inputs/input1.txt";
//        String filename = "src/main/java/year2017/day2/inputs/inputTest2.txt";
        String filename = "src/main/java/year2017/day2/inputs/input2.txt";

        List<String> inputList = Parsing.parseTextFile(filename);

        int resExo1 = getAnswerExo1(inputList);
        System.out.println("res exo 1 : " + resExo1);

        int resExo2 = getAnswerExo2(inputList);
        System.out.println("res exo 2 : " + resExo2);
    }

    private static int getAnswerExo2(List<String> inputList) {
        int res = 0;
        for (String lineString : inputList) {
            String[] str = lineString.split("\\s+");
            List<Integer> line = Arrays.stream(str).map(Integer::parseInt).toList();
            Pair<Integer, Integer> divisibles = getTheTwoWhichAreEvenlyDivisible(line);
            int maxDivisible = Math.max(divisibles.getFirst(), divisibles.getSecond());
            int minDivisible = Math.min(divisibles.getFirst(), divisibles.getSecond());
            res += maxDivisible / minDivisible;
        }
        return res;
    }

    private static Pair<Integer, Integer> getTheTwoWhichAreEvenlyDivisible(List<Integer> line) {
        for (int i = 0; i < line.size(); i++) {
            for (int j = i + 1; j < line.size(); j++) {
                if (i != j && (line.get(i) % line.get(j) == 0 || line.get(j) % line.get(i) == 0)) {
                    return new Pair<>(line.get(i), line.get(j));
                }
            }
        }
        throw new IllegalArgumentException();
    }

    private static int getAnswerExo1(List<String> inputList) {
        int res = 0;
        for (String lineString : inputList) {
            String[] str = lineString.split("\\s+");
            List<Integer> line = Arrays.stream(str).map(Integer::parseInt).toList();
            int min = Collections.min(line);
            int max = Collections.max(line);
            res += max - min;
        }
        return res;
    }


}
