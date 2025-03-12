import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * The FileHandler class provides methods to read and write tasks from/to a file.
 * It handles converting tasks into its appropriate type (such as 'String', 'Task',
 * 'Event', and 'Deadline') for storage in file or lists.
 *
 */
public class FileHandler {
    private File file;

    /**
     * Constructs a FileHandler object with the specified file.
     *
     * @param file the file to be used for storing list data.
     */
    public FileHandler(File file) {
        this.file = file;
    }

    // laitcanard05

    /**
     * Reads tasks from the file, converts them into the required type and adds them into a list of tasks.
     *
     * @param tasks list to which the tasks read from the file will be added to.
     * @throws IOException if there is an error reading from the file.
     */
    public void addTaskFromFile(ArrayList<Task> tasks) throws IOException {
        Scanner s = new Scanner(file);
        while (s.hasNextLine()) {
            String line = s.nextLine();
            String[] words = line.split("\\|");
            String taskType = words[0].trim();
            boolean isDone = words[1].trim().equals("X");
            String description = words[2].trim();
            Task newTask = switch (taskType) {
                case "T" -> new Task(description, isDone);
                case "D" -> {
                    String deadline = words[3].trim();
                    yield new Deadline(description, deadline, isDone);
                }
                case "E" -> {
                    String date = words[3].trim();
                    yield new Event(description, date, isDone);
                }
                default -> new Task(description, isDone); // add exception
            };
            tasks.add(newTask);
        }
    }

    /**
     * Writes a list of tasks to the file.
     *
     * @param tasks the list of tasks that needs to be written to the file.
     * @throws IOException if there is an error writing to file.
     */
    public void writeToFile(ArrayList<Task> tasks) throws IOException {
        FileWriter fw = new FileWriter(file);
        String content = getTaskListAsText(tasks);
        fw.write(content);
        fw.close();
    }

    /**
     * Converts the list of tasks into a string representation for storage in a file.
     *
     * @param tasks the list of tasks to be converted into text format.
     * @return a string representation of tasks for storage in file.
     */
    public String getTaskListAsText(ArrayList<Task> tasks) {
        String taskListText = "";
        for (Task task : tasks) {
            if (task instanceof Deadline) {
                taskListText += "D | " + task.getStatusIcon() + " | " +  task.getDescription() + " | " +
                              ((Deadline) task).getDeadline() + "\n";
            } else if (task instanceof Event) {
                taskListText += "E | " + task.getStatusIcon() + " | " + task.getDescription() + " | " +
                        ((Event) task).getDate() + "\n";
            } else {
                taskListText += "T | " + task.getStatusIcon() + " | " + task.getDescription() + "\n";
            }
        }
        return taskListText;
    }
}

