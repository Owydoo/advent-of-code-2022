package year2018.day3.exo;

import lombok.Builder;
import lombok.Data;
import year2017.day2.exo.Pair;

@Data
@Builder
public class Claim {
    int id;
    Coordinate origin;
    Pair<Integer, Integer> size;
}
