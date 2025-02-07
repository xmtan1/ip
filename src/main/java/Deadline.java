public class Deadline extends Task {
    public String deadline;

    public Deadline(String description, String deadline) {
        super(description);
        this.deadline = deadline;
    }

    public String getDeadline() {
        return deadline;
    }

    @Override public String toString() {
        return "[D][" + getStatusIcon() + "] " + description + "(" + deadline + ")";
    }
}
