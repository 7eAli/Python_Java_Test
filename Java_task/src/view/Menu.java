package view;

import view.commands.*;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Command> commands;

    public Menu(ConsoleUI consoleUI) {
        commands = new ArrayList<>();
        commands.add(new addToy(consoleUI));
        commands.add(new removeToy(consoleUI));
        commands.add(new changePrice(consoleUI));
        commands.add(new getToyStoreInfo(consoleUI));
        commands.add(new getToyInfo(consoleUI));
        commands.add(new addAmount(consoleUI));
        commands.add(new deductAmount(consoleUI));
        commands.add(new addToRaffle(consoleUI));
        commands.add(new removeFromRaffle(consoleUI));
        commands.add(new makeRaffle(consoleUI));
        commands.add(new saveToyStore(consoleUI));
        commands.add(new loadToyStore(consoleUI));
        commands.add(new sortByID(consoleUI));
        commands.add(new sortByName(consoleUI));
        commands.add(new sortByPrice(consoleUI));
        commands.add(new sortByAmount(consoleUI));
        commands.add(new Finish(consoleUI));
    }
    public String display(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commands.size(); i++){
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(commands.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int choice){
        commands.get(choice - 1).execute();
    }

    public int getSize() {
        return commands.size();
    }
}
