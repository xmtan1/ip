import java.util.Scanner;

public class Lisa {
    private static final String LINE = "--------------------------------------------------------------";
    private static Task[] tasks = new Task[100];
    private static int taskIndex = 0;

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

            if (words[0].equals("list")) {
                printList();
            } else {
                try {

                    switch (words[0]) {
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

                    default:
                        System.out.println("Sorry, I don't know what that means...");
                        break;
                    }
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Please add a description");
                }
            }
            line = sc.nextLine();
        }
        System.out.println(LINE);
        System.out.println("Bye! See you next time :)");
    }

    public static void addTask(String line, int i) {
        Task newTask = new Task(line);
        tasks[i] = newTask;
        printTask(newTask);
        taskIndex++;
    }

    public static void addDeadline(String word, int i) {
        String[] input = word.split("/", 2);
        if (input.length < 2) {
            System.out.println("add in a deadline in this format: \n" + "[description] /[deadline]");
        } else {
            Deadline newDeadline = new Deadline(input[0], input[1]);
            tasks[i] = newDeadline;
            printTask(newDeadline);
            taskIndex++;
        }
    }

    public static void addEvent(String word, int i) {
        String[] input = word.split("/", 2);
        if (input.length < 2) {
            System.out.println("add in an event in this format: \n" + "[description] /[date]");
        } else {
            Event newEvent = new Event(input[0], input[1]);
            tasks[i] = newEvent;
            printTask(newEvent);
            taskIndex++;
        }
    }

    public static void printTask(Task task) {
        System.out.println(LINE);
        System.out.println("Got it! I've added this task: ");
        System.out.println("  " + task);
        System.out.println("You now have " + (taskIndex + 1) + " things in your list. Better get to them!");
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
        try {
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
        } catch (NumberFormatException e) {
            System.out.println("Please input a number!");
        }


    }

}
