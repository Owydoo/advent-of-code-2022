package year2016.day3.exo;

import lombok.Data;

@Data
public class PotentialTriangle {
    int a;
    int b;
    int c;

    public boolean isPotentialTriangleValid() {
        return ((a + b > c) && (a + c > b) && (b + c > a));
    }
}
