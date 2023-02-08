package day2_2015.exo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Present {
    int l, w, h;

    public int howMuchPaper(){
        return 2*l*w + 2*w*h + 2*h*l + this.getLowerSide();
    }

    public int getLowerSide(){
        int max = Math.max(l, Math.max(w, h));
        List<Integer> list = new ArrayList<>();
        list.add(l);
        list.add(w);
        list.add(h);
        list.remove(list.indexOf(max));
        return list.get(0) * list.get(1);
    }
}
