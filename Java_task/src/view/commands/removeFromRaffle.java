package view.commands;

import view.ConsoleUI;

public class removeFromRaffle extends Command{
    public removeFromRaffle(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Удалить игрушку из розыгрыша";
    }

    @Override
    public void execute() {
        consoleUI.removeFromRaffle();
    }
}
