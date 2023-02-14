package year2015.day2.exo;

import lombok.Data;

import java.util.List;
import java.util.stream.Stream;

@Data
public class Present {
    int l, w, h;

    public int howMuchPaper() {
        return 2 * l * w + 2 * w * h + 2 * h * l + this.getSmallestSideArea();
    }

    public int getSmallestSideArea() {
        List<Integer> list = getTheTwoSmallDimensions();
        return list.get(0) * list.get(1);
    }

    private List<Integer> getTheTwoSmallDimensions() {
        int max = Math.max(l, Math.max(w, h));
        return Stream.of(l, w, h).filter(el -> el != max).toList();
    }

    public int howMuchRibbon() {
        return getSmallestPerimeter() + getCubicFeet();
    }

    private int getCubicFeet() {
        return l * w * h;
    }

    private int getSmallestPerimeter() {
        return getTheTwoSmallDimensions().stream()
                .mapToInt(el -> el * 2)
                .sum();
    }
}
