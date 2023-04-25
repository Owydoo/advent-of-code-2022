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

        //forExo2
        List<Claim> claimList = new ArrayList<>();

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

            final Pair<Integer, Integer> inputClaimSize = Pair.<Integer, Integer>builder()
                    .first(matches.get(3))
                    .second(matches.get(4))
                    .build();

            final Claim claim = Claim.builder()
                    .id(matches.get(0))
                    .origin(inputStartCoordinate)
                    .size(inputClaimSize)
                    .build();

            claimList.add(claim);
            /*
             * Pourquoi utiliser les builders ? (@Builder de lombok)
             * Cela permet de créer des objets complexes, qui n'ont pas forcément tous les champs, sans pour autant
             * à avoir à créer un grand nombre de constructeurs différents correspondant au nombre d'arguments
             * dont on a besoin.
             * Si on utilisait avant le constructeur vide, le builder permet ici de créer un objet en une seule instruction.
             * On peut déléguer la responsabilité de la construction d'un objet au builder, cela ne devrait pas
             * être la responsabilité des setters.
             * On peut d'ailleurs modifier par la suite le comportement du builder sans pour autant modifier les setters.
             *
             * Il est aussi possible de copier un builder (instancier un objet builder au lieu d'utiliser build() directement)
             * lorsqu'on veut créer des objets qui ont de nombreux champs en commun sans dupliquer du code
             */

            addClaim(claims, claim);

        }

        int resForExo1 = countDisputedTissueSquares(claims);
        int resForExo2 = findUndisputedClaimById(claimList, claims);

        System.out.println("resForExo1 : " + resForExo1);
        System.out.println("resForExo2 : " + resForExo2);

    }

    //For Exo 2
    //HORRIBLE
    private static int findUndisputedClaimById(List<Claim> claimList, Map<Coordinate, Integer> claimsMap) {
        for (Claim claim : claimList) {
            boolean found = true;
            for (int i = 0; i < claim.getSize().getFirst(); i++) {
                for (int j = 0; j < claim.getSize().getSecond(); j++) {
                    Coordinate coordinate = Coordinate.builder()
                            .x(claim.getOrigin().getX() + i)
                            .y(claim.getOrigin().getY() + j)
                            .build();
                    if (claimsMap.containsKey(coordinate)){
                        if (claimsMap.get(coordinate) > 1){ //désolé
                            found = false;
                        }
                    }
                }
            }
            if (found) {
                return claim.getId();
            }
        }
        throw new IllegalArgumentException();
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
