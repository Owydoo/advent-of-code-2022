package year2017.day2.exo;

import utils.Parsing;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        String filename = "src/main/java/year2017/day2/inputs/input1.txt";
        String filename = "src/main/java/year2017/day2/inputs/input2.txt";

        List<String> inputList = Parsing.parseTextFile(filename);

        int resExo1 = getAnswerExo1(inputList);

        System.out.println("res exo 1 : " + resExo1);
    }

    private static int getAnswerExo1(List<String> inputList) {
        int res = 0;
        for (String lineString : inputList) {
            String[] str = lineString.split("\\s+");
            List<Integer> line = Arrays.stream(str).toList().stream().map(Integer::parseInt).toList();
            int min = Collections.min(line);
            int max = Collections.max(line);
            res += max - min;
        }
        return res;
    }


}
