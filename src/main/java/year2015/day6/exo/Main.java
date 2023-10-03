package year2015.day6.exo;

import utils.Parsing;
import year2017.day2.exo.Pair;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String filename = "src/main/java/year2015/day6/inputs/input.txt";

        List<String> lines = Parsing.parseTextFile(filename);

        //récup instruction + coordonnées
        List<SantaInstruction> santaInstructions = getInstructionsFromInput(lines);

        //initialisation de ma grille
        boolean[][] lightGrid = new boolean[1000][1000];
        Arrays.stream(lightGrid).forEach(array -> Arrays.fill(array, false));

        //effectuer instructions
        for (SantaInstruction santaInstruction : santaInstructions) {
            computeInstruction(santaInstruction, lightGrid);
        }

        //compter les true dans le tableau
        int count = 0;
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                if (lightGrid[i][j]) count++;
            }
        }
        System.out.println("answer exo 1 : " + count);

        //EXO 2
        //initialiser la grille
        int[][] intensityLightGrid = new int[1000][1000];
        Arrays.stream(intensityLightGrid).forEach(array -> Arrays.fill(array, 0));

        for (SantaInstruction santaInstruction : santaInstructions) {
            computeInstructionWithIntensity(santaInstruction, intensityLightGrid);
        }

        //compter l'intensité totale
        int countExo2 = 0;
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                countExo2 += intensityLightGrid[i][j];
            }
        }
        System.out.println("answer exo 2 : " + countExo2);
    }

    private static void computeInstructionWithIntensity(SantaInstruction santaInstruction, int[][] intensityLightGrid) {
        for (int line = santaInstruction.getStartCoordinates().getFirst(); line <= santaInstruction.getEndCoordinates().getFirst(); line++) {
            for (int column = santaInstruction.getStartCoordinates().getSecond(); column <= santaInstruction.getEndCoordinates().getSecond(); column++) {
                switch (santaInstruction.getAction()) {
                    case TOGGLE -> intensityLightGrid[line][column] += 2;
                    case TURN_ON -> intensityLightGrid[line][column]++;
                    case TURN_OFF -> {
                        if (intensityLightGrid[line][column] > 0) {
                            intensityLightGrid[line][column]--;
                        }
                    }
                }
            }
        }
    }

    private static void computeInstruction(SantaInstruction santaInstruction, boolean[][] lightGrid) {
        for (int line = santaInstruction.getStartCoordinates().getFirst(); line <= santaInstruction.getEndCoordinates().getFirst(); line++) {
            for (int column = santaInstruction.getStartCoordinates().getSecond(); column <= santaInstruction.getEndCoordinates().getSecond(); column++) {
                switch (santaInstruction.getAction()) {
                    case TOGGLE -> lightGrid[line][column] = !lightGrid[line][column];
                    case TURN_ON -> lightGrid[line][column] = true;
                    case TURN_OFF -> lightGrid[line][column] = false;
                }
            }
        }
    }


    private static List<SantaInstruction> getInstructionsFromInput(List<String> lines) {
        return lines.stream()
                .map(Main::getSantaInstructionFromLine)
                .toList();
    }

    private static SantaInstruction getSantaInstructionFromLine(String line) {
        Pattern santaPattern = Pattern.compile("(\\w+|\\w+ \\w+) (\\d+),(\\d+) through (\\d+),(\\d+)");
        Matcher matcher = santaPattern.matcher(line);

        if (!matcher.find()) {
            throw new IllegalArgumentException();
        }
        Action action = switch (matcher.group(1)) {
            case "toggle" -> Action.TOGGLE;
            case "turn on" -> Action.TURN_ON;
            case "turn off" -> Action.TURN_OFF;
            default -> throw new IllegalStateException("Unexpected value: " + matcher.group(1));
        };

        return SantaInstruction.builder()
                .action(action)
                .startCoordinates(new Pair<>(Integer.parseInt(matcher.group(2)), Integer.parseInt(matcher.group(3))))
                .endCoordinates(new Pair<>(Integer.parseInt(matcher.group(4)), Integer.parseInt(matcher.group(5))))
                .build();
    }
}
