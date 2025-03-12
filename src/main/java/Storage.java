import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Stores the list into a hard disk when list is changed and
 * loads stored list when Lisa is started.
 * A <code>Storage</code> object contains the relative file path
 * of the hard disk
 *
 */
public class Storage {
    private String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

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

    //"data/Lisa.txt"
    public void saveTasks(ArrayList<Task> tasks) {
        File savedTasks = new File(filePath);
        try {
            if(savedTasks.exists()) {
                FileHandler newFile = new FileHandler(savedTasks);
                newFile.writeToFile(tasks);
            } else {
                Files.createDirectory(Paths.get("data"));
                Files.createFile(Paths.get(filePath));
                FileHandler newFile = new FileHandler(savedTasks);
                newFile.writeToFile(tasks);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
