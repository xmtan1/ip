import java.util.Scanner;

public class Lisa {
    private static Task[] tasks = new Task[100];
    private static int taskNumber = 0;


    public static void main(String[] args) {
        String name = "Lisa";
        System.out.println("Hiya! I'm " + name);
        System.out.println("What can I do for you?");

        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        int i = 0;
        while (!line.equals("bye")) {

            String[] words = line.split(" ");
            switch (words[0]) {
            case "list":
                printList();
                break;

            case "mark":
                markTask(words[1], true);
                break;

            case "unmark":
                markTask(words[1], false);
                break;

            default:
                addTask(line, i);
                i++;
                taskNumber++;
            }
            line = sc.nextLine();
        }

        System.out.println("Bye! See you next time :)");
    }

    public static void addTask(String line, int i) {
        Task newTask = new Task(line);
        tasks[i] = newTask;
        System.out.println("added: " + line);
    }

    public static void printList() {
        int i = 0;
        if (tasks[0] == null) {
            System.out.println("There are no tasks to complete, yay!");
        } else {
        System.out.println("Here's your list of tasks:");
        while (tasks[i] != null) {
            System.out.println(i + 1 + ".[" + tasks[i].getStatusIcon() + "] " + tasks[i].description);
            i++;
        }
        }
    }

    public static void markTask(String word, boolean mark) {
        int taskIndex = Integer.parseInt(word) - 1;
        if (tasks[taskIndex] == null) {
            System.out.println("That task doesn't exist!");
        } else {
            if (mark) {
                tasks[taskIndex].markAsDone();
                System.out.println("Okay, task " + (taskIndex + 1) + " has been marked. :)");
            } else {
                tasks[taskIndex].markAsNotDone();
                System.out.println("Okay, task " + (taskIndex + 1) + " has been unmarked!");
            }
            printList();
        }
    }

}
