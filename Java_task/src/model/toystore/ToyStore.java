package model.toystore;

import model.toy.Toy;
import model.toy.comparators.ToyComparatorByAmount;
import model.toy.comparators.ToyComparatorByID;
import model.toy.comparators.ToyComparatorByName;
import model.toy.comparators.ToyComparatorByPrice;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ToyStore implements Serializable, Iterable<Toy> {
    private int toyId;
    private ArrayList<Toy> toys;

    public ToyStore() {
        toys = new ArrayList<>();
    }

    public void addToy(Toy toy) {
        if (toy != null && !toys.contains(toy)) {
            toys.add(toy);
            toy.setId(toyId++);
        }
    }
    public void removeToy(int id) {
        toys.remove(id);
        for (int i = id; i < toys.size(); i++) {
            int newId = toys.get(i).getId() - 1;
            toys.get(i).setId(newId);
        }
    }

    public ArrayList<Toy> getToys() {
        return toys;
    }

    public Toy getToy(int id) {
        return toys.get(id);
    }
    public int getSize() {
        return toys.size();
    }
    public void sortByAmount() {toys.sort(new ToyComparatorByAmount());}
    public void sortByName() {toys.sort(new ToyComparatorByName());}
    public void sortByPrice() {toys.sort(new ToyComparatorByPrice());}
    public void sortByID() {toys.sort(new ToyComparatorByID());}
    @Override
    public Iterator<Toy> iterator() {
        return new ToyStoreIterator(toys);
    }

    @Override
    public String toString() {
        return toyStoreInfo();
    }

    public String toyStoreInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Toy toy : toys) {
            stringBuilder.append(toy.toString());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
