package model.toy.comparators;

import model.toy.Toy;

import java.util.Comparator;

public class ToyComparatorByPrice implements Comparator<Toy> {
    @Override
    public int compare(Toy o1, Toy o2) {
        return Double.compare(o1.getPrice(), o2.getPrice());
    }
}
