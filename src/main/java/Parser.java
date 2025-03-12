/**
 * The Parser class provides methods to parse and extract information from a string.
 * It contains methods to split input strings into individual components.
 */
public class Parser {

    /**
     * Parses and splits the input string into two parts: the command and the description
     * The string is split by a space.
     *
     * @param input the input string to be parsed.
     * @return an array of strings where the first element is the command, and the second
     * element is the description.
     */
    public static String[] parseCommand(String input) {
        return input.split(" ", 2);
    }

    /**
     * Parses and splits the input string after the command into two parts: the description
     * and the date.
     * The string is split by the '/' character.
     *
     * @param input the input string to be parsed.
     * @return an array of strings where the first element is the description, and the second
     * element is the date.
     * @throws ArrayIndexOutOfBoundsException if input string does not contain
     */
    public static String[] parseContent(String input) {
        return input.split("/", 2);
    }

    /**
     * Parses the input string to extract an integer index.
     * The parsed value is returned with a 1-based index adjusted to a 0-based index.
     *
     * @param input the input string expected to contain an integer
     * @return the 0-based index parsed from the input string
     */
    public static int parseIndex(String input) {
        return Integer.parseInt(input) - 1;
    }

    public static boolean parseTask(String input, String task) {
        boolean containsInput = false;
        char[] charInput = input.toCharArray();
        char[] charTask = task.toCharArray();
        int i = 0;
        int j = 0;
        while (i < charTask.length) {
            if (charTask[i] == charInput[j]) {
                if (j == charInput.length - 1) {
                    containsInput = true;
                    break;
                }
                j++;
            }
            i++;
        }
        return containsInput;
    }

}
