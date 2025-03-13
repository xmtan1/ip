import java.util.ArrayList;
import java.util.Scanner;

/**
 * The Ui class handles all user interactions by reading user input and displaying
 * messages. It provides methods to print messages for task management, errors, and
 * general user instructions.
 */
public class Ui {

    /**
     * Prints a horizontal line to for visual separation.
     */
    public static void printLine() {
        System.out.println("--------------------------------------------------------------");
    }

    /**
     * Prints a welcome message to the user when the program starts.
     */
    public void welcomeMessage() {
        System.out.println("Hiya! I'm Lisa");
        System.out.println("What's going on?");
        printLine();
    }

    /**
     * Prints a farewell message to the user when the program ends.
     */
    public void farewellMessage() {
        printLine();
        System.out.println("Bye! See you next time :)");
        printLine();
    }

    /**
     * Reads a line of input from the user via the command line.
     *
     * @return The user's input as a string.
     */
    public String readInput() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    /**
     * Prints a message confirming a todo task has been added.
     *
     * @param task The task that was added.
     * @param size The size of the current list of tasks.
     */
    public static void printTask(Task task, int size) {
        printLine();
        System.out.println("Got it! I've added this task: ");
        System.out.println("  " + task);
        System.out.println("You now have " + size + " things in your list. Better get to them!");
        printLine();
    }

    /**
     * Prints a message confirming a task has been deleted.
     *
     * @param task The task that was deleted.
     * @param size The number of tasks remaining in the list.
     */
    public static void printDeleteTask(String task, int size) {
        printLine();
        System.out.println("Okay! I've removed this task:");
        System.out.println(" " + task);
        System.out.println("You now have " + size + " things in your list!");
        printLine();
    }

    /**
     * Prints a message indicating a whether a task is marked or unmarked.
     *
     * @param mark true if the task is to be marked as done, false if otherwise.
     * @param taskIndex The index of the task that was marked.
     * @param tasks The current list of tasks to display after marking.
     */
    public static void printMarkTask(boolean mark, int taskIndex, ArrayList<Task> tasks) {
        printLine();
        if (mark) {
            System.out.println("Okay, task " + (taskIndex + 1) + " has been marked. :)");
        } else {
            System.out.println("Okay, task " + (taskIndex + 1) + " has been unmarked!");
        }
        printList(tasks);
        printLine();
    }

    /**
     * Prints a message indicating whether the task was already marked or unmarked.
     *
     * @param isDone true if the task is to be marked as done, false if otherwise.
     */
    public static void printTaskDone(boolean isDone) {
        printLine();
        if (isDone) {
            System.out.println("Task already marked as done!");
        } else {
            System.out.println("Task already marked as undone!");
        }
        printLine();
    }

    /**
     * Prints the current list of tasks.
     *
     * @param tasks The current list of tasks to display.
     */
    public static void printList(ArrayList<Task> tasks) {
        int i = 0;
        printLine();
        if (tasks.isEmpty()) {
            System.out.println("There are no tasks to complete, yay!");
        } else {
            System.out.println("Here's your list of tasks:");
            while (i < tasks.size()) {
                System.out.println(i + 1 + "." + tasks.get(i));
                i++;
            }
        }
        printLine();
    }

    /**
     * Prints the list of tasks that match the search.
     *
     * @param tasks The list of tasks that match the search
     */
    public static void printFoundTasks (ArrayList<Task> tasks) {
        int i = 0;
        printLine();
        if (tasks.isEmpty()) {
            System.out.println("Sorry, there are no tasks containing that :(");
        } else {
            System.out.println("Here's the list of matching tasks:");
            while (i < tasks.size()) {
                System.out.println(i + 1 + "." + tasks.get(i));
                i++;
            }
        }
        printLine();
    }

    /**
     * Prints a generic error message when the user's command is unrecognised.
     */
    public static void printError() {
        printLine();
        System.out.println("Sorry, I don't know what that means...");
        printLine();
    }

    /**
     * Prints an error message when there is a number format exception.
     */
    public static void printNumberError() {
        printLine();
        System.out.println("Please input a number instead of a word!");
        printLine();
    }

    /**
     * Prints an error message when there is an out-of-bounds error.
     */
    public static void printOutOfBoundsError() {
        printLine();
        System.out.println("Invalid number, task does not exist!");
        printLine();
    }


    /**
     * Prints an instruction message on expected format on inputs depending
     * on the command.
     *
     * @param words An array of words representing the command entered by the user.
     */
    public static void printDescriptionError(String[] words) {
        printLine();

            String command = words[0];
            switch (command) {
            case "deadline":
                System.out.println("add in a deadline in this format: \n" + "deadline [description] /by [deadline]");
                break;
            case "event":
                System.out.println("add in a event in this format: \n" + "event [description] /from [date/time] /" +
                        "to [date/time]");
                break;
            case "mark", "unmark", "delete":
                System.out.println("Please input the index of the task");
                break;
            case "find":
                System.out.println("find a word in this format: \n" + "find [word]");
                break;
            default:
                System.out.println("add in a todo in this format: \n" + "todo [description]");
                break;
            }
        printLine();
    }

    /**
     * Prints an error message when the user inputs an empty command.
     */
    public static void printEmptyCommandError() {
        printLine();
        System.out.println("Please input a valid command");
        printLine();
    }


}
