import java.util.ArrayList;
import java.util.Random;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static Scanner in = new Scanner(System.in);

    public static final List<String> students = new ArrayList<>(List.of("Alice", "Bob", "Charlie", "Danny"));

    public static List<Integer> marks = new ArrayList<>(List.of(-1, -1, -1, -1));

    public static List<Boolean> attendance = new ArrayList<>(List.of(false, false, false, false));

    public static void main(String[] args) {
        String isContinue;
        do {
            menu();
            System.out.println("Если хотите продолжить, введите 'yes': ");
            isContinue = in.nextLine();
        } while ("yes".equals(isContinue));
        System.out.println(isContinue);
        in.close();
    }

    public static void instruction() {
        System.out.println("Всё очев при вводе, если спросишь всех учеников, можно начать новый урок.\nВ качестве вопроса спрашивается имя студента.\nЕсли чел присутствует, надо ввести 'y'.");
    }

    public static void asking() {
        Random rand = new Random();
        int num = rand.nextInt(3);
        System.out.print("Отвечает " + students.get(num) + "\nПрисутствует ли он на паре? ");
        String ans = in.next();
        if ("y".equals(ans)) {
            attendance.set(num, true);
            int mark;
            System.out.print("Как вас зовут? ");
            String name = in.next();
            if (name.equals(students.get(num))) {
                mark = 10;
            }
            else {
                mark = 0;
            }
            System.out.println("Оценка за ответ: " + mark);
            marks.set(num, mark);
        }
    }

    public static void menu() {
        System.out.println("""
                Выбери активность:
                1. Спросить рандомного студента
                2. Показать список студентов
                3. Показать оценки
                4. Начать новый урок
                0. Инструкция
                Введи номер нужной функции:\s""");
        int choice = in.nextInt();
        switch (choice) {
            case 0:
                instruction();
                break;
            case 1:
                asking();
                break;
            case 2:
                for (int i = 0; i < 4; i++) {
                    System.out.println("1. " + students.get(i));
                }
                break;
            case 3:
                for (int i = 0; i < 4; i++) {
                    if (attendance.get(i))
                        System.out.println((i + 1) + ". " + students.get(i) + ": " + marks.get(i));
                }
                break;
            case 4:
                marks = new ArrayList<>(List.of(-1, -1, -1, -1));
                attendance = new ArrayList<>(List.of(false, false, false, false));
                System.out.println("Cleared");
                break;
            default:
                System.out.println("Неизвестная функция");
        }
    }
}