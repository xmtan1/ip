import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;


/**
 * A personal assistant chatbot named Lisa. Helps to keep a list
 * of tasks, deadlines and events for the user to refer to.
 *
 */
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
                String[] command = null;
                try {
                    command = Parser.parseCommand(input);
                    tasks.execute(command);
                } catch (ArrayIndexOutOfBoundsException e) {
                    Ui.printDescriptionError(command);
                } finally {
                    storage.saveTasks(tasks.tasks);
                    input = ui.readInput();
                }
            }

        ui.farewellMessage();
    }

    public static void main(String[] args) {
        new Lisa("data/Lisa.txt").run();
    }
}
