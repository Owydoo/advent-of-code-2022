package day4.exo1;

import utils.Parsing;

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
        Map<Section,Section> sectionCouples = getSectionsCouplesFromLines(lines);
        System.out.println(sectionCouples);

        //compter le nombre de sections entièrement incluses dans l'autre section du couple
        int countIncludedSections = countIncludedSectionsInSectionCouples(sectionCouples);
        System.out.println("count : " + countIncludedSections);

    }

    private static Map<Section,Section> getSectionsCouplesFromLines(List<String> lines) {
        Map<Section, Section> sectionCouples = new HashMap<>();

        for (String line :
                lines) {
            String[] sectionsInString = line.split(",");
            String[] firstSectionString = sectionsInString[0].split("-");
            String[] secondSectionString = sectionsInString[1].split("-");
            Section firstSection = new Section(Integer.parseInt(firstSectionString[0]), Integer.parseInt(firstSectionString[1]));
            Section secondSection = new Section(Integer.parseInt(secondSectionString[0]),
                    Integer.parseInt(secondSectionString[1]));
            sectionCouples.put(firstSection, secondSection);
        }
        return sectionCouples;
    }

    private static int countIncludedSectionsInSectionCouples(Map<Section, Section> sectionCouples) {
        int count = 0;
        for (Map.Entry<Section, Section> entry: sectionCouples.entrySet()) {
            if (entry.getKey().oneSectionIncludedInTheOther(entry.getValue())){
                count++;
            }
        }
        return count;
    }
}
