import java.util.ArrayList;

/**
 * Represents and edits the list of tasks according to user commands
 *
 */
public class TaskList {
    protected ArrayList<Task> tasks = new ArrayList<>();
    protected int size;


    public TaskList(Storage storage) {
        storage.transferSavedData(tasks);
        size = tasks.size();
    }

    public void execute(String[] command) {
        try {
            switch (command[0]) {
            case "mark":
                markTask(command[1], true);
                break;

            case "unmark":
                markTask(command[1], false);
                break;

            case "todo":
                addTask(command[1]);
                break;

            case "deadline":
                addDeadline(command[1]);
                break;

            case "event":
                addEvent(command[1]);
                break;

            case "delete":
                deleteTask(command[1]);
                break;

            case "list":
                Ui.printList(tasks);
                break;

            default:
                System.out.println("Sorry, I don't know what that means...");
                break;

            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Please add a description");
        }
    }

    public void addTask(String line) {
        Task newTask = new Task(line, false);
        tasks.add(newTask);
        Ui.printTask(newTask, tasks.size());
    }

    public void addDeadline(String word) {
        String[] input = Parser.parseContent(word);
        if (input.length < 2) {
            System.out.println("add in a deadline in this format: \n" + "[description] /[deadline]");
        } else {
            Deadline newDeadline = new Deadline(input[0], input[1], false);
            tasks.add(newDeadline);
            Ui.printTask(newDeadline, tasks.size());
        }
    }

    public void addEvent(String word) {
        String[] input = Parser.parseContent(word);
        if (input.length < 2) {
            System.out.println("add in an event in this format: \n" + "[description] /[date]");
        } else {
            Event newEvent = new Event(input[0], input[1], false);
            tasks.add(newEvent);
            Ui.printTask(newEvent, tasks.size());
        }
    }

    public void deleteTask(String word) {
        int taskIndex = Parser.parseIndex(word);
        String task = tasks.get(taskIndex).toString(); // hold name of task to be deleted
        tasks.remove(taskIndex);
        Ui.printDeleteTask(task, tasks.size());
    }


    public void markTask(String word, boolean mark) {
        try {
            int taskIndex = Parser.parseIndex(word);
            if (mark) {
                tasks.get(taskIndex).markAsDone();
            } else {
                tasks.get(taskIndex).markAsNotDone();
            }
            Ui.printMarkTask(mark, taskIndex);
        } catch (NumberFormatException e) {
            System.out.println("Please input a number!");
        }
    }


}
