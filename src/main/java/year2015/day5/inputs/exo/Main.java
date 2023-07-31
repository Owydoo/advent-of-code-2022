package year2015.day5.inputs.exo;

import utils.Parsing;

import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println("hello");

        String filename = "src/main/java/year2015/day5/inputs/input.txt";
        List<String> input = Parsing.parseTextFile(filename);

        int resultExo1 = (int) input.stream()
                .filter(Main::isAStringNice)
                .count();

        System.out.println("result exo 1 : " + resultExo1);
    }

    private static boolean isAStringNice(String word) {
        return hasALetterTwiceInARow(word) && hasAtLeastThreeVowels(word) && hasNoBannedString(word);
    }

    private static boolean hasNoBannedString(String word) {
        Set<String> bannedStrings = Set.of("ab", "cd", "pq", "xy");
        return bannedStrings.stream().noneMatch(word::contains);
    }

    private static boolean hasAtLeastThreeVowels(String word) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        int nbVowels = 0;
        for (char c : word.toCharArray()) {
            if (vowels.contains(c)){
                nbVowels++;
            }
        }
        return nbVowels >= 3;

    }

    private static boolean hasALetterTwiceInARow(String word) {
        char previousChar = ' ';
        for (char currentChar : word.toCharArray()) {
            if (currentChar == previousChar) {
                return true;
            }
            previousChar = currentChar;
        }
        return false;
    }

}
