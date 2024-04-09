package year2021.day7.exo;

import utils.Parsing;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

//        List<Integer> inputList = new ArrayList<>(List.of(16, 1, 2, 0, 4, 2, 7, 1, 2, 14)); //input de test
        List<Integer> inputList = new ArrayList<>(Parsing.parseInlineTextFile("src/main/java/year2021/day7/inputs/input.txt", ",").stream().map(Integer::parseInt).toList());
        inputList.sort(Comparator.comparingInt(a -> a));
        System.out.println(inputList);

        int median = calculateMedian(inputList);
        System.out.println("median: " + median);

        int fuelNecessaryFromMedian = calculateFuelNecessary(inputList, median);

        System.out.println("result: " + fuelNecessaryFromMedian);
    }

    private static int calculateFuelNecessary(List<Integer> inputTestList, int median) {
        return inputTestList.stream()
                .mapToInt((integer -> Math.abs(integer - median)))
                .sum();
    }

    private static int calculateMedian(List<Integer> inputTestList) {
        if (inputTestList.size() % 2 != 0) {
            return inputTestList.get((inputTestList.size() / 2) - 1);
        }
        return (inputTestList.get((inputTestList.size()-1) / 2) + inputTestList.get((inputTestList.size() / 2) )) / 2;
    }
}
