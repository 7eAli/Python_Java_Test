package view.commands;

import view.ConsoleUI;

public class deductAmount extends Command{
    public deductAmount(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Уменьшить количество определенных игрушек";
    }

    @Override
    public void execute() {
        consoleUI.deductAmount();
    }
}
