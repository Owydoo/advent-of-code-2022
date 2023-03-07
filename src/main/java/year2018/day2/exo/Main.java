package year2018.day2.exo;

import utils.Parsing;
import year2017.day2.exo.Pair;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
//        String filename = "src/main/java/year2018/day2/inputs/input1.txt";
        String filename = "src/main/java/year2018/day2/inputs/input2.txt";

        List<String> inputStringList = Parsing.parseTextFile(filename);

        int resExo1 = getExo1Answer(inputStringList);
        System.out.println("res exo 1 : " + resExo1);
    }

    private static int getExo1Answer(List<String> inputStringList) {
        int nbLetter2Occurences = 0;
        int nbLetter3Occurences = 0;

        for (String inputLine : inputStringList) {
            Map<Character, Integer> nbCharInLineMap = getNbCharInLine(inputLine);
            nbLetter2Occurences += nbCharInLineMap.containsValue(2) ? 1 : 0;
            nbLetter3Occurences += nbCharInLineMap.containsValue(3) ? 1 : 0;
        }

        return nbLetter2Occurences * nbLetter3Occurences;
    }


    private static Map<Character, Integer> getNbCharInLine(String inputLine) {
        Map<Character, Integer> res = new HashMap<>();
        char[] chars = inputLine.toCharArray();

        for (char letter : chars) {
            if (!res.containsKey(letter)) {
                res.put(letter, 1);
            } else {
                res.replace(letter, res.get(letter) + 1);
            }
        }
        return res;
    }
}
