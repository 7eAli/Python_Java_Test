package model.toy.comparators;

import model.toy.Toy;

import java.util.Comparator;

public class ToyComparatorByAmount implements Comparator<Toy> {
    @Override
    public int compare(Toy o1, Toy o2) {
        return Integer.compare(o1.getAmount(), o2.getAmount());
    }
}
