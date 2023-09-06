package view.commands;

import view.ConsoleUI;

public class makeRaffle extends Command{
    public makeRaffle(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Провести розыгрыш";
    }

    @Override
    public void execute() {
        consoleUI.makeRaffle();
    }
}
