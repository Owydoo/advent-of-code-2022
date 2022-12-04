package day4.exo1;

import utils.Parsing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello");

//        String filename = "src/main/java/day4/inputs/input1.txt";
        String filename = "src/main/java/day4/inputs/input2.txt";

        //Parser le fichier texte en ligne
        List<String> lines = Parsing.parseTextFile(filename);

        //Récupérer les couples de sections
        List<ElfTeam> sectionCouples = getSectionsCouplesFromLines(lines);
        System.out.println(sectionCouples);

        //compter le nombre de sections entièrement incluses dans l'autre section du couple
        int countIncludedSections = countIncludedSectionsInSectionCouples(sectionCouples);
        System.out.println("count : " + countIncludedSections);

    }

    private static List<ElfTeam> getSectionsCouplesFromLines(List<String> lines) {
        List<ElfTeam> sectionCouples = new ArrayList<>();

        for (String line :
                lines) {
            String[] sectionsInString = line.split(",");
            String[] firstSectionString = sectionsInString[0].split("-");
            String[] secondSectionString = sectionsInString[1].split("-");
            Section firstSection = new Section(Integer.parseInt(firstSectionString[0]), Integer.parseInt(firstSectionString[1]));
            Section secondSection = new Section(Integer.parseInt(secondSectionString[0]),
                    Integer.parseInt(secondSectionString[1]));
            sectionCouples.add(new ElfTeam(firstSection, secondSection));
        }
        return sectionCouples;
    }

    private static int countIncludedSectionsInSectionCouples(List<ElfTeam> elfTeams) {
        int count = 0;
        for (ElfTeam elfTeam : elfTeams) {
            if (elfTeam.getFirst().contains(elfTeam.getSecond()) || elfTeam.getSecond().contains(elfTeam.getFirst())){
                count++;
            }
        }
        return count;
    }


}
