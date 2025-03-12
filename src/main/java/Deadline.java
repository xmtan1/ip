public class Deadline extends Task {
    public String deadline;

    public Deadline(String description, String deadline, boolean isDone) {
        super(description, isDone);
        this.deadline = deadline;
    }

    public String getDeadline() {
        return deadline;
    }

    @Override public String toString() {
        return "[D][" + getStatusIcon() + "] " + description + " (" + deadline + ")";
    }
}
