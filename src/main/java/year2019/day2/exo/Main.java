package year2019.day2.exo;

import utils.Parsing;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
//        String filename = "src/main/java/year2019/day2/inputs/input1.txt";
        String filename = "src/main/java/year2019/day2/inputs/input2.txt";

        List<Integer> inputs = Parsing.parseInlineTextFile(filename, ",")
                .stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        //initialiser la position 1 à 12 et la position 2 à 2.
        inputs.set(1, 12);
        inputs.set(2, 2);

        restoreGravityAssist(inputs);

        int answerExo1 = inputs.get(0);

        System.out.println(inputs);

        System.out.println("answer exo 1 : " + answerExo1);

    }

    private static void restoreGravityAssist(List<Integer> inputs) {

        int index = 0;
        while (index < inputs.size()) {
            //prendre les 4 premiers nombres
            //index + 0 = type d'opération
            int operationType = inputs.get(index);
            //index + 1 et index + 2 = position des opérateurs
            int firstOperatorIndex = inputs.get(index + 1);
            int secondOperatorIndex = inputs.get(index + 2);
            //index + 3 = position de la valeur à surcharger
            int resultPos = inputs.get(index + 3);
            switch (operationType) {
                //si 99, fin du programme
                case 99 -> {
                    return;
                }
                //Si 1, addition
                case 1 -> {
                    inputs.set(resultPos, inputs.get(firstOperatorIndex) + inputs.get(secondOperatorIndex));
                    index += 4;
                }
                //si 2, multiplication
                case 2 -> {
                    inputs.set(resultPos, inputs.get(firstOperatorIndex) * inputs.get(secondOperatorIndex));
                    index += 4;
                }
                default -> System.err.println("error input on index : " + index + " with value : " + inputs.get(index));
            }
        }

        System.out.println("index : " + index);
        throw new IllegalArgumentException();
    }
}
