import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.ArrayList;


public class FileHandler {
    private File file;

    public FileHandler(File file) {
        this.file = file;
    }

    // laitcanard05
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

    public void writeToFile(ArrayList<Task> tasks) throws IOException {
        FileWriter fw = new FileWriter(file);
        String content = getTaskListAsText(tasks);
        fw.write(content);
        fw.close();
    }

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

