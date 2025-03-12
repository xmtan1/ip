/**
 * Represents an Event task, which has a description and date of event.
 * This class inherits from the Task class and adds functionality to store and retrieve
 * the event date.
 * This class also overrides the toString() method to provide a different string representation.
 */

public class Event extends Task{
    public String date;

    /**
     * Constructs an Event object with given description, date and completion status.
     *
     * @param description the description of the event.
     * @param date the date of the event.
     * @param isDone the completion status of the event.
     */
    public Event(String description, String date, boolean isDone) {
        super(description, isDone);
        this.date = date;
    }

    /**
     * Retrieves the date of the event.
     *
     * @return the date of the event as a string.
     */
    public String getDate() {
        return date;
    }

    /**
     * Returns a string representation of the event, including its status, description
     * and date.
     * The format is: "[E][status] description (on: date)"
     * where status is the task's status icon.
     *
     * @return a string representation of the event.
     */
    @Override public String toString() {
        return "[E][" + getStatusIcon() + "] " + description + "(on: " + date + ")";
    }
}
