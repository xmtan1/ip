/**
 * Represents a task with a description and its completion status.
 * A <code>Task</code> object contains information about a task's description and
 * whether it is marked as done.
 * It provides methods to check and update a task's status.
 */
public class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Constructor to create the Task object with a description and completion status
     *
     * @param description description of the task.
     * @param isDone      completion status of the task.
     */
    public Task(String description, boolean isDone) {
        this.description = description;
        this.isDone = isDone;
    }

    /**
     * Returns the description of the task.
     *
     * @return description of the task.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the completion status of the task.
     *
     * @return true if task is done, false otherwise.
     */
    public boolean isTaskDone() {
        return isDone;
    }

    /**
     * Marks the task as done or undone depending on the current
     * status of completion.
     * This method sets the task's status to completed if previously not,
     * and vice versa.
     */
    public void markTask() {
        isDone = !isDone;
    }

    /**
     * Returns the status icon of the task as a string.
     *
     * @return "X" if task is done, " " otherwise.
     */
    public String getStatusIcon() {
        return (isDone ? "X" : " ");
    }

    /**
     * Returns string representation of the task for user to view.
     * The format is: "[T][status] description"
     * where status is the task's status icon.
     *
     * @return a string containing its description and information on
     * the type of task and its completion status.
     */
    public String toString() {
        return "[T][" + getStatusIcon() + "] " + description;
    }
}
