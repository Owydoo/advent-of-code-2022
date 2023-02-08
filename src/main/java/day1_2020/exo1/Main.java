package day1_2020.exo1;

import utils.Parsing;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //String filename = "src/main/java/day1_2020/inputs/input1.txt";
        String filename = "src/main/java/day1_2020/inputs/input2.txt";

        List<String> inputs = Parsing.parseTextFile(filename);

        List<Integer> integerList = inputs.stream().map(Integer::parseInt).collect(Collectors.toList());

        System.out.println("Exo 1 answer : "+ getFirstExoAnswer(integerList));
    }

    private static Integer getFirstExoAnswer(List<Integer> integerList){
        for (int i = 0; i < integerList.size(); i++) {
            for (int j = 0; j < integerList.size(); j++) {
                if (integerList.get(i)+integerList.get(j) == 2020){
                    return integerList.get(i) * integerList.get(j);
                }
            }
        }
        return -1;
    }
}
