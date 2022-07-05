package list.arraylist;

import java.util.Comparator;

public class BrandComparator implements Comparator<Vehicle> {
    @Override
    public int compare(Vehicle o1, Vehicle o2) {
        return o1.getMakeYear() - o2.getMakeYear();
    }
}
