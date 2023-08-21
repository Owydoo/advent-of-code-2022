package year2017.day5.exo;

import utils.Parsing;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("test autre implem");

        String filename = "src/main/java/year2017/day5/inputs/input.txt";
//        String filename = "src/main/java/year2017/day5/inputs/inputTest.txt";

        List<Integer> inputList = new java.util.ArrayList<>(
                Parsing.parseTextFile(filename).stream().map(Integer::parseInt).toList()
        );

        System.out.println(inputList);

        //tant que l'indice auquel je cherche est contenu dans la liste
        //-- je vais à l'indice indiqué en valeur à l'indice courant
        //-- j'ajoute un à la valeur de départ
        //-- je compte les étapes dans un compteur

        int currentIndex = 0;
        int stepsCounter = 0;

        while (currentIndex >= 0 && currentIndex < inputList.size()) {
            int currentValue = inputList.get(currentIndex);
            inputList.set(currentIndex, currentValue + 1);
            currentIndex += currentValue;
            stepsCounter++;
        }

        System.out.println("answer exo 1 : " + stepsCounter);

    }
}
