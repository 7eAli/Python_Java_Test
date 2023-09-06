package view.commands;

import view.ConsoleUI;

public class sortByPrice extends Command{
    public sortByPrice(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Отсортировать каталог по цене";
    }

    @Override
    public void execute() {
        consoleUI.sortByPrice();
    }
}
