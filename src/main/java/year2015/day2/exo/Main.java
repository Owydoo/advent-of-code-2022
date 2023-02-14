package year2015.day2.exo;

import utils.Parsing;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String filename = "src/main/java/year2015/day2/inputs/input.txt";
        List<String> inputStrings = Parsing.parseTextFile(filename);

        List<Present> presentList = getPresentsFromStringList(inputStrings);

        List<Integer> resultList1 = presentList.stream().map(Present::howMuchPaper).toList();
        List<Integer> resultList2 = presentList.stream().map(Present::howMuchRibbon).toList();

        int res1 = resultList1.stream().mapToInt(Integer::intValue).sum();
        int res2 = resultList2.stream().mapToInt(Integer::intValue).sum();

        System.out.println("Exo 1 : " + res1);
        System.out.println("Exo 2 : " + res2);
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
