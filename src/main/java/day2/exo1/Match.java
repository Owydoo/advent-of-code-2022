package day2.exo1;

import lombok.AllArgsConstructor;
import lombok.Data;

import static day2.exo1.Main.*;

@Data
@AllArgsConstructor
public class Match {
    private GameEnum hisInput;
    private PlayerInput myInput;
    private int myScore;

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
        switch (getHisInput()){
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
}
