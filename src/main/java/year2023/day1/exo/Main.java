package year2023.day1.exo;

import utils.Parsing;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
//        System.out.println("yo");
//        String filenameTest = "src/main/java/year2023/day1/inputs/inputTest.txt";
        String filename = "src/main/java/year2023/day1/inputs/input.txt";

        List<String> inputList = Parsing.parseTextFile(filename);

        System.out.println(inputList);


        Pattern NUMBER_PATTERN = Pattern.compile("\\d");

        int resCount = 0;

        for (String input : inputList) {
            Matcher numberMatcher = NUMBER_PATTERN.matcher(input);
            List<String> strings = new ArrayList<>();
            while (numberMatcher.find()){
                strings.add(numberMatcher.group());
            }

            String myNumberInString = strings.get(0) + strings.get(strings.size()-1);
            resCount += Integer.parseInt(myNumberInString);

        }
        System.out.println(resCount);

    }
}
