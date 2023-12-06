package year2023.day5.exo;

import utils.Parsing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

//        String filename = "src/main/java/year2023/day5/inputs/inputTest.txt";
        String filename = "src/main/java/year2023/day5/inputs/input.txt";

        List<String> inputList = Parsing.parseTextFile(filename);

        Pattern numberPattern = Pattern.compile("\\d+");
        List<Long> seeds = new ArrayList<>(numberPattern.matcher(inputList.get(0)).results()
                .map(MatchResult::group)
                .map(Long::parseLong)
                .toList());


        MapperNameEnum currentLine = null;
        MapperObject mapperObject = null;
        List<MapperObject> mapperObjects = new ArrayList<>();
        //créer un enum de toutes les phrases de parsing

        for (String line : inputList) {
            if (MapperNameEnum.inEnum(line)) {
                currentLine = MapperNameEnum.valueOfLabel(line);
                mapperObject = new MapperObject(currentLine);
                mapperObjects.add(mapperObject);
                continue;
            }

            if (mapperObject == null) {
                continue;
            }

            if (!MapperNameEnum.inEnum(line) && !line.isEmpty()){
                String[] values = line.split(" ");
                mapperObject.mapperLines.add(
                        new MapperLine(Long.parseLong(values[0]), Long.parseLong(values[1]), Long.parseLong(values[2]))
                );
            }
        }
        //traitement
        //pour chaque graîne, parcourir tous les mappersObject et mapper
        for (int i = 0; i < seeds.size(); i++) {
            for (MapperObject currentMapperObject : mapperObjects) {
                seeds.set(i, currentMapperObject.mapSeed(seeds.get(i)));
            }
        }

        long min = Collections.min(seeds);

        System.out.println("min, answer exo 1 : " + min);


    }

}
