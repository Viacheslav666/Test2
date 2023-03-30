public class TaskNotFoundException extends Exception{
    Task task;

    public Task getTask() {
        return task;
    }
    public TaskNotFoundException(String message) {
        super(message);
    }
}
