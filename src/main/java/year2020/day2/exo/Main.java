package year2020.day2.exo;

import utils.Parsing;

import java.util.List;

public class Main {

    public static void main(String[] args) {
//        String filename = "src/main/java/year2020/day2/inputs/input1.txt";
        String filename = "src/main/java/year2020/day2/inputs/input2.txt";

        List<String> inputs = Parsing.parseTextFile(filename);

        int result = getResultExo1(inputs);

        System.out.println("result : " + result);
    }

    private static int getResultExo1(List<String> inputs) {
        int res = 0;

        for (String input : inputs) {
            Instruction instruction = getInstructionFromInput(input);
            if (instruction.isPasswordValid()){
                res++;
            }
        }

        return res;
    }

    private static Instruction getInstructionFromInput(String input) {
        Instruction instruction = new Instruction();

        String[] inputTab = input.split(" ");

        String[] ruleTab = inputTab[0].split("-");
        instruction.setMin(Integer.parseInt(ruleTab[0]));
        instruction.setMax(Integer.parseInt(ruleTab[1]));

        instruction.setLetter(inputTab[1].charAt(0));

        instruction.setPassword(inputTab[2]);

        return instruction;
    }
}
