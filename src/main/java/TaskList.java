import java.util.ArrayList;

/**
 * Represents the list of task Lisa manages.
 * This class contains methods to add, delete, mark and find tasks in the list.
 */
public class TaskList {
    protected ArrayList<Task> tasks = new ArrayList<>();
    protected int size;

    /**
     * Constructor for a TaskList object and initialises the list by transferring
     * saved data from storage.
     *
     * @param storage The storage object to transfer data from.
     */
    public TaskList(Storage storage) {
        storage.transferSavedData(tasks);
        size = tasks.size();
    }

    /**
     * Executes a command based on the user input.
     *
     * @param command An array of strings representing the user input.
     * @throws ArrayIndexOutOfBoundsException If there are insufficient arguments for
     * the command.
     */
    public void execute(String[] command) throws ArrayIndexOutOfBoundsException {
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

        case "find":
            findTask(command[1]);
            break;

        case "":
            Ui.printEmptyCommandError();
            break;

        default:
            Ui.printError();
            break;

        }
    }

    /**
     * Adds a new todo task to the task list.
     *
     * @param line The description of the new task.
     */
    public void addTask(String line) {
        Task newTask = new Task(line, false);
        tasks.add(newTask);
        Ui.printTask(newTask, tasks.size());
    }

    /**
     * Adds a new deadline task to the task list.
     *
     * @param word The String containing the description and date of the deadline task.
     * @throws ArrayIndexOutOfBoundsException If the command format is incorrect or there are
     * insufficient arguments.
     */
    public void addDeadline(String word) throws ArrayIndexOutOfBoundsException {
        String[] description = Parser.parseContent(word);
        String[] date = Parser.parseCommand(description[1]);
        if (description[0].isEmpty() || date[1].isEmpty()) {
            Ui.printDescriptionError("deadline");
        } else {
            Deadline newDeadline = new Deadline(description[0], date[1], false);
            tasks.add(newDeadline);
            Ui.printTask(newDeadline, tasks.size());
        }
    }

    /**
     * Adds a new event task to the task list.
     *
     * @param word The string containing the description and the date of the event.
     * @throws ArrayIndexOutOfBoundsException If the command format is incorrect or there are
     * insufficient arguments.
     */
    public void addEvent(String word) throws ArrayIndexOutOfBoundsException {
        String[] description = Parser.parseContent(word);
        String[] date = Parser.parseContent(description[1]);
        String[] from = Parser.parseCommand(date[0]);
        String[] to = Parser.parseCommand(date[1]);
        if (description[0].isEmpty() || from[1].isEmpty() || to[1].isEmpty()) {
            Ui.printDescriptionError("event");
        } else {
            Event newEvent = new Event(description[0], from[1], to[1], false);
            tasks.add(newEvent);
            Ui.printTask(newEvent, tasks.size());
        }
    }

    /**
     * Deletes a task from the task list.
     *
     * @param word The command description that contains the task index.
     */
    public void deleteTask(String word) {
        try {
            int taskIndex = Parser.parseIndex(word);
            String task = tasks.get(taskIndex).toString(); // hold name of task to be deleted
            tasks.remove(taskIndex);
            Ui.printDeleteTask(task, tasks.size());
        } catch (IndexOutOfBoundsException e) {
            Ui.printOutOfBoundsError();
        } catch (NumberFormatException e) {
            Ui.printNumberError();
        }
    }


    /**
     * Marks or unmarks a task as completed.
     *
     * @param word The command description that contains the task index.
     * @param mark The status of the mark as done (true) or undone (false).
     */
    public void markTask(String word, boolean mark) {
        try {
            int taskIndex = Parser.parseIndex(word);
            if (mark == tasks.get(taskIndex).isTaskDone()) {
                Ui.printTaskDone(mark);
            } else {
                tasks.get(taskIndex).markTask();
                Ui.printMarkTask(mark, taskIndex, tasks);
            }
        } catch (IndexOutOfBoundsException e) {
            Ui.printOutOfBoundsError();
        } catch (NumberFormatException e) {
            Ui.printNumberError();
        }
    }


    /**
     * Finds tasks in the list that contain the specified word.
     *
     * @param word The keyword to search for in the task description.
     */
    public void findTask(String word) {
        ArrayList<Task> tasksContainingWord = new ArrayList<>();
        for (Task task : tasks) {
            if (Parser.parseTask(word, task.getDescription())) {
                tasksContainingWord.add(task);
            }
        }
        Ui.printFoundTasks(tasksContainingWord);
    }


}
