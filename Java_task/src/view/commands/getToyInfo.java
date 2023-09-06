package view.commands;

import view.ConsoleUI;

public class getToyInfo extends Command{
    public getToyInfo(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Получить информацию о конкретной игрушке";
    }

    @Override
    public void execute() {
        consoleUI.getToyInfo();
    }
}
