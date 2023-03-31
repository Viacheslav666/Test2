import java.time.LocalDate;

public class YearTask extends Task {
    public YearTask(String header, String description, Type type, TaskRepeatability taskRepeatability, LocalDate localDate) {
        super(header, description, type, taskRepeatability, localDate);
    }

    public YearTask() {
    }

    @Override
    public boolean appearshIn(LocalDate date) {
        if (date.getDayOfYear()== getTimeDoneTask().getDayOfYear()) {
            return true;
        } else {
            return false;
        }
    }
}