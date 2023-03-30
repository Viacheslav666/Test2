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

    public void addTask1(String header, String descriptions, Type type, Task.taskRepeatability repeatability) throws IncorrectArgumentTaskException {

        Task task = new Task(header, descriptions, type, repeatability);
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


    public void getDateTask() {
        Map<Integer, Task> integerTaskMap = new HashMap<>();
        integerTaskMap.entrySet().stream()
                .map(Map.Entry::getValue)
                .filter(integerTaskEntry -> test()).toList()
                .forEach(System.out::println);

    }

    public void getDateTask1() {
        Calendar now = Calendar.getInstance();
        Task task = new Task();
        System.out.println("Задачи на сегодня");
        for (Integer task1 : this.taskMap.keySet()) {
            if(task.getTimeTask().equals(now.getTime())){
                System.out.println(task1);
            }
        }
    }
    public void deleteTask ()  {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер задачи для удаления");
        int id = scanner.nextInt();
        Task removedTask = taskMap.remove(id);
        if (removedTask != null) {
            System.out.println("Задача с "+ id + " удалена");
        }else {
            System.out.println("Задача не найдена");
        }



    }
//            integerStringMap.entrySet().stream()
//                    .map(Map.Entry::getValue)
//                    .collect(Collectors.toList())
//                    .forEach(System.out::println);



    private static boolean test () {
        Calendar timeToday = Calendar.getInstance();
        Task task = new Task();
        Date r = task.getTimeTask();
        return r.equals(timeToday.getTime());
    }

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
