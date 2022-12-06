package day5.exo1;

import utils.Parsing;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // https://adventofcode.com/2022/day/5
        System.out.println("Exercices Advent of Code réalisés sur twitch.tv/Owydoo le 05/12/22");

        String filename = "src/main/java/day5/inputs/input2.txt";

        List<String> lines = Parsing.parseTextFile(filename);

        // Parsing des instructions dans l'input
        List<Instruction> instructions = getInstructionsLineByLine(lines);
        System.out.println(instructions);

        //get Stacks from cratesLines
        Map<Integer, Stack<String>> stacks = fillStacks();
        System.out.println(stacks);

        // Déplacer les crates instruction par instruction : exo1
        // moveStacks(stacks, instructions);

        // Déplacer les crates plusieurs à la fois : exo 2
        moveCratesWithCrateMover9001(stacks, instructions);

        //Lire le haut de chaque stack
        String res = readStacksTops(stacks);
        System.out.println("res : " + res);
    }

    private static void moveCratesWithCrateMover9001(Map<Integer, Stack<String>> stacks, List<Instruction> instructions) {
        //pour l'exo2
        for (Instruction instruction : instructions) {
            //remplir la pince
            Stack<String> clamp = new Stack<>();
            for (int i = 0; i < instruction.getNumberOfCrates(); i++) {
                clamp.push(stacks.get(instruction.getStartStack()).pop());
            }
            //vider la pince
            for (int i = 0; i < instruction.getNumberOfCrates(); i++) {
                stacks.get(instruction.getEndStack()).push(clamp.pop());
            }
        }
    }

    private static String readStacksTops(Map<Integer, Stack<String>> stacks) {
        String res = "";
        for (int i = 1; i <= 9; i++) {
            res += stacks.get(i).peek();
        }
        return res;
    }

    private static void moveStacks(Map<Integer, Stack<String>> stacks, List<Instruction> instructions) {
        //pour l'exo 1
        for (Instruction instruction : instructions) {
            for (int i = 0; i < instruction.getNumberOfCrates(); i++) {
                String crate = stacks.get(instruction.getStartStack()).pop();
                stacks.get(instruction.getEndStack()).push(crate);
            }
        }
    }

    private static List<Instruction> getInstructionsLineByLine(List<String> lines) {
        List<Instruction> res = new ArrayList<>();
        for (String line : lines) {
            String[] instructionInString = line.split(" ");
            Instruction instruction = new Instruction();
            instruction.setNumberOfCrates(Integer.parseInt(instructionInString[1]));
            instruction.setStartStack(Integer.parseInt(instructionInString[3]));
            instruction.setEndStack(Integer.parseInt(instructionInString[5]));
            res.add(instruction);
        }
        return res;
    }

    private static Map<Integer, Stack<String>> fillStacks() {
        Stack<String> stack1 = new Stack<>();
        stack1.push("Z");
        stack1.push("J");
        stack1.push("N");
        stack1.push("W");
        stack1.push("P");
        stack1.push("S");

        Stack<String> stack2 = new Stack<>();
        stack2.push("G");
        stack2.push("S");
        stack2.push("T");

        Stack<String> stack3 = new Stack<>();
        stack3.push("V");
        stack3.push("Q");
        stack3.push("R");
        stack3.push("L");
        stack3.push("H");

        Stack<String> stack4 = new Stack<>();
        stack4.push("V");
        stack4.push("S");
        stack4.push("T");
        stack4.push("D");

        Stack<String> stack5 = new Stack<>();
        stack5.push("Q");
        stack5.push("Z");
        stack5.push("T");
        stack5.push("D");
        stack5.push("B");
        stack5.push("M");
        stack5.push("J");

        Stack<String> stack6 = new Stack<>();
        stack6.push("M");
        stack6.push("W");
        stack6.push("T");
        stack6.push("J");
        stack6.push("D");
        stack6.push("C");
        stack6.push("Z");
        stack6.push("L");

        Stack<String> stack7 = new Stack<>();
        stack7.push("L");
        stack7.push("P");
        stack7.push("M");
        stack7.push("W");
        stack7.push("G");
        stack7.push("T");
        stack7.push("J");

        Stack<String> stack8 = new Stack<>();
        stack8.push("N");
        stack8.push("G");
        stack8.push("M");
        stack8.push("T");
        stack8.push("B");
        stack8.push("F");
        stack8.push("Q");
        stack8.push("H");

        Stack<String> stack9 = new Stack<>();
        stack9.push("R");
        stack9.push("D");
        stack9.push("G");
        stack9.push("C");
        stack9.push("P");
        stack9.push("B");
        stack9.push("Q");
        stack9.push("W");

        Map<Integer, Stack<String>> res = new HashMap<>();

        res.put(1, stack1);
        res.put(2, stack2);
        res.put(3, stack3);
        res.put(4, stack4);
        res.put(5, stack5);
        res.put(6, stack6);
        res.put(7, stack7);
        res.put(8, stack8);
        res.put(9, stack9);

        return res;
    }
}
