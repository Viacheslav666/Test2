import java.time.LocalDate;

public class MonthTask extends Task{
    public MonthTask(String header, String description, Type type, TaskRepeatability taskRepeatability, LocalDate localDate) {
        super(header, description, type, taskRepeatability, localDate);
    }

    public MonthTask() {
    }

    @Override
    public boolean appearshIn(LocalDate date) {
        if(date.getDayOfMonth() == getTimeDoneTask().getDayOfMonth()){
            return true;
        }else {
        return false;}
    }
}
