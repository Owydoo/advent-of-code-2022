package year2020.day1.exo1;

import utils.Parsing;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //String filename = "src/main/java/year2020/day1/inputs/input1.txt";
        String filename = "src/main/java/year2020/day1/inputs/input2.txt";

        List<String> inputs = Parsing.parseTextFile(filename);

        List<Integer> integerList = inputs.stream().map(Integer::parseInt).collect(Collectors.toList());

        System.out.println("Exo 1 answer : " + getFirstExoAnswer(integerList));
        System.out.println("Exo 2 answer : " + getSecondExoAnswer(integerList));
        Collections.sort(integerList);

    }

    private static int getSecondExoAnswer(List<Integer> integerList) {
        for (int i = 0; i < integerList.size(); i++) {
            int nb1 = integerList.get(i);
            for (int j = i + 1; j < integerList.size(); j++) {
                int nb2 = integerList.get(j);
                for (int k = j + 1; k < integerList.size(); k++) {
                    int nb3 = integerList.get(k);
                    if (nb1 + nb2 + nb3 == 2020) {
                        return nb1 * nb2 * nb3;
                    }
                }
            }
        }
        throw new IllegalArgumentException("Pas de somme donnant 2020");
    }

    private static int getFirstExoAnswer(List<Integer> integerList) {
        for (int i = 0; i < integerList.size(); i++) {
            int nb1 = integerList.get(i);
            for (int j = i + 1; j < integerList.size(); j++) {
                int nb2 = integerList.get(j);
                if (integerList.get(i) + integerList.get(j) == 2020) {
                    return integerList.get(i) * integerList.get(j);
                }
            }
        }
        throw new IllegalArgumentException("Pas de somme donnant 2020");
    }
}
