public class Parser {

    public static String[] parseCommand(String input) {
        return input.split(" ", 2);
    }

    public static String[] parseContent(String input) {
        String[] words = input.split(" ", 2);
        return words[1].split("/", 2);
    }

    public static int parseIndex(String input) {
        return Integer.parseInt(input) - 1;
    }

}
