package year2017.day5.exo;

import utils.Parsing;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filename = "src/main/java/year2017/day5/inputs/input.txt";
//        String filename = "src/main/java/year2017/day5/inputs/inputTest.txt";

        List<Integer> inputList =
                Parsing.parseTextFile(filename).stream().map(Integer::parseInt).toList();

        int stepsCounterForExo1 = countStepsInInputListExo1(inputList);
        System.out.println("answer exo 1 : " + stepsCounterForExo1);

        int stepsCounterForExo2 = countStepsInInputListExo2(inputList);
        System.out.println("answer exo 2 : " + stepsCounterForExo2);
    }

    private static int countStepsInInputListExo2(List<Integer> inputList) {
        List<Integer> listCopy = new ArrayList<>(List.copyOf(inputList));

        int currentIndex = 0;
        int stepsCounter = 0;

        while (currentIndex >= 0 && currentIndex < listCopy.size()) {
            int currentValue = listCopy.get(currentIndex);
            if (currentValue >= 3) {
                listCopy.set(currentIndex, currentValue - 1);
            } else {
                listCopy.set(currentIndex, currentValue + 1);
            }
            currentIndex += currentValue;
            stepsCounter++;
        }
        return stepsCounter;
    }

    private static int countStepsInInputListExo1(List<Integer> inputList) {
        List<Integer> listCopy = new ArrayList<>(List.copyOf(inputList));

        int currentIndex = 0;
        int stepsCounter = 0;

        while (currentIndex >= 0 && currentIndex < listCopy.size()) {
            int currentValue = listCopy.get(currentIndex);
            listCopy.set(currentIndex, currentValue + 1);
            currentIndex += currentValue;
            stepsCounter++;
        }
        return stepsCounter;
    }
}
