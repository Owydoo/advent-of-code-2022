package year2017.day5.exo;

import utils.Parsing;

import java.util.List;

import static java.lang.Math.abs;

public class Main {
    public static void main(String[] args) {
        System.out.println("hello");

        String filename = "src/main/java/year2017/day5/inputs/input.txt";
//        String filename = "src/main/java/year2017/day5/inputs/inputTest.txt";

        List<String> inputList = Parsing.parseTextFile(filename);

        MyLinkedList<Integer> inputInstructions = new MyLinkedList<>();
        for (String s : inputList) {
            inputInstructions.add(Integer.parseInt(s));
        }

        System.out.println("input instructions before exo 1 : " + inputInstructions);

//        int stepsNumberExo1 = computeInstructions(inputInstructions);
        int stepsNumberExo1 = 0;
        stepsNumberExo1 = computeInstructions(inputInstructions.getHead(), stepsNumberExo1);

        System.out.println("answer exo 1 : " + stepsNumberExo1);
        System.out.println("input instructions after exo 1 : " + inputInstructions);

    }

    private static int computeInstructions(MyLinkedList<Integer>.Node head, int counter) {
//        head.setValue(head.getValue() + 1);
        return jump(head, head.getValue(), counter);
    }

    private static int jump(MyLinkedList<Integer>.Node node, int currentCounter, int counter) {
        if (node == null) {
            return counter;
        } else if (currentCounter > 0) {
            return jump(node.next, currentCounter - 1, counter);
        } else if (currentCounter < 0) {
            return jump(node.previous, currentCounter + 1, counter);
        } else if (currentCounter == 0) {
//            node.setValue(node.getValue() + 1);
            int updatedValue = node.value + 1;
            node.setValue(updatedValue);
            return jump(node, node.getValue() - 1, counter + 1);
        } else {
            throw new IllegalArgumentException();
        }


    }

}
