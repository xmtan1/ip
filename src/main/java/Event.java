/**
 * Represents an Event task, which has a description and date of event.
 * This class inherits from the Task class and adds functionality to store and retrieve
 * the event date.
 * This class also overrides the toString() method to provide a different string representation.
 */

public class Event extends Task {
    public String from;
    public String to;

    /**
     * Constructs an Event object with given description, date and completion status.
     *
     * @param description the description of the event.
     * @param from        the time of start of event
     * @param to          the time of end of event
     * @param isDone      the completion status of the event.
     */
    public Event(String description, String from, String to, boolean isDone) {
        super(description, isDone);
        this.from = from;
        this.to = to;
    }

    /**
     * Retrieves the date of the event.
     *
     * @return the date of the event as a string.
     */
    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    /**
     * Returns a string representation of the event, including its status, description
     * and date.
     * The format is: "[E][status] description (from: from to: to)"
     * where status is the task's status icon.
     *
     * @return a string representation of the event.
     */
    @Override
    public String toString() {
        return "[E][" + getStatusIcon() + "] " + description + " (from: " + from + " to: " + to + ")";
    }
}
