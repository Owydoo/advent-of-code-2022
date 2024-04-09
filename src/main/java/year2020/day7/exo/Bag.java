package year2020.day7.exo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Data
@NoArgsConstructor
public class Bag {
    private String name;
    private HashMap<String, Integer> otherBags =  new HashMap<>();

    public void addOtherBag(String otherBag, int quantity) {
        this.otherBags.put(otherBag, quantity);
    }

    @Override
    public String toString() {
        return name + " => " + String.join(", ", otherBags.keySet().stream().toList()) + "\n";
    }
}
