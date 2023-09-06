package model.file_handler;

import model.toystore.ToyStore;

import java.io.*;

public class FileHandler {

    public boolean save(ToyStore toys, String storeName) {
        try (ObjectOutputStream save = new ObjectOutputStream(new FileOutputStream(storeName.toLowerCase() + ".out"))) {
            save.writeObject(toys);
            return true;
        } catch (IOException e) {
            return false;
        }
    }
    public ToyStore read(String path) {
        try (ObjectInputStream read = new ObjectInputStream(new FileInputStream(path.toLowerCase() + ".out"))){
            ToyStore result = (ToyStore) read.readObject();
            return result;
        } catch (IOException | ClassNotFoundException e) {
            return null;
        }
    }
}
