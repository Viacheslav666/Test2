import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class UtilityClass {
    private final Map<Integer, Task> taskMap;


    public UtilityClass() {
        List<Task> archiv = new ArrayList<>();
        taskMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
    }

    public void addTask1(String header, String descriptions, Type type, TaskRepeatability repeatability, LocalDate date) throws IncorrectArgumentTaskException {
        Task task;
        switch (repeatability) {
            case MONTH_TASK: {
                task = new MonthTask(header, descriptions, type, repeatability, date);
                break;
            }
            case ONE_TAME_TASK:
            case DAILY_TASK: {
                task = new OneTimeTask(header, descriptions, type, repeatability, date);
                break;
            }
            case WEEKLY_TASK:{
                task = new OneTimeTask(header, descriptions, type, repeatability, date);
                break;
            }
            case YEARLY_TASK:{
                task = new OneTimeTask(header, descriptions, type, repeatability, date);
                break;
            }
            default:{
                System.out.println("Данный тип не поддерживается");
                return;}
        }
            try {
            taskMap.put(task.getId(), task);
        } catch (EnumConstantNotPresentException e) {
            throw new IncorrectArgumentTaskException("некорректно введены данные");
        }

    }

    public void addTask(Task task) throws IncorrectArgumentTaskException {

        try {
            if (task != null) {

                taskMap.put(task.getId(), task);
            }
        } catch (RuntimeException e) {
            throw new IncorrectArgumentTaskException("Ноль вводить нельзя");
        } finally {
            System.out.println("Создали");
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UtilityClass that = (UtilityClass) o;
        return taskMap.equals(that.taskMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskMap);
    }


//    public void getDateTask() {
//        taskMap.values().stream()
//                .filter(integerTaskEntry -> test()).toList()
//                .forEach(System.out::println);

//    }

//    public void getDateTask1() {
//        Calendar now = Calendar.getInstance();
//
//          Task task = new Task();
//        System.out.println("Задачи на сегодня");
//        for (Integer task1 : this.taskMap.keySet()) {
//            if(task.getTimeTask().equals(now.getTime())){
//                System.out.println(task1);
//            }
//        }
//    }
    public void getDateTaskNew() {
        Scanner scanner = new Scanner(System.in);
        LocalDate date =  LocalDate.of(scanner.nextInt(),scanner.nextInt(),scanner.nextInt());
        for (Task task1 : this.taskMap.values()) {
            if(task1.appearshIn(date)){
                System.out.println("Задачи на сегодня");
                System.out.println(task1);
            }
        }
    }
    public void deleteTask () throws TaskNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер задачи для удаления");
        int id = scanner.nextInt();
        Task removedTask = taskMap.remove(id);
        if (removedTask != null) {
            System.out.println("Задача с "+ id + " удалена");
        }else {
            throw new TaskNotFoundException("Задача не найдена");
        }
    }

    public void deleteTask1(Task id) {
        taskMap.entrySet().stream()
                 .map(Map.Entry::getValue)
                    .collect(Collectors.toList())
                    .forEach(System.out::println);


    }

//    private static boolean test () {
//        Calendar timeToday = Calendar.getInstance();
////        Task task = new Task();
//        Date r = task.getTimeTask();
//        return r.equals(timeToday.getTime());
//    }

    @Override
    public String toString () {
        return "Список задач" + getTaskList();
    }

    public Map<Integer, Task> getTaskList () {
        return taskMap;
    }
    public void checkType (Type type) throws IncorrectArgumentTaskException {
        if (type == null) {
            throw new IncorrectArgumentTaskException("Выберите из списка");
        }
    }

}
