package year2017.day4.exo;

import utils.Parsing;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String filename = "src/main/java/year2017/day4/inputs/input.txt";
        List<String> inputList = Parsing.parseTextFile(filename);

        int exo1answer = (int) inputList.stream().filter(Main::isValidPassphrase).count();
        int exo2answer = (int) inputList.stream().filter(Main::noAnagramInPhrase).count();
        System.out.println("Answer for exo 1 : " + exo1answer);
        System.out.println("Answer for exo 2 : " + exo2answer);
    }

    /**
     * Exo 2
     */
    private static boolean noAnagramInPhrase(String inputPhrase) {
        List<String> inputInList = Arrays.stream(inputPhrase.split(" ")).toList();

        Queue<String> wordsAlreadyRead = new ArrayDeque<>();
        for (String word : inputInList) {
            if (queueContainsAnagramOfWord(wordsAlreadyRead, word)) {
                return false;
            }
            wordsAlreadyRead.add(word);
        }
        return true;
    }

    /**
     * Exo 2
     * checks if words contains 1 anagram or more of words
     */
    private static boolean queueContainsAnagramOfWord(Queue<String> words, String word) {
        Map<Character, Long> wordCharMap = getCharMapFromWord(word);
        for (String currentWord : words) {
            Map<Character, Long> currentWordCharMap = getCharMapFromWord(currentWord);
            if (currentWordCharMap.equals(wordCharMap)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Exo 2
     * this method gives the number of occurrences of each of the argument's letters
     */
    private static Map<Character, Long> getCharMapFromWord(String word) {
        return Arrays.stream(word.split(""))
                .map(string -> string.charAt(0))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    /**
     * Exo 1
     */
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
