package year2016.day2.exo;

import utils.Parsing;

import java.util.List;

public class Main {
    public static void main(String[] args) {
//        String filename = "src/main/java/year2016/day2/inputs/input1.txt";
        String filename = "src/main/java/year2016/day2/inputs/input2.txt";

        List<String> inputsInString = Parsing.parseTextFile(filename);
//        System.out.println(inputsInString);

        char[][] keyboard1 = {{'1', '2', '3'}, {'4', '5', '6'}, {'7', '8', '9'}};
//        System.out.println(printKeyboard(keyboard1));

        String answerFromExo1 = getAnswerFromExo1(keyboard1, inputsInString);
        System.out.println("res for exo 1 :" + answerFromExo1);

        char[][] keyboard2 = {
                {' ', ' ', '1', ' ', ' '},
                {' ', '2', '3', '4', ' '},
                {'5', '6', '7', '8', '9'},
                {' ', 'A', 'B', 'C', ' '},
                {' ', ' ', 'D', ' ', ' '}
        };
        String answerFromExo2 = getAnswerFromExo2(keyboard2, inputsInString);
        System.out.println("res for exo 2 :" + answerFromExo2);
    }

    private static String getAnswerFromExo2(char[][] keyboard, List<String> inputsInString) {
        //position de départ
        int posX = 0;
        int posY = 2;
        StringBuilder res = new StringBuilder();
        for (String directions : inputsInString) {
            for (char direction : directions.toCharArray()) {
                switch (direction) {
                    case 'U' -> {
                        if (posY > 0 && keyboard[posY - 1][posX] != ' ') {
                            posY--;
                        }
                    }
                    case 'D' -> {
                        if (posY < keyboard.length - 1 && keyboard[posY + 1][posX] != ' ') {
                            posY++;
                        }
                    }
                    case 'L' -> {
                        if (posX > 0 && keyboard[posY][posX - 1] != ' ') {
                            posX--;
                        }
                    }
                    case 'R' -> {
                        if (posX < keyboard[posY].length - 1 && keyboard[posY][posX + 1] != ' ') {
                            posX++;
                        }
                    }
                    default -> throw new IllegalArgumentException();
                }
            }
            res.append(keyboard[posY][posX]);
        }
        return res.toString();
    }

    private static String getAnswerFromExo1(char[][] keyboard, List<String> inputsInString) {
        int posX = 1; //position de départ
        int posY = 1;
        StringBuilder res = new StringBuilder();

        for (String directions : inputsInString) {
            for (char direction : directions.toCharArray()) {
                switch (direction) {
                    case 'U' -> {
                        if (posY > 0) {
                            posY--;
                        }
                    }
                    case 'D' -> {
                        if (posY < keyboard.length - 1) {
                            posY++;
                        }
                    }
                    case 'L' -> {
                        if (posX > 0) {
                            posX--;
                        }
                    }
                    case 'R' -> {
                        if (posX < keyboard[0].length - 1) {
                            posX++;
                        }
                    }
                    default -> throw new IllegalArgumentException();
                }
            }
            res.append(keyboard[posY][posX]);
        }
        return res.toString();
    }

    public static String printKeyboard(char[][] keyboard) {
        StringBuilder res = new StringBuilder();
        res.append('[');
        for (int i = 0; i < keyboard.length; i++) {
            res.append('[');
            for (int j = 0; j < keyboard[i].length; j++) {
                res.append(keyboard[i][j]);
                res.append(',');
            }
            res.append(']');
        }
        res.append(']');
        return res.toString();
    }
}
