import java.util.Scanner;

public class Lisa {
    public static void main(String[] args) {
        String name = "Lisa";
        System.out.println("Hiya! I'm " + name);
        System.out.println("What can I do for you?");
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        while (!word.equals("bye")) {
            System.out.println(word);
            word = sc.nextLine();
        }
        System.out.println("Bye! See ya next time :)");
    }
}
