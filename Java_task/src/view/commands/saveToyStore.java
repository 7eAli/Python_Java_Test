package view.commands;

import view.ConsoleUI;

public class saveToyStore extends Command{
    public saveToyStore(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Сохранить магазин в файл";
    }

    @Override
    public void execute() {
        consoleUI.saveToyStore();
    }
}
