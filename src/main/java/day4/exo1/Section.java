package day4.exo1;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Section {
    private int first, last;

    public boolean containsNumber(int number) {
        return (number >= this.getFirst() && number <= this.getLast());
    }

    public boolean contains(Section section) {
        return (this.containsNumber(section.getFirst()) && this.containsNumber(section.getLast()));
    }
}
