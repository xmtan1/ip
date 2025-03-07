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
    public static void printMarkTask(boolean mark, int taskIndex) {
        printLine();
        if (mark) {
            System.out.println("Okay, task " + (taskIndex + 1) + " has been marked. :)");
        } else {
            System.out.println("Okay, task " + (taskIndex + 1) + " has been unmarked!");
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
}
