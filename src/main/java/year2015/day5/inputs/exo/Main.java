package year2015.day5.inputs.exo;

import utils.Parsing;

import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String filename = "src/main/java/year2015/day5/inputs/input.txt";
        List<String> input = Parsing.parseTextFile(filename);

        int resultExo1 = (int) input.stream()
                .filter(Main::isAStringNice)
                .count();

        System.out.println("result exo 1 : " + resultExo1);

        int resultExo2 = (int) input.stream()
                .filter(Main::isAStringNiceForExo2)
                .count();

        System.out.println("result exo 2 : " + resultExo2);
    }

    /**
     * Les 2 règles pour qu'un mot soit bon dans l'exo 2
     * - Une paire de deux lettres doit apparaître au moins 2 fois dans le mot
     * sans empilement (aaaa est bon mais aaa pas bon)
     * - Une lettre se répète avec exactement une lettre entre les deux (xyx est bon et aaa est bon)
     *
     * @param word
     * @return
     */
    private static boolean isAStringNiceForExo2(String word) {
        Pattern exo2Pattern = Pattern.compile("(?=.*([a-z])([a-z]).*\\1\\2.*)(?=.*([a-z]).\\3.*)");
        Matcher matcher = exo2Pattern.matcher(word);
        return matcher.find();
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
        int index = 0;
        while (nbVowels < 3 && index < word.length()) {
            if (vowels.contains(word.charAt(index))) {
                nbVowels++;
            }
            index++;
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
