package year2022.day2.exo1;

import lombok.AllArgsConstructor;
import lombok.Data;

import static year2022.day2.exo1.Main.*;

@Data
@AllArgsConstructor
public class Match {
    private GameEnum hisInput;
    private PlayerInput myInput;
    private int myScore;

    enum Result {
        WIN, DRAW, LOSS
    }

    public Result getResultByInput(PlayerInput myInput) {
        return switch (myInput.getInput()) {
            case "X" -> Result.LOSS;
            case "Y" -> Result.DRAW;
            case "Z" -> Result.WIN;
            default -> Result.LOSS;
        };
    }

    public int getScoreByResult(Result result) {
        return switch (result) {
            case WIN -> 6;
            case DRAW -> 3;
            case LOSS -> 0;
        };
    }

    public int getDefaultScoreByInput(GameEnum input) {
        return switch (input) {
            case ROCK -> 1;
            case PAPER -> 2;
            case SCISSORS -> 3;
        };
    }

    public Match(String hisInput, PlayerInput myInput) {
        this.hisInput = getHisInputGameEnum(hisInput);
        this.myInput = myInput;
        this.myScore = calculateScore();
    }

    private GameEnum getHisInputGameEnum(String hisInput) {
        return switch (hisInput) {
            case "A" -> GameEnum.ROCK;
            case "B" -> GameEnum.PAPER;
            case "C" -> GameEnum.SCISSORS;
            default -> GameEnum.SCISSORS;
        };
    }

    private int calculateScore() {
        int res = 0;
        res += getMyInput().getDefaultScore();
        res += playMatch();
        return res;
    }

    private int playMatch() {
        switch (getHisInput()) {
            case ROCK -> {
                if (getMyInput().getGameInput().equals(GameEnum.ROCK)) return draw;
                if (getMyInput().getGameInput().equals(GameEnum.PAPER)) return win;
                if (getMyInput().getGameInput().equals(GameEnum.SCISSORS)) return loss;
            }
            case PAPER -> {
                if (getMyInput().getGameInput().equals(GameEnum.ROCK)) return loss;
                if (getMyInput().getGameInput().equals(GameEnum.PAPER)) return draw;
                if (getMyInput().getGameInput().equals(GameEnum.SCISSORS)) return win;
            }
            case SCISSORS -> {
                if (getMyInput().getGameInput().equals(GameEnum.ROCK)) return win;
                if (getMyInput().getGameInput().equals(GameEnum.PAPER)) return loss;
                if (getMyInput().getGameInput().equals(GameEnum.SCISSORS)) return draw;
            }
        }
        return 0;
    }

    public int rigMatch() {
        if (getResultByInput(getMyInput()).equals(Result.LOSS)) {
            return getDefaultScoreByInput(getGameEnumToHaveResult(Result.LOSS, getHisInput())) + getScoreByResult(Result.LOSS);
        }
        if (getResultByInput(getMyInput()).equals(Result.DRAW)) {
            return getDefaultScoreByInput(getGameEnumToHaveResult(Result.DRAW, getHisInput())) + getScoreByResult(Result.DRAW);
        }
        if (getResultByInput(getMyInput()).equals(Result.WIN)) {
            return getDefaultScoreByInput(getGameEnumToHaveResult(Result.WIN, getHisInput())) + getScoreByResult(Result.WIN);
        }
        return 0;
    }

    private GameEnum getGameEnumToHaveResult(Result result, GameEnum hisInput) {
        switch (result) {
            case DRAW -> {
                return hisInput;
            }
            case WIN -> {
                if (hisInput.equals(GameEnum.ROCK)) return GameEnum.PAPER;
                if (hisInput.equals(GameEnum.PAPER)) return GameEnum.SCISSORS;
                if (hisInput.equals(GameEnum.SCISSORS)) return GameEnum.ROCK;
            }
            case LOSS -> {
                if (hisInput.equals(GameEnum.ROCK)) return GameEnum.SCISSORS;
                if (hisInput.equals(GameEnum.PAPER)) return GameEnum.ROCK;
                if (hisInput.equals(GameEnum.SCISSORS)) return GameEnum.PAPER;
            }
        }
        return hisInput;
    }
}
