package view.commands;

import view.ConsoleUI;

public class addToRaffle extends Command{
    public addToRaffle(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить возможность разыграть игрушку";
    }

    @Override
    public void execute() {
        consoleUI.addToRaffle();
    }
}
