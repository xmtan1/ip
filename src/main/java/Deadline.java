/**
 * Represents a Deadline task, which has a description and date of event.
 * This class inherits from the Task class and adds functionality to store and retrieve
 * the deadline date.
 * This class also overrides the toString() method to provide a different string representation.
 */
public class Deadline extends Task {
    public String deadline;

    /**
     * Constructs a Deadline object with given description, date and completion status.
     *
     * @param description the description of the task.
     * @param deadline the deadline of the task.
     * @param isDone the completion status of the task.
     */
    public Deadline(String description, String deadline, boolean isDone) {
        super(description, isDone);
        this.deadline = deadline;
    }

    /**
     * Retrieves the deadline of the task.
     *
     * @return the deadline of the task as a string.
     */
    public String getDeadline() {
        return deadline;
    }

    /**
     * Returns a string representation of the deadline task, including its status, description
     * and deadline.
     * The format is: "[D][status] description (date)"
     * where status is the task's status icon.
     *
     * @return a string representation of the deadline task.
     */
    @Override public String toString() {
        return "[D][" + getStatusIcon() + "] " + description + "(" + deadline + ")";
    }
}
