package model.raffle;

import model.toy.Toy;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MathMethods {
    public int getRandomNumber(int upperLimit) {
        return ThreadLocalRandom.current().nextInt(1, upperLimit + 1);
    }

    public int calculateAmount(ArrayList<Toy> toys, int id) {
        int result = 0;
        for (int i = 0; i < id; i++) {
            result += toys.get(i).getAmount();
        }
        return result;
    }
}
