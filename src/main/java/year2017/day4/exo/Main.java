package year2017.day4.exo;

import utils.Parsing;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        String filename = "src/main/java/year2017/day4/inputs/input.txt";
        List<String> inputList = Parsing.parseTextFile(filename);

        int exo1answer = (int) inputList.stream().filter(Main::isValidPassphrase).count();

        System.out.println("Answer for exo 1 : " + exo1answer);
    }

    private static boolean isValidPassphrase(String input) {
        List<String> inputInList = Arrays.stream(input.split(" ")).toList();

        Queue<String> wordsAlreadyRead = new ArrayDeque<>();
        for (String word : inputInList) {
            if (wordsAlreadyRead.contains(word)) {
                return false;
            }
            wordsAlreadyRead.add(word);
        }
        return true;
    }
}
