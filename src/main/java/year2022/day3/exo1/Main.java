package year2022.day3.exo1;

import utils.Parsing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
//        String filename = "src/main/java/year2022.day3/inputs/input1.txt";
        String filename = "src/main/java/year2022/day3/inputs/input2.txt";

        //Parse le fichier en sac
        List<String> rucksacks = Parsing.parseTextFile(filename);
        System.out.println(rucksacks);

        //Séparer le sac en 2 compartiments en coupant la string par le milieu
        Map<String, String> compartimentsCouples = getCompartiments(rucksacks);
//        System.out.println(compartimentsCouples);

        //récupérer le caractère en commun pour chaque compartiment
        List<String> errorItemTypes = getErrorItems(compartimentsCouples);
//        System.out.println(errorItemTypes);

        //Faire une map de la priorité de chaque caractère --> Utiliser plutôt une string et les indices pour faire
        // le score, avec un espace au début car le score de priorité commence à 1
        String itemPriorities = " abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

        //en utilisant cette map, faire la somme de ces prios pour chaque caractère en commun retrouvé
        int sum = getSumWithPriorities(errorItemTypes, itemPriorities);
        System.out.println(sum);

    }

    public static int getSumWithPriorities(List<String> errorItemTypes, String itemPriorities) {
        int res = 0;
        for (String errorItem : errorItemTypes) {
            res += itemPriorities.indexOf(errorItem);
        }
        return res;
    }


    private static Map<String, String> getCompartiments(List<String> rucksacks) {
        Map<String, String> res = new HashMap<>();
        for (String rucksack : rucksacks) {
            String firstCompartiment = rucksack.substring(0, rucksack.length() / 2);
            String secondCompartiment = rucksack.substring(rucksack.length() / 2);
            res.put(firstCompartiment, secondCompartiment);
        }
        return res;
    }

    private static List<String> getErrorItems(Map<String, String> compartimentsCouples) {
        List<String> res = new ArrayList<>();
        for (Map.Entry<String, String> entry : compartimentsCouples.entrySet()) {
            res.add(findCommonItemInBothString(entry.getKey(), entry.getValue()));
        }
        return res;
    }

    private static String findCommonItemInBothString(String key, String value) {
        for (int i = 0; i < key.length(); i++) {
            if (charInString(String.valueOf(key.charAt(i)), value)) {
                return String.valueOf(key.charAt(i));
            }
        }
        return "";
    }

    private static boolean charInString(String letter, String value) {
        return value.contains(letter);
    }
}
