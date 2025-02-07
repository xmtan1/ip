import java.util.Scanner;

public class Lisa {
    private static final String LINE = "--------------------------------------------------------------";
    private static Task[] tasks = new Task[100];

    public static void main(String[] args) {
        String name = "Lisa";
        System.out.println("Hiya! I'm " + name);
        System.out.println("What can I do for you?");
        System.out.println(LINE);

        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        int i = 0;
        while (!line.equals("bye")) {

            String[] words = line.split(" ", 2);
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

            case "todo":
                addTask(words[1], i);
                i++;
                break;

            case "deadline":
                addDeadline(words[1], i);
                i++;
                break;

            case "event":
                addEvent(words[1], i);
                i++;
                break;
            }
            line = sc.nextLine();
        }
        System.out.println(LINE);
        System.out.println("Bye! See you next time :)");
    }

    public static void addTask(String line, int i) {
        Task newTask = new Task(line);
        tasks[i] = newTask;
        System.out.println(LINE);
        System.out.println("Got it! I've added this task: ");
        System.out.println("  " + newTask);
        System.out.println("You now have " + (i+1) + " things in your list. Better get to them!");
        System.out.println(LINE);
    }

    public static void addDeadline(String word, int i) {
        String[] input = word.split("/", 2);
        Deadline newDeadline = new Deadline(input[0], input[1]);
        tasks[i] = newDeadline;
        System.out.println(LINE);
        System.out.println("Got it! I've added this task: ");
        System.out.println("  " + newDeadline);
        System.out.println("You now have " + (i+1) + " things in your list. Better get to them!");
        System.out.println(LINE);
    }

    public static void addEvent(String word, int i) {
        String[] input = word.split("/", 2);
        Event newEvent = new Event(input[0], input[1]);
        tasks[i] = newEvent;
        System.out.println(LINE);
        System.out.println("Got it! I've added this task: ");
        System.out.println("  " + newEvent);
        System.out.println("You now have " + (i+1) + " things in your list. Better get to them!");
        System.out.println(LINE);
    }

    public static void printList() {
        int i = 0;
        if (tasks[0] == null) {
            System.out.println("There are no tasks to complete, yay!");
        } else {
            System.out.println(LINE);
            System.out.println("Here's your list of tasks:");
            while (tasks[i] != null) {
                System.out.println(i + 1 + "." + tasks[i].toString());
                i++;
            }
            System.out.println(LINE);
        }
    }

    public static void markTask(String word, boolean mark) {
        int taskIndex = Integer.parseInt(word) - 1;
        if (tasks[taskIndex] == null) {
            System.out.println(LINE);
            System.out.println("That task doesn't exist!");
            System.out.println(LINE);
        } else {
            if (mark) {
                tasks[taskIndex].markAsDone();
                System.out.println(LINE);
                System.out.println("Okay, task " + (taskIndex + 1) + " has been marked. :)");
                System.out.println(LINE);
            } else {
                tasks[taskIndex].markAsNotDone();
                System.out.println(LINE);
                System.out.println("Okay, task " + (taskIndex + 1) + " has been unmarked!");
                System.out.println(LINE);
            }
        }
    }



}
