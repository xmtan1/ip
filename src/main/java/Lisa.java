import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

public class Lisa {
    private static final String LINE = "--------------------------------------------------------------";
    private static ArrayList<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {
        String name = "Lisa";
        System.out.println("Hiya! I'm " + name);
        System.out.println("What's going on?");
        System.out.println(LINE);

        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        transferSavedData();

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
                        addTask(words[1]);
                        break;

                    case "deadline":
                        addDeadline(words[1]);
                        break;

                    case "event":
                        addEvent(words[1]);
                        break;

                    case "delete":
                        deleteTask(words[1]);
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
        saveTasks();
        System.out.println(LINE);
        System.out.println("Bye! See you next time :)");
    }

    public static void addTask(String line) {
        Task newTask = new Task(line, false);
        tasks.add(newTask);
        printTask(newTask);
    }

    public static void addDeadline(String word) {
        String[] input = word.split("/", 2);
        if (input.length < 2) {
            System.out.println("add in a deadline in this format: \n" + "[description] /[deadline]");
        } else {
            Deadline newDeadline = new Deadline(input[0], input[1], false);
            tasks.add(newDeadline);
            printTask(newDeadline);
        }
    }

    public static void addEvent(String word) {
        String[] input = word.split("/", 2);
        if (input.length < 2) {
            System.out.println("add in an event in this format: \n" + "[description] /[date]");
        } else {
            Event newEvent = new Event(input[0], input[1], false);
            tasks.add(newEvent);
            printTask(newEvent);
        }
    }

    public static void deleteTask(String word) { // added delete
        int taskIndex = Integer.parseInt(word) - 1;
        System.out.println(LINE);
        System.out.println("Okay! I've removed this task:");
        System.out.println(" " + tasks.get(taskIndex).toString());
        tasks.remove(taskIndex);
        System.out.println("You now have " + tasks.size() + " things in your list!");
        System.out.println(LINE);
    }

    public static void printTask(Task task) {
        System.out.println(LINE);
        System.out.println("Got it! I've added this task: ");
        System.out.println("  " + task);
        System.out.println("You now have " + tasks.size() + " things in your list. Better get to them!");
        System.out.println(LINE);
    }

    public static void printList() {
        int i = 0;
        if (tasks.isEmpty()) {
            System.out.println("There are no tasks to complete, yay!");
        } else {
            System.out.println(LINE);
            System.out.println("Here's your list of tasks:");
            while (i < tasks.size()) {
                System.out.println(i + 1 + "." + tasks.get(i));
                i++;
            }
            System.out.println(LINE);
        }
    }

    public static void markTask(String word, boolean mark) {
        try {
            int taskIndex = Integer.parseInt(word) - 1;
            if (tasks.get(taskIndex) == null) {
                System.out.println(LINE);
                System.out.println("Oops, that task doesn't exist!");
                System.out.println(LINE);
            } else {
                if (mark) {
                    tasks.get(taskIndex).markAsDone();
                    System.out.println(LINE);
                    System.out.println("Okay, task " + (taskIndex + 1) + " has been marked. :)");
                    System.out.println(LINE);
                } else {
                    tasks.get(taskIndex).markAsNotDone();
                    System.out.println(LINE);
                    System.out.println("Okay, task " + (taskIndex + 1) + " has been unmarked!");
                    System.out.println(LINE);
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Please input a number!");
        }
    }

    public static void transferSavedData() {
        File savedTasks = new File("data/tasks.txt");
        try {
            if (savedTasks.exists()) {
                FileHandler newFile = new FileHandler(savedTasks);
                newFile.addTaskFromFile(tasks);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveTasks() {
        File savedTasks = new File("data/tasks.txt");
        try {
            if(savedTasks.exists()) {
                FileHandler newFile = new FileHandler(savedTasks);
                newFile.writeToFile(tasks);
            } else {
                Files.createDirectory(Paths.get("./data"));
                Files.createFile(Paths.get("./data/tasks.txt"));
                FileHandler newFile = new FileHandler(savedTasks);
                newFile.writeToFile(tasks);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
