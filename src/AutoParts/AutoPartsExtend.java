package AutoParts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class AutoPartsExtend extends AutoParts {

    private int durability;

    public AutoPartsExtend(String vendor, String dimension, float price, int availableSpace, int durability) {
        super(vendor, dimension, price, availableSpace);
        this.durability = durability;
    }

    public AutoPartsExtend(AutoPartsExtend obj) {
        super(obj);
        this.durability = obj.getDurability();
    }

    public AutoPartsExtend() {
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public int getDurability() {
        return durability;
    }

    public void sortDurability(ArrayList<AutoPartsExtend> list) {
        ArrayList<AutoPartsExtend> temp = new ArrayList<AutoPartsExtend>(list);
        Collections.sort(temp, new Comparator<AutoPartsExtend>() {
            @Override
            public int compare(AutoPartsExtend o1, AutoPartsExtend o2) {
                return Integer.compare(o1.getDurability(), o2.getDurability());
            }
        });
    }

    @Override
    public void sortAscending(ArrayList<AutoParts> list, String str) {
        super.sortAscending(list, str);
    }
}
