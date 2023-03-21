package year2020.day2.exo;

import utils.Parsing;

import java.util.List;

public class Main {

    public static void main(String[] args) {
//        String filename = "src/main/java/year2020/day2/inputs/input1.txt";
        String filename = "src/main/java/year2020/day2/inputs/input2.txt";

        List<String> inputs = Parsing.parseTextFile(filename);

        List<Instruction> instructions = inputs.stream().map(Instruction::new).toList();

        int resultExo1 = getResultExo1(instructions);

        System.out.println("resultExo1 : " + resultExo1);

        int resultExo2 = getResultExo2(instructions);

        System.out.println("resultExo2 : " + resultExo2);

    }

    private static int getResultExo2(List<Instruction> instructions) {
        return instructions.stream().mapToInt(value -> value.isPasswordValidForOTCP() ? 1 : 0).sum();
    }

    private static int getResultExo1(List<Instruction> instructions) {
        return instructions.stream().mapToInt(value -> value.isPasswordValidForOldJob() ? 1 : 0).sum();
    }

}
