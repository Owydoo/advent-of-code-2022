package year2016.day6.exo;

import utils.Parsing;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("yo");

//        List<String> inputWords = Parsing.parseTextFile("src/main/java/year2016/day6/inputs/inputTest.txt");
        List<String> inputWords = Parsing.parseTextFile("src/main/java/year2016/day6/inputs/input.txt");

        StringBuilder answerExo1 = new StringBuilder();
        StringBuilder answerExo2 = new StringBuilder();
        //boucler sur les positions
        for (int position = 0; position < inputWords.get(0).length(); position++) {
            //boucler sur les mots
            Map<Character, Integer> nbCharAtPosition = new HashMap<>();
            for (String word : inputWords) {
                //pour chaque mot, récup carac
                char currentChar = word.charAt(position);
                //Map du nombre de carac pour cette position
                nbCharAtPosition.merge(currentChar, 1, Integer::sum);
            }
            //ajout du carac max dans une string
            answerExo1.append(Collections.max(nbCharAtPosition.entrySet(), Map.Entry.comparingByValue()).getKey());
            answerExo2.append(Collections.min(nbCharAtPosition.entrySet(), Map.Entry.comparingByValue()).getKey());
        }

        System.out.println("answer exo 1 : " + answerExo1);
        System.out.println("answer exo 2 : " + answerExo2);
    }
}
