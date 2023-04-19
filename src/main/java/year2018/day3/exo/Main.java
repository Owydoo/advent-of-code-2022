package year2018.day3.exo;

import utils.Parsing;
import year2017.day2.exo.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
//        String filename = "src/main/java/year2018/day3/inputs/inputTest.txt";
        String filename = "src/main/java/year2018/day3/inputs/input.txt";

        List<String> inputInString = Parsing.parseTextFile(filename);

        Map<Coordinate, Integer> claims = new HashMap<>();

        for (String input : inputInString) {
            Pattern numberPattern = Pattern.compile("\\d+");
            Matcher matcher = numberPattern.matcher(input);

            List<Integer> matches = new ArrayList<>();
            while (matcher.find()) {
                matches.add(Integer.parseInt(matcher.group()));
            }

            Coordinate inputStartCoordinate = Coordinate.builder()
                    .x(matches.get(1))
                    .y(matches.get(2))
                    .build();

            Pair<Integer, Integer> inputClaimSize = Pair.<Integer, Integer>builder()
                    .first(matches.get(3))
                    .second(matches.get(4))
                    .build();

            Claim claim = Claim.builder()
                    .origin(inputStartCoordinate)
                    .size(inputClaimSize)
                    .build();

            addClaim(claims, claim);

        }

        int resForExo1 = countDisputedTissueSquares(claims);

        System.out.println(resForExo1);
    }

    private static int countDisputedTissueSquares(Map<Coordinate, Integer> claims) {
        return (int) claims.entrySet().stream().filter(el -> el.getValue() > 1).count();
    }

    private static void addClaim(Map<Coordinate, Integer> claims, Claim claim) {
        for (int i = 0; i < claim.getSize().getFirst(); i++) {
            for (int j = 0; j < claim.getSize().getSecond(); j++) {
                Coordinate coordinateToChange = Coordinate.builder()
                        .x(claim.getOrigin().getX() + i)
                        .y(claim.getOrigin().getY() + j)
                        .build();
                if (claims.containsKey(coordinateToChange)) {
                    claims.put(coordinateToChange, claims.get(coordinateToChange) + 1);
                } else {
                    claims.put(coordinateToChange, 1);
                }
            }
        }
    }
}
