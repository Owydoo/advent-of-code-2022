package day4.exo1;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Section {
    private int first, last;

    public boolean oneSectionIncludedInTheOther(Section section) {
//        if (this.first <= section.first && this.last >= section.last){
//            return true;
//        }

        return (this.first <= section.first && this.last >= section.last) || (section.first <= this.first && section.last >= this.last);
    }

//            1-1,2-80
//            28-58,59-59
//            35-36,36-36
//            1-48,1-75
//            1-5,14-99
//            44-60,44-77
//            97-97,6-98
}
