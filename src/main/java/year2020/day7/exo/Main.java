package year2020.day7.exo;

import utils.Parsing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        String filename = "src/main/java/year2020/day7/inputs/input.txt";

        List<String> inputLines = Parsing.parseTextFile(filename);

        List<Bag> bagList = parseMyInputLines(inputLines);
        System.out.println(bagList);

        int count = countCombinaisonsDeSacsQuiPeuventContenirUnSac(bagList);
        System.out.println(count);
    }

    private static int countCombinaisonsDeSacsQuiPeuventContenirUnSac(List<Bag> bagList) {
        //J'enregistre les sacs s'ils contiennent un shiny gold
        //Je repasse parmi les sacs enregistrés
        //Je réenregistre les sacs qui contiennent les sacs nouvellement enregistrés
        // (ajoutés à la dernière itération)
        List<Bag> bagsToFind = new ArrayList<>();
        Bag shinyGold = new Bag();
        shinyGold.setName("shiny gold");
        bagsToFind.add(shinyGold);
        List<Bag> bags = findBagsFromBags(bagList, bagsToFind);
        Set<Bag> resultBags = new HashSet<>(bags);

        while (!bags.isEmpty()) {
            bagList.removeAll(resultBags);
            bags = findBagsFromBags(bagList, bags);
            resultBags.addAll(bags);
        }
        return resultBags.size();
    }

    private static List<Bag> findBagsFromBags(List<Bag> bagList, List<Bag> bagsToFind) {
        List<Bag> res = new ArrayList<>();
        for (Bag bag : bagList) {
            for (Bag bagToFind : bagsToFind) {
                if (bag.getOtherBags().containsKey(bagToFind.getName())) {
                    res.add(bag);
                }
            }
        }

        return res;
    }

    private static List<Bag> parseMyInputLines(List<String> inputLines) {
        List<Bag> bags = new ArrayList<>();
        for (String inputLine : inputLines) {
            bags.add(parseForOneLine(inputLine));
        }

        return bags;
    }

    private static Bag parseForOneLine(String s) {
        String regex = "(\\S+\\s+\\S+) bags contain ([\\s\\S]+).";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);

        Bag bag = new Bag();
        if (matcher.find()) {
            bag.setName(matcher.group(1));

            String sequel = matcher.group(2);
            Arrays.stream(sequel.split(",")).forEach(x -> {
                String regexSuite = "(\\d) (\\S+\\s+\\S+) bag(s*)";
                Pattern p = Pattern.compile(regexSuite);
                Matcher m = p.matcher(x);

                if (m.find()) {
                    bag.addOtherBag(m.group(2), Integer.parseInt(m.group(1)));
                }
            });

        }
        return bag;
    }
}

