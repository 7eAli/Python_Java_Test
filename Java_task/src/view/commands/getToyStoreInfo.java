package view.commands;

import view.ConsoleUI;

public class getToyStoreInfo extends Command{
    public getToyStoreInfo(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Вывести полную информацию о товарах магазина игрушек";
    }

    @Override
    public void execute() {
        consoleUI.getToyStoreInfo();
    }
}
