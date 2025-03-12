import java.util.ArrayList;
import java.util.Scanner;

public class Ui {

    public static void printLine() {
        System.out.println("--------------------------------------------------------------");
    }

    public void welcomeMessage() {
        System.out.println("Hiya! I'm Lisa");
        System.out.println("What's going on?");
        printLine();
    }

    public void farewellMessage() {
        printLine();
        System.out.println("Bye! See you next time :)");
        printLine();
    }

    public String readInput() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static void printTask(Task task, int size) {
        printLine();
        System.out.println("Got it! I've added this task: ");
        System.out.println("  " + task);
        System.out.println("You now have " + size + " things in your list. Better get to them!");
        printLine();
    }

    public static void printDeleteTask(String task, int size) {
        printLine();
        System.out.println("Okay! I've removed this task:");
        System.out.println(" " + task);
        System.out.println("You now have " + size + " things in your list!");
        printLine();
    }

    // rmb to print for task does not exist
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

    public static void printTaskDone(boolean isDone) {
        printLine();
        if (isDone) {
            System.out.println("Task already marked as done!");
        } else {
            System.out.println("Task already marked as undone!");
        }
        printLine();
    }

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

    public static void printError() {
        printLine();
        System.out.println("Sorry, I don't know what that means...");
        printLine();
    }

    public static void printNumberError() {
        printLine();
        System.out.println("Please input a number instead of a word!");
        printLine();
    }

    public static void printOutOfBoundsError() {
        printLine();
        System.out.println("Invalid number, task does not exist!");
        printLine();
    }


    public static void printDescriptionError(String[] words) {
        printLine();

            String command = words[0];
            switch (command) {
            case "deadline":
                System.out.println("add in a deadline in this format: \n" + "deadline [description] /by [deadline]");
                break;
            case "event":
                System.out.println("add in a event in this format: \n" + "event [description] /from [date/time] to [date/time]");
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

    public static void printEmptyCommandError() {
        printLine();
        System.out.println("Please input a valid command");
        printLine();
    }


}
