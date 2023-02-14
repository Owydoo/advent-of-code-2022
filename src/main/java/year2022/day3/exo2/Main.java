package year2022.day3.exo2;

import utils.Parsing;

import java.util.ArrayList;
import java.util.List;

import static year2022.day3.exo1.Main.getSumWithPriorities;

public class Main {
    public static void main(String[] args) {
//                String filename = "src/main/java/year2022.day3/inputs/input1.txt";
        String filename = "src/main/java/year2022/day3/inputs/input2.txt";

        //Parse le fichier en sac
        List<String> rucksacks = Parsing.parseTextFile(filename);
        System.out.println(rucksacks);

        //créer des groupes d'elfes de 3 sacs
        List<ElfGroup> elfGroups = getElfGroupFromRucksacks(rucksacks);
        System.out.println(elfGroups);

        //trouver le badge de chaque groupe
        List<String> badges = findBadgesInElfGroups(elfGroups);
        System.out.println(badges);

        //Utiliser la chaine de priorité pour chaque badge
        String itemPriorities = " abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

        int sum = getSumWithPriorities(badges, itemPriorities);
        System.out.println(sum);

    }

    private static List<String> findBadgesInElfGroups(List<ElfGroup> elfGroups) {
        List<String> res = new ArrayList<>();

        for (ElfGroup elfGroup :
                elfGroups) {
            res.add(elfGroup.getBadge());
        }
        return res;
    }

    private static List<ElfGroup> getElfGroupFromRucksacks(List<String> rucksacks) {
        List<ElfGroup> res = new ArrayList<>();
        for (int i = 0; i < rucksacks.size()-2; i++) {
            if (i % 3 == 0){
                ElfGroup elfGroup = new ElfGroup();
                elfGroup.setElf1(rucksacks.get(i));
                elfGroup.setElf2(rucksacks.get(i+1));
                elfGroup.setElf3(rucksacks.get(i+2));
                res.add(elfGroup);
            }
        }
        return res;
    }
}
