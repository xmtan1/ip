import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * The Storage class manages the storage of tasks.
 * This class provides methods to save tasks to and load tasks from a file.
 * The tasks are stored in a file whose path is provided during instantiation.
 *
 */
public class Storage {
    private String filePath;

    /**
     * Constructs a Storage object with a specified file path.
     *
     * @param filePath the path of the file were tasks will be saved or loaded from.
     */
    public Storage(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Loads tasks from the file specified by filePath and adds them to a list of tasks.
     *
     * @param tasks the list to which the tasks read from the file will be added to.
     */
    public void transferSavedData(ArrayList<Task> tasks) {
        File savedTasks = new File(filePath);
        try {
            if (savedTasks.exists()) {
                FileHandler newFile = new FileHandler(savedTasks);
                newFile.addTaskFromFile(tasks);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Saves the list of tasks to the file specified by filePath.
     * If the file does not exist, it will create the necessary directory
     * and file before saving.
     * If the file exists, it will overwrite the existing content.
     *
     * @param tasks the list of tasks to be saved to the file.
     */
    public void saveTasks(ArrayList<Task> tasks) {
        File savedTasks = new File(filePath);
        try {
            if(savedTasks.exists()) {
                FileHandler newFile = new FileHandler(savedTasks);
                newFile.writeToFile(tasks);
            } else {
                Files.createDirectory(Paths.get("Lisa_data"));
                Files.createFile(Paths.get(filePath));
                FileHandler newFile = new FileHandler(savedTasks);
                newFile.writeToFile(tasks);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
