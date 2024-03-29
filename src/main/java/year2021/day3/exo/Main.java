package year2021.day3.exo;

import utils.Parsing;
import year2017.day2.exo.Pair;

import java.util.List;

public class Main {
    public static void main(String[] args) {
//        String filename = "src/main/java/year2021/day3/inputs/inputTest.txt";
        String filename = "src/main/java/year2021/day3/inputs/input.txt";

        List<String> inputString = Parsing.parseTextFile(filename);

        Pair<String, String> submarineRates = findSubmarineRates(inputString);

        String gammaRateBinary = submarineRates.getFirst();
        String epsilonRateBinary = submarineRates.getSecond();

        int powerConsumption = Integer.parseInt(gammaRateBinary, 2) * Integer.parseInt(epsilonRateBinary, 2);
        System.out.println("Answer exo 1 : Power consumption --> " + powerConsumption);
    }

    /**
     * for exo 1
     */
    private static Pair<String, String> findSubmarineRates(List<String> inputString) {
        StringBuilder gammaRateFound = new StringBuilder();
        StringBuilder epsilonRateFound = new StringBuilder();
        int binaryNumberLength = inputString.get(0).length();

        for (int digit = 0; digit < binaryNumberLength; digit++) {
            final int finalDigit = digit;

            int bitAtOneCount = (int) inputString.stream()
                    .filter(word -> word.charAt(finalDigit) == '1')
                    .count();

            if (bitAtOneCount > (inputString.size() / 2)) {
                gammaRateFound.append("1");
                epsilonRateFound.append("0");
            } else {
                gammaRateFound.append("0");
                epsilonRateFound.append("1");
            }

        }
        return Pair.<String, String>builder()
                .first(gammaRateFound.toString())
                .second(epsilonRateFound.toString())
                .build();
    }
}
