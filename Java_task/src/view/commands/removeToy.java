package view.commands;

import view.ConsoleUI;

public class removeToy extends Command{
    public removeToy(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Удалить игрушку из магазина";
    }

    @Override
    public void execute() {
        consoleUI.removeToy();
    }
}
