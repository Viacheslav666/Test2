import java.time.LocalDate;

public class DailyTask extends Task {
    public DailyTask(String header, String description, Type type, TaskRepeatability taskRepeatability, LocalDate localDate) {
        super(header, description, type, taskRepeatability, localDate);
    }

    public DailyTask() {
    }

    @Override
    public boolean appearshIn(LocalDate date) {
        if (date.plusDays(1) == getTimeDoneTask().plusDays(1)) {
            return true;
        } else {
            return false;
        }
    }
}