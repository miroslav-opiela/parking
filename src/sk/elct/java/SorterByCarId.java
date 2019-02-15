package sk.elct.java;

import java.util.Comparator;

public class SorterByCarId implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        return o1.getCarId().compareTo(o2.getCarId());
    }
}
