package view.commands;

import view.ConsoleUI;

public class addAmount extends Command{
    public addAmount(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Увеличить количество определенных игрушек";
    }

    @Override
    public void execute() {
        consoleUI.addAmount();
    }
}
