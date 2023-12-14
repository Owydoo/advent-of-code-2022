package year2023.day14.exo;

import utils.Parsing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String filename = "src/main/java/year2023/day14/inputs/input.txt";
//        String filename = "src/main/java/year2023/day14/inputs/inputTest.txt";

        List<String> inputLines = Parsing.parseTextFile(filename);

        //Construire une matrice de case
        //types de cases pierreronde 'O', pierreCarree '#', vide '.'
        //Map de liste : <Integer, List<Case>> --> Int = numero de ligne, List<Case> la ligne
        //
        Map<Integer, List<TileEnum>> reflectorDish = new HashMap<>();

        buildMapFromInput(reflectorDish, inputLines);

        //je build ma map avec l'input
        rollNorth(reflectorDish);

        int answerExo1 = calculateTotalLoad(reflectorDish);

        System.out.println("answer exo 1 : " + answerExo1);
    }

    private static void buildMapFromInput(Map<Integer, List<TileEnum>> reflectorDish, List<String> inputLines) {
        //initialize ma map avec la taille d'une ligne d'input (=nbColumn) et List vide
        int nbColumn = (int) inputLines.get(0).chars().count();
        initializeReflectorDish(reflectorDish, nbColumn);

        //fori sur les lignes d'input
        //--parcours des characters de la String line : forj
        //----map.put(j, New TileEnum(ligne[j])
        for (String inputLine : inputLines) {
            for (int charColumnIndex = 0; charColumnIndex < nbColumn; charColumnIndex++) {
                switch (inputLine.charAt(charColumnIndex)) {
                    case '.' -> reflectorDish.get(charColumnIndex).add(TileEnum.EMPTY_SPACE);
                    case '#' -> reflectorDish.get(charColumnIndex).add(TileEnum.CUBE_SHAPED_ROCK);
                    case 'O' -> reflectorDish.get(charColumnIndex).add(TileEnum.ROUNDED_ROCK);
                    default -> throw new IllegalArgumentException();
                }
            }
        }
    }

    private static void initializeReflectorDish(Map<Integer, List<TileEnum>> reflectorDish, int lineLength) {
        for (int i = 0; i < lineLength; i++) {
            reflectorDish.put(i, new ArrayList<>());
        }
    }

    private static void rollNorth(Map<Integer, List<TileEnum>> reflectorDish) {

        //rollNorth(map)
        //forColumn --> rollColumnNorth()
        //commencer par la fin de la colonne
        for (Map.Entry<Integer, List<TileEnum>> column : reflectorDish.entrySet()) {
            rollColumnNorth(column.getValue());
        }

    }

    private static void rollColumnNorth(List<TileEnum> column) {
        //partir de la ligne 1,
        //--si au dessus j'ai un point et je suis une pierre ronde
        //----je monte la pierre au cran sur la ligne -1
        int line = 1;
        while (line < column.size()) {
            int aboveTileIndex = line - 1;
            if (column.get(aboveTileIndex) == TileEnum.EMPTY_SPACE && column.get(line) == TileEnum.ROUNDED_ROCK) {
                column.set(aboveTileIndex, TileEnum.ROUNDED_ROCK);
                column.set(line, TileEnum.EMPTY_SPACE);
                line = 1; //je recommence à chaque fois que je bouge une pierre
            } else {
                line++;
            }
        }

    }

    private static int calculateTotalLoad(Map<Integer, List<TileEnum>> reflectorDish) {
        int count = 0;
        for (Map.Entry<Integer, List<TileEnum>> column : reflectorDish.entrySet()) {
            count += calculateColumnLoad(column.getValue());
        }
        return count;
    }

    private static int calculateColumnLoad(List<TileEnum> column) {
        int load = 0;
        //parcourir les lignes, fori
        //--si pierre ronde
        //----ajouter la valeur size - 1 - i
        for (int i = 0; i < column.size(); i++) {
            if (column.get(i) == TileEnum.ROUNDED_ROCK){
                load += column.size() - i;
            }
        }
        return load;
    }
}
