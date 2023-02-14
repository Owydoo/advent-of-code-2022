package year2022.day3.exo2;

import lombok.Data;

@Data
public class ElfGroup {
    private String elf1, elf2, elf3;

    public String getBadge() {
        for (int i = 0; i < elf1.length(); i++) {
            String charToFind = String.valueOf(elf1.charAt(i));
            if (elf2.contains(charToFind) && elf3.contains(charToFind)){
                return charToFind;
            }
        }
        return "";
    }
}
