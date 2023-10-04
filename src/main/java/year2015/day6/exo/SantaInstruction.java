package year2015.day6.exo;

import lombok.Builder;
import lombok.Data;
import year2017.day2.exo.Pair;

@Data
@Builder
public class SantaInstruction {
    Action action;
    Pair<Integer, Integer> startCoordinates;
    Pair<Integer, Integer> endCoordinates;
}
