package day2.exo1;

import lombok.Data;

@Data
public class PlayerInput {
    private String input;
    private GameEnum gameInput;
    private int defaultScore;

    public PlayerInput(String input) {
        this.input = input;
        this.gameInput = getGameInputFromInput();
        this.defaultScore = calculateMyScoreInput();
    }

    private GameEnum getGameInputFromInput() {
        return switch (getInput()) {
            case "X" -> GameEnum.ROCK;
            case "Y" -> GameEnum.PAPER;
            case "Z" -> GameEnum.SCISSORS;
            default -> GameEnum.SCISSORS;
        };
    }

    private int calculateMyScoreInput() {
        return switch (getGameInput()) {
            case ROCK -> 1;
            case PAPER -> 2;
            case SCISSORS -> 3;
        };
    }
}
