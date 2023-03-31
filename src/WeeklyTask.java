import java.time.LocalDate;

public class WeeklyTask extends Task {
    public WeeklyTask(String header, String description, Type type, TaskRepeatability taskRepeatability, LocalDate localDate) {
        super(header, description, type, taskRepeatability, localDate);
    }

    public WeeklyTask() {
    }

    @Override
    public boolean appearshIn(LocalDate date) {
        if(date.plusWeeks(1) == getTimeDoneTask().plusWeeks(1)){
            return true;
        }else {
            return false;}
    }
}
