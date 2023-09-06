package view.commands;

import view.ConsoleUI;

public class sortByID extends Command{
    public sortByID(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Отсортировать каталог по ID";
    }

    @Override
    public void execute() {
        consoleUI.sortByID();
    }
}
