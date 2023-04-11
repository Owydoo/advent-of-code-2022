package year2016.day3.exo;

import utils.Parsing;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        String filename = "src/main/java/year2016/day3/inputs/input.txt";
//        String filename = "src/main/java/year2016/day3/inputs/inputTestExo2.txt";

        List<String> inputInString = Parsing.parseTextFile(filename);

        Queue<PotentialTriangle> potentialTriangles = getPotentialTrianglesFromInput(inputInString);
        Queue<PotentialTriangle> potentialTrianglesForExo2 = getPotentialTrianglesFromInputVertically(inputInString);

        int nbOfValidTriangles = getNbValidTrianglesFromTriangleQueue(potentialTriangles);
        int nbOfValidTrianglesForExo2 = getNbValidTrianglesFromTriangleQueue(potentialTrianglesForExo2);

        System.out.println("answer in exo 1 : " + nbOfValidTriangles);
        System.out.println("answer in exo 2 : " + nbOfValidTrianglesForExo2);
    }

    private static int getNbValidTrianglesFromTriangleQueue(Queue<PotentialTriangle> potentialTriangles) {
        return (int) potentialTriangles.stream().filter(PotentialTriangle::isPotentialTriangleValid).count();
    }

    private static Queue<PotentialTriangle> getPotentialTrianglesFromInput(List<String> inputInString) {
        Queue<PotentialTriangle> potentialTriangles = new ArrayDeque<>();

        for (String potentialTriangleString : inputInString) {
            String[] ptsTab = potentialTriangleString.trim().split(" +");
            PotentialTriangle potentialTriangle = new PotentialTriangle();
            potentialTriangle.setA(Integer.parseInt(ptsTab[0]));
            potentialTriangle.setB(Integer.parseInt(ptsTab[1]));
            potentialTriangle.setC(Integer.parseInt(ptsTab[2]));
            potentialTriangles.add(potentialTriangle);
        }
        return potentialTriangles;
    }


    //EXO2
    private static Queue<PotentialTriangle> getPotentialTrianglesFromInputVertically(List<String> inputInString) {
        Queue<PotentialTriangle> potentialTriangles = new ArrayDeque<>();

        int[][] values = getInputInStringAs2DimArray(inputInString);

        for (int columnIndex = 0; columnIndex < 3; columnIndex++) {
            for (int lineIndex = 0; lineIndex < values.length; lineIndex += 3) {
                PotentialTriangle potentialTriangle = new PotentialTriangle();
                potentialTriangle.setA(values[lineIndex][columnIndex]);
                potentialTriangle.setB(values[lineIndex + 1][columnIndex]);
                potentialTriangle.setC(values[lineIndex + 2][columnIndex]);
                potentialTriangles.add(potentialTriangle);
            }
        }

        return potentialTriangles;
    }

    //EXO2
    private static int[][] getInputInStringAs2DimArray(List<String> inputInString) {
        int inputSize = inputInString.size();
        int[][] result = new int[inputSize][3];
        for (int i = 0; i < inputSize; i++) {
            String[] elementInTab = inputInString.get(i).trim().split(" +");
            result[i][0] = Integer.parseInt(elementInTab[0]);
            result[i][1] = Integer.parseInt(elementInTab[1]);
            result[i][2] = Integer.parseInt(elementInTab[2]);
        }
        return result;
    }
}
