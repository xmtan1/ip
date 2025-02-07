public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description){
        this.description = description;
        this.isDone = false;
    }

    public boolean isDone() {
        return isDone;
    }

    public void markAsDone() {
        isDone = true;
    }

    public void markAsNotDone() {
        isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " ");
    }

    public String toString(){
        return "[T][" + getStatusIcon() + "] " + description;
    }
}
