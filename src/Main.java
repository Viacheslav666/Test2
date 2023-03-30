import java.util.Scanner;

import static java.lang.Thread.sleep;


public class Main {
    public static void main(String[] args) throws IncorrectArgumentTaskException{

        Task monday = new Task("lover", "Popsa", Type.PERSONAL, Task.taskRepeatability.DAILY_TASK);
        Task tuesday = new Task("Kotler", "Marketing", Type.PROFESSIONAL, Task.taskRepeatability.YEARLY_TASK);
        Task wednesday = new Task("Tatu", "Bisnes", Type.PERSONAL, Task.taskRepeatability.MONTH_TASK);
        System.out.println(monday);
        System.out.println(tuesday);
        System.out.println(wednesday);
        UtilityClass mod = new UtilityClass();
        mod.addTask(monday);
        mod.addTask(wednesday);
        mod.addTask(tuesday);


        Scanner scanner = new Scanner(System.in);
        UtilityClass utilityClass = new UtilityClass();

        while (true) {
            System.out.println("1. Добавить задача");
            System.out.println("2. Получить задачу на день");
            System.out.println("3. Удалить по ID");
            System.out.println("4. Выход");
            System.out.print("Выберите пунт из меню ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.println("Напишите название задачи: ");
                    scanner.nextLine();
                    String header = scanner.nextLine();
                    System.out.println("Напишите описание задачи: ");
                    String descriptions = scanner.nextLine();
                    System.out.println("Выберите тип(PERSONAL, PROFESSIONAL:");
                    Type s = Type.valueOf(scanner.nextLine());
                    System.out.println("Выберите повторяемость(ONE_TAME_TASK, DAILY_TASK, MONTH_TASK, WEEKLY_TASK, YEARLY_TASK ):");
                    Enum e = Task.taskRepeatability.valueOf(scanner.nextLine());
                    try {
                        utilityClass.addTask1(header, descriptions, s, (Task.taskRepeatability) e);
                        System.out.println("Задача создана");
                    } catch (IncorrectArgumentTaskException q) {
                        throw new IncorrectArgumentTaskException("введите данные");
                    }
                }
                case 2 -> {
                    System.out.println("На сегодняшний день ваши задачи: ");
                    utilityClass.getDateTask1();
                }
                case 3 -> {
                    scanner.nextLine();
                    utilityClass.deleteTask();
                    System.out.println("Задача удалена");
                }
                case 4 -> System.exit(0);
                default -> System.out.println("Введите пункт из списка");
            }
        }

    }



}