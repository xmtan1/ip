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

    /**
     * Constructs a Lisa class with an ui handler, task list and a
     * specified file path for storage.
     * @param filePath
     */
    public Lisa(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        tasks = new TaskList(storage);
    }


    /**
     * Starts the main loop of the chatbot. It displays the welcome message, reads
     * user inputs and executes command until user inputs "bye" and displays a farewell
     * message before closing.
     *
     * The loop handles parsing errors and returns an error message. After each
     * command is executed, the list of tasks is updated and saved.
     *
     */
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

    /**
     * The entry point of the chatbot. It initialises a new instance of
     * Lisa with a specified file path for data storage and starts the chatbot
     * by calling run().
     *
     * @param args Command-line arguments passed to the program (not used in this
     *             implementation).
     */
    public static void main(String[] args) {
        new Lisa("Lisa_data/Lisa.txt").run();
    }
}
