import java.util.Scanner;

public class Lisa {
    public static void main(String[] args) {
        String name = "Lisa";
        System.out.println("Hiya! I'm " + name);
        System.out.println("What can I do for you?");

        String[] requests = new String[100];
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();

        int i = 0;
        while (!word.equals("bye")) {
            if (word.equals("list")) {
                printList(requests);
                word = sc.nextLine();
            } else {
                requests[i] = word;
                System.out.println("added: " + word);
                word = sc.nextLine();
                i++;
            }
        }
        System.out.println("Bye! See ya next time :)");
    }

    public static void printList(String[] requests) {
        int i = 0;
        while (requests[i] != null) {
            System.out.println(i+1 + ". " + requests[i]);
            i++;
        }
    }
}
