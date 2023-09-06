package model;

import model.file_handler.FileHandler;
import model.raffle.RaffleManager;
import model.toy.Toy;
import model.toystore.ToyStore;

public class Service {
    private ToyStore toys;
    private FileHandler fileHandler;
    private RaffleManager raffleManager;

    public Service(ToyStore toys, FileHandler fileHandler, RaffleManager raffleManager) {
        this.toys = toys;
        this.fileHandler = fileHandler;
        this.raffleManager = raffleManager;
    }
    public void addToy(String name, Double price) {
        Toy toy = new Toy(price, name);
        toys.addToy(toy);
    }
    public void removeToy(int id) {
        toys.removeToy(id);
    }
    public void changePrice(int id, double newPrice) { toys.getToy(id).setPrice(newPrice); }
    public void addAmount(int id, int addition) {
        toys.getToy(id).addAmount(addition);
    }
    public void deductAmount(int id, int deduction) {
        toys.getToy(id).deductAmount(deduction);
    }
    public void addToRaffle(int id, int raffleValue) {
        toys.getToy(id).setRaffle_value(raffleValue);
    }
    public void removeFromRaffle(int id) {
        toys.getToy(id).setRaffle_value(0);
    }
    public String makeRaffle() {
        Toy raffleResult = raffleManager.makeRaffle(toys.getToys());
        if (raffleResult != null) return raffleResult.getName();
        else return "Ничего";
    }
    public void sortByAmount() {
        toys.sortByAmount();
    }
    public void sortByName() {
        toys.sortByName();
    }
    public void sortByPrice() {
        toys.sortByPrice();
    }
    public void sortByID() {
        toys.sortByID();
    }
    public int getToyStoreSize() {
        return toys.getSize();
    }
    public String getToyInfo(int id) {
        return toys.getToy(id).toString();
    }
    public String getToyStoreInfo() {
        return toys.toString();
    }
    public boolean saveToyStore(String fileName) {return fileHandler.save(toys, fileName);}
    public boolean loadToyStore(String fileName) {
        if (fileHandler.read(fileName) == null) {
            return false;
        }
        else {
            toys = fileHandler.read(fileName);
            return true;
        }
    }
}
