package model.toy.comparators;

import model.toy.Toy;

import java.util.Comparator;

public class ToyComparatorByName implements Comparator<Toy> {
    @Override
    public int compare(Toy o1, Toy o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
