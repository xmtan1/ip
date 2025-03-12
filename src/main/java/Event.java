public class Event extends Task{
    public String date;

    public Event(String description, String date, boolean isDone) {
        super(description, isDone);
        this.date = date;
    }

    public String getDate() {
        return date;
    }


    @Override public String toString() {
        return "[E][" + getStatusIcon() + "] " + description + " (on: " + date + ")";
    }
}
