package presenter;

import model.Service;
import model.file_handler.FileHandler;
import model.raffle.RaffleManager;
import model.toy.Toy;
import model.toystore.ToyStore;
import view.View;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service(new ToyStore(), new FileHandler(), new RaffleManager());
    }
    public void addToy(String name, Double price) {
        service.addToy(name, price);
    }
    public void removeToy(int id) {
        service.removeToy(id);
    }
    public void changePrice(int id, double newPrice) { service.changePrice(id, newPrice); }
    public void addAmount(int id, int addition) {
        service.addAmount(id, addition);
    }
    public void deductAmount(int id, int deduction) {
        service.deductAmount(id, deduction);
    }
    public void addToRaffle(int id, int raffleValue) {
        service.addToRaffle(id, raffleValue);
    }
    public void removeFromRaffle(int id) {
        service.removeFromRaffle(id);
    }
    public String makeRaffle() {
        return service.makeRaffle();
    }
    public int getToyStoreSize() {
        return service.getToyStoreSize();
    }
    public void sortByAmount() {
        service.sortByAmount();
    }
    public void sortByName() {
        service.sortByName();
    }
    public void sortByPrice() {
        service.sortByPrice();
    }
    public void sortByID() {
        service.sortByID();
    }
    public String getToyInfo(int id) {
        return service.getToyInfo(id);
    }
    public String getToyStoreInfo() {
        return service.getToyStoreInfo();
    }
    public boolean saveToyStore(String fileName) { return service.saveToyStore(fileName); }
    public boolean loadToyStore(String fileName) {
        return service.loadToyStore(fileName);
    }
}
