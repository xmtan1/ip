import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

//problems:
// delete -> if index is out of array, it returns 'please add description'


public class Lisa {

    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    public Lisa(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        tasks = new TaskList(storage);
    }

    public void run() {
        ui.welcomeMessage();
        String input = ui.readInput();
        while (!input.equals("bye")) {
            String[] command = Parser.parseCommand(input);
            tasks.execute(command);
            input = ui.readInput();
        }
        storage.saveTasks(tasks.tasks);
        ui.farewellMessage();

    }

    public static void main(String[] args) {
        new Lisa("data/Lisa.txt").run();
    }
}
