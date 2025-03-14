/**
 * The Parser class provides methods to parse and extract information from a string.
 * It contains methods to split input strings into individual components.
 */
public class Parser {

    /**
     * Parses and splits the input string into two parts: the command and the description.
     * The string is split by a space.
     *
     * @param input the input string to be parsed.
     * @return an array of strings where the first element is the command, and the second
     * element is the description.
     */
    public static String[] parseCommand(String input) {
        String[] words = input.trim().split(" ", 2);
        return removeWhitespace(words);
    }

    /**
     * Parses and splits the input string after the command into two parts: the description
     * and the date.
     * The string is split by the '/' character.
     *
     * @param input the input string to be parsed.
     * @return an array of strings where the first element is the description, and the second
     * element is the date.
     */
    public static String[] parseContent(String input) {
        String[] words = input.trim().split("/", 2);
        return removeWhitespace(words);
    }

    /**
     * Parses and removes whitespace before and after each string in the array of strings.
     *
     * @param input array of strings to remove whitespace from
     * @return an array of strings with their whitespace removed
     */
    public static String[] removeWhitespace(String[] input) {
        for (int i = 0; i < input.length; i++) {
            input[i] = input[i].trim();
        }
        return input;
    }

    /**
     * Parses the input string to extract an integer index.
     * The parsed value is returned with a 1-based index adjusted to a 0-based index.
     *
     * @param input the input string expected to contain an integer
     * @return the 0-based index parsed from the input string
     */
    public static int parseIndex(String input) throws NumberFormatException {
        input = input.trim();
        return Integer.parseInt(input) - 1;
    }

    /**
     * Checks if the given task contains the specified input within its task description.
     * This method compares the characters of the input string to the task string and
     * determines whether the input appears as a sequence within the task. Returns true if
     * input is fully matched in order, and false otherwise.
     *
     * @param input The string to search for within the task.
     * @param task  The string representing the task to be searched.
     * @return true if the input appears as a subsequence within the task, false otherwise.
     */
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
            } else {
                j = 0;
            }
            i++;
        }
        return containsInput;
    }

}
