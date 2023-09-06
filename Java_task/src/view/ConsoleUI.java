package view;

import presenter.Presenter;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ConsoleUI implements View {
    private Scanner scanner;
    private Presenter presenter;
    private boolean working;
    private Menu menu;

    public ConsoleUI() {
        scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        presenter = new Presenter(this);
        working = true;
        menu = new Menu(this);
    }
    public void addToy() {
        System.out.println("Введите название игрушки: ");
        String name = scanner.nextLine();
        double price = typeDouble("Введите цену игрушки: ", "Неправильный формат цены");
        presenter.addToy(name, price);
    }
    public void removeToy() {
        getToyStoreInfo();
        int id = typeID("Введите id игрушки: ", "Неправильный формат id");
        presenter.removeToy(id);
    }
    public void changePrice() {
        getToyStoreInfo();
        int id = typeID("Введите id игрушки: ", "Неправильный формат id");
        double newPrice = typeDouble("Введите новую цену", "Неправильный формат цены");
        presenter.changePrice(id, newPrice);
    }
    public void addAmount() {
        getToyStoreInfo();
        int id = typeID("Введите id игрушки: ", "Неправильный формат id");
        int addition = typeInteger("Введите количество: ", "Неправильный формат количества");
        presenter.addAmount(id, addition);
    }
    public void deductAmount() {
        getToyStoreInfo();
        int id = typeID("Введите id игрушки: ", "Неправильный формат id");
        int deduction = typeInteger("Введите количество: ", "Неправильный формат количества");
        presenter.deductAmount(id, deduction);
    }
    public void addToRaffle() {
        getToyStoreInfo();
        int id = typeID("Введите id игрушки: ", "Неправильный формат id");
        int raffleValue = 0;
        boolean flag = true;
        while (flag) {
            raffleValue = typeInteger("Введите вес игрушки в розыгрыше от 1 до 10", "Неправильный формат веса");
            if (raffleValue > 0 && raffleValue < 11) flag = false;
            else System.out.println("Неправильное значение веса");
        }
        presenter.addToRaffle(id, raffleValue);
    }
    public void removeFromRaffle() {
        getToyStoreInfo();
        int id = typeID("Введите id игрушки: ", "Неправильный формат id");
        presenter.removeFromRaffle(id);
    }
    public void makeRaffle() {
        System.out.println("Вы выиграли:");
        System.out.println(presenter.makeRaffle());
    }
    public void sortByAmount() {
        presenter.sortByAmount();
    }
    public void sortByName() {
        presenter.sortByName();
    }
    public void sortByPrice() {
        presenter.sortByPrice();
    }
    public void sortByID() {
        presenter.sortByID();
    }
    public void getToyInfo() {
        boolean flag = true;
        while (flag) {
            int id = typeID("Введите id игрушки: ", "Неправильный формат id");
            if (id < (presenter.getToyStoreSize()) && id >= 0) {
                System.out.println(presenter.getToyInfo(id));
                flag = false;
            } else System.out.println("Такой игрушки нет");
        }
    }
    public void getToyStoreInfo() {
        System.out.println(presenter.getToyStoreInfo());
    }
    public void saveToyStore() {
        System.out.println("Введите имя файла");
        String fileName = scanner.nextLine();
        if (presenter.saveToyStore(fileName)) System.out.println("Файл сохранен");
        else System.out.println("Файл не сохранен");
    }
    public void loadToyStore() {
        System.out.println("Введите имя файла");
        String fileName = scanner.nextLine();
        if (presenter.loadToyStore(fileName)) System.out.println("Файл загружен");
        else System.out.println("Файла не существует");
    }
    public void work() {
        String str_command = scanner.nextLine();
        if (str_command.matches("[0-9]+")) {
            int command = Integer.parseInt(str_command);
            if (command <= menu.getSize()) menu.execute(command);
        }
    }
    @Override
    public void start() {
        System.out.println("Здравствуйте");
        while (working) {
            System.out.println(menu.display());
            work();
        }
    }
    @Override
    public void finish() {
        System.out.println("До свидания");
        working = false;
    }
    public int typeID(String instructionMessage, String errorMessage) {
        boolean flag = true;
        int result = 0;
        while (flag) {
            System.out.println(instructionMessage);
            String preNumber = scanner.nextLine();
            if (preNumber.matches("[0-9]+")) {
                if (Integer.parseInt(preNumber) >= 0 && Integer.parseInt(preNumber) < presenter.getToyStoreSize()) {
                    result = Integer.parseInt(preNumber);
                    flag = false;
                } else System.out.println("Вы вышли за пределы каталога");
            } else System.out.println(errorMessage);
        }
        return result;
    }
    public int typeInteger(String instructionMessage, String errorMessage) {
        boolean flag = true;
        int result = 0;
        while (flag) {
            System.out.println(instructionMessage);
            String preNumber = scanner.nextLine();
            if (preNumber.matches("[0-9]+")) {
                result = Integer.parseInt(preNumber);
                flag = false;
            } else System.out.println(errorMessage);
        }
        return result;
    }
    public double typeDouble(String instructionMessage, String errorMessage) {
        boolean flag = true;
        double result = 0;
        while (flag) {
            System.out.println(instructionMessage);
            String preNumber = scanner.nextLine();
            if (preNumber.matches("[0-9]+.+[0-9]")) {
                result = Double.parseDouble(preNumber);
                flag = false;
            } else System.out.println(errorMessage);
        }
        return result;
    }
}
