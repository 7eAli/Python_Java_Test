package view.commands;

import view.ConsoleUI;

public class changePrice extends Command{
    public changePrice(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Изменить цену игрушки";
    }

    @Override
    public void execute() {
        consoleUI.changePrice();
    }
}
