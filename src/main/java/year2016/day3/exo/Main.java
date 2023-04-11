package year2016.day3.exo;

import utils.Parsing;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        String filename = "src/main/java/year2016/day3/inputs/input.txt";

        List<String> inputInString = Parsing.parseTextFile(filename);

        Queue<PotentialTriangle> potentialTriangles = getPotentialTrianglesFromInput(inputInString);

        int nbOfValidTriangles = getNbValidTrianglesFromTriangleQueue(potentialTriangles);

        System.out.println("answer in exo 1 : " + nbOfValidTriangles);
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
}
