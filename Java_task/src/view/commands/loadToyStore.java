package view.commands;

import view.ConsoleUI;

public class loadToyStore extends Command{
    public loadToyStore(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Загрузить магазин игрушек из файла";
    }

    @Override
    public void execute() {
        consoleUI.loadToyStore();
    }
}
