public class Event extends Task{
    public String date;

    public Event(String description, String date) {
        super(description);
        this.date = date;
    }

    @Override public String toString() {
        return "[E][" + getStatusIcon() + "] " + description + "(" + date + ")";
    }
}
