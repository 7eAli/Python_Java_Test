package view.commands;

import view.ConsoleUI;

public class sortByName extends Command{
    public sortByName(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Отсортировать каталог по названию игрушек";
    }

    @Override
    public void execute() {
        consoleUI.sortByName();
    }
}
