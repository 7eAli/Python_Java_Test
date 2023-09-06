package view.commands;

import view.ConsoleUI;

public class addToy extends Command{
    public addToy(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить новую игрушку в магазин";
    }

    @Override
    public void execute() {
        consoleUI.addToy();
    }
}
