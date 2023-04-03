import java.time.LocalDate;

public class OneTimeTask extends Task{

    public OneTimeTask(String header, String description, Type type, TaskRepeatability taskRepeatability, LocalDate localDate) {
        super(header, description, type, taskRepeatability, localDate);
    }

    public OneTimeTask() {
    }

    @Override
    public boolean appearshIn(LocalDate date) {
        return true;
    }
}
