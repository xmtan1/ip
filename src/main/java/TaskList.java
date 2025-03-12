import java.util.ArrayList;

/**
 * Represents and edits the list of tasks according to user commands
 */
public class TaskList {
    protected ArrayList<Task> tasks = new ArrayList<>();
    protected int size;


    public TaskList(Storage storage) {
        storage.transferSavedData(tasks);
        size = tasks.size();
    }

    public void execute(String[] command) throws ArrayIndexOutOfBoundsException {
        switch (command[0]) {
        case "mark":
            markTask(command[1], true, tasks);
            break;

        case "unmark":
            markTask(command[1], false, tasks);
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

    public void addTask(String line) {
        Task newTask = new Task(line, false);
        tasks.add(newTask);
        Ui.printTask(newTask, tasks.size());
    }

    public void addDeadline(String word) {
        String[] input = Parser.parseContent(word);
        Deadline newDeadline = new Deadline(input[0], input[1], false);
        tasks.add(newDeadline);
        Ui.printTask(newDeadline, tasks.size());

    }

    public void addEvent(String word) {
        String[] input = Parser.parseContent(word);
        Event newEvent = new Event(input[0], input[1], false);
        tasks.add(newEvent);
        Ui.printTask(newEvent, tasks.size());
    }

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


    public void markTask(String word, boolean mark, ArrayList<Task> tasks) {
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


    public void findTask(String word) {
        ArrayList<Task> tasksContainingWord = new ArrayList<>();
        for (Task task : tasks) {
            if (Parser.parseTask(word, task.toString())) {
                tasksContainingWord.add(task);
            }
        }
        Ui.printFoundTasks(tasksContainingWord);
    }


}
