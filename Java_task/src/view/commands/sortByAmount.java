package view.commands;

import view.ConsoleUI;

public class sortByAmount extends Command{
    public sortByAmount(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Отсортировать каталог по количеству игрушек";
    }

    @Override
    public void execute() {
        consoleUI.sortByAmount();
    }
}
