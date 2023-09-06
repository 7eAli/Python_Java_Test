package model.toy;

import java.io.Serializable;
import java.util.Objects;

public class Toy implements Comparable<Toy>, Serializable {
    private int id;
    private double price;
    private String name;
    private int amount;
    private int raffle_value;

    public Toy(double price, String name) {
        id = -1;
        this.price = price;
        this.name = name;
        raffle_value = 0;
        amount = 0;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void addAmount(int addition) {
        amount += addition;
    }

    public void deductAmount(int deduction) {
        if (deduction > amount) {
            amount = 0;
        } else {
            amount -= deduction;
        }
    }

    public int getRaffle_value() {
        return raffle_value;
    }

    public void setRaffle_value(int raffle_value) {
        this.raffle_value = raffle_value;
    }

    @Override
    public String toString() {
        return id + "; " + name + "; Цена: " + price + "; Осталось: " + amount + "; Вес в розыгрыше: " + raffle_value + ".";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Toy toy = (Toy) o;
        return id == toy.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, name, amount, raffle_value);
    }

    @Override
    public int compareTo(Toy o) {
        return 0;
    }
}