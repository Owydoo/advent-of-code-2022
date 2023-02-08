package day2_2015.exo;

import utils.Parsing;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        String filename = "src/main/java/day2_2015/inputs/input.txt";
        List<String> inputStrings = Parsing.parseTextFile(filename);

        List<Present> presentList = getPresentsFromStringList(inputStrings);

        List<Integer> results = presentList.stream().map(Present::howMuchPaper).collect(Collectors.toList());

        int res = results.stream().mapToInt(Integer::intValue).sum();

        System.out.println("Exo 1 : " + res);
    }

    private static List<Present> getPresentsFromStringList(List<String> inputStrings) {
        List<Present> presents = new ArrayList<>();
        for (String inputString : inputStrings) {
            String[] current = inputString.split("x");
            Present present = new Present();
            present.setL(Integer.parseInt(current[0]));
            present.setW(Integer.parseInt(current[1]));
            present.setH(Integer.parseInt(current[2]));
            presents.add(present);
        }
        return presents;
    }
}
