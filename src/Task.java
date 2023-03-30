import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;

public class Task {
    private static int idGenerator = 0;
    private static Calendar timeTask = new GregorianCalendar();
    private  String header;
    private  String description;
    private  Type type;
    private int id;
    private taskRepeatability taskRepeatability;
    public Task(String header, String description, Type type, taskRepeatability taskRepeatability) {
        this.header = header;
        this.description = description;
        this.type = type;
        this.taskRepeatability = taskRepeatability;
        this.timeTask = Calendar.getInstance();
        this.id = idGenerator++;

    }

    public Task() {
    }

    public enum taskRepeatability {
        ONE_TAME_TASK,
        YEARLY_TASK,
        DAILY_TASK,
        MONTH_TASK,
        WEEKLY_TASK;

    }

    public void deadLineTask() {
        switch (taskRepeatability) {
            case DAILY_TASK -> {
                timeTask.add(Calendar.DATE, 1);
                System.out.println("Данную задачу нужно сделать до: " + timeTask.getTime());
            }
            case MONTH_TASK -> {
                timeTask.add(Calendar.MARCH, 1);
                System.out.println("Данную задачу нужно сделать до: " + timeTask.getTime());
            }
            case ONE_TAME_TASK -> System.out.println("Данную задачу нужно сделать до: " + timeTask.getTime());
            case WEEKLY_TASK -> {
                timeTask.add(Calendar.DAY_OF_WEEK, 1);
                System.out.println("Данную задачу нужно сделать до: " + timeTask.getTime());
            }
            case YEARLY_TASK -> {
                timeTask.add(Calendar.YEAR, 1);
                System.out.println("Данную задачу нужно сделать до: " + timeTask.getTime());
            }
        }


    }

    @Override
    public String toString() {
        return

                " Оглавление : " + header + '\'' +
                        " Описание: " + description + '\'' +
                        " Тип: " + getType() +
                        ", id= " + getId() +
                        "Время " + getTimeTask()
                ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return idGenerator == task.idGenerator && id == task.id && header.equals(task.header) && description.equals(task.description) && type == task.type && timeTask.equals(task.timeTask);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idGenerator, header, description, type, id, timeTask);
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public static int getIdGenerator() {
        return idGenerator;
    }

    public  String getHeader() {
        return header;
    }

    public String getDescription() {
        return description;
    }

    public Type getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public  Date getTimeTask() {
        return timeTask.getTime();
    }
}

