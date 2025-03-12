public class Parser {

    public static String[] parseCommand(String input) {
        return input.split(" ", 2);
    }

    public static String[] parseContent(String input) {
        return input.split("/", 2);
    }

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
