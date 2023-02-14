package year2022.day1.exo1;

import utils.Parsing;

import java.util.*;

public class Main {

    static void reverse(Integer[] array) {
        Collections.reverse(Arrays.asList(array));
    }

    public static void main(String[] args) {
        //https://adventofcode.com/2022/day/1
//        String filename = "src/main/java/year2022.day1/inputs/input1.txt";
        String filename = "src/main/java/year2022/day1/inputs/input2.txt";

        List<String> calories = Parsing.parseTextFile(filename);
        System.out.println(calories);

        Integer[] sums = new Integer[calories.size()];
        Arrays.fill(sums, 0);
        int count = 0;
        for (String value :
                calories) {
            if (!value.equals("")) {
                sums[count] += Integer.parseInt(value);
            } else {
                count++;
            }
        }

        Arrays.sort(sums);
        reverse(sums);
        System.out.println("max exo 1 : " + sums[0]);
        int exo2res = sums[0] + sums[1] + sums[2];
        System.out.println("max exo 2 : " + exo2res);
    }
}
