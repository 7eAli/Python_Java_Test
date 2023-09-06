package model.raffle;

import model.toy.Toy;

import java.util.ArrayList;

public class RaffleManager {
    public Toy makeRaffle(ArrayList<Toy> toys) {
        MathMethods mathMethods = new MathMethods();
        boolean flag = true;
        Toy result = null;
        if (rafflePossibility(toys)) {
            while (flag) {
                int randomFirst = mathMethods.getRandomNumber(mathMethods.calculateAmount(toys, toys.size()));
                int currentAmount = 0;
                int nextAmount = toys.get(0).getAmount();
                int currentId = 0;
                boolean flag2 = true;
                while (flag2) {
                    if (randomFirst >= currentAmount && randomFirst <= nextAmount) {
                        flag2 = false;
                    } else {
                        if (currentId < toys.size() - 1) {
                            currentId++;
                            currentAmount += nextAmount;
                            nextAmount += toys.get(currentId).getAmount();
                        }
                    }
                }
                int randomSecond = mathMethods.getRandomNumber(10);
                if (toys.get(currentId).getRaffle_value() >= randomSecond) {
                    toys.get(currentId).deductAmount(1);
                    flag = false;
                    result = toys.get(currentId);
                }
            }
        }
        return result;
    }
    public boolean rafflePossibility(ArrayList<Toy> toys){
        int amount = 0;
        int raffleValue = 0;
        for (Toy toy : toys) {
            amount += toy.getAmount();
            raffleValue += toy.getRaffle_value();
        }
        return amount != 0 && raffleValue != 0;
    }
}
