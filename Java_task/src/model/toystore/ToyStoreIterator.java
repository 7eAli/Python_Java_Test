package model.toystore;

import model.toy.Toy;

import java.util.Iterator;
import java.util.List;

public class ToyStoreIterator implements Iterator<Toy> {
    private int index;
    private List<Toy> toys;

    public ToyStoreIterator(List<Toy> toys) {
        this.index = index;
        this.toys = toys;
    }

    @Override
    public boolean hasNext() {
        return toys.size() > index;
    }

    @Override
    public Toy next() {
        return toys.get(index++);
    }
}
