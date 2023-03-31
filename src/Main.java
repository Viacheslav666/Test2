import java.time.LocalDate;
import java.util.Scanner;

import static java.lang.Thread.sleep;


public class Main {
    public static void main(String[] args) throws IncorrectArgumentTaskException, TaskNotFoundException {


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
                    TaskRepeatability e = TaskRepeatability.valueOf(scanner.nextLine());
                    System.out.println("Введите год, месяц, число");
                    LocalDate date =  LocalDate.of(scanner.nextInt(),scanner.nextInt(),scanner.nextInt());
                    try {
                        utilityClass.addTask1(header, descriptions, s, (TaskRepeatability) e, date);
                        System.out.println("Задача создана");
                    } catch (IncorrectArgumentTaskException q) {
                        throw new IncorrectArgumentTaskException("введите данные");
                    }
                }
                case 2 -> {

                    utilityClass.getDateTaskNew();
                    System.out.println("На сегодняшний день ваши задачи: ");
                }
                case 3 -> {
                    scanner.nextLine();
                    try {
                        utilityClass.deleteTask();
                        System.out.println("Задача удалена");
                    } catch (TaskNotFoundException r) {

                    }
                }
                    case 4 -> System.exit(0);
                    default -> System.out.println("Введите пункт из списка");
                }
            }

        }


    }

