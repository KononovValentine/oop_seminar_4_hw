import tasks.Task;

import java.util.LinkedList;
import java.util.Scanner;

public class DailyPlanner {
    Scanner scanner = new Scanner(System.in);
    private LinkedList<Task> taskList = new LinkedList<>();

    public DailyPlanner() {
    }

    // Добавляет новую задачу если она не пересекается по времени иначе выдает сообщение и спрашивает продолжение
    public void addTask(Task task) {
        System.out.println(task.getDeadlineDate().getTime());
        if (taskList.isEmpty()) {
            taskList.add(task);
        } else {
            for (int i = 0; i < taskList.size(); i++) {
                if (taskList.get(i).getDeadlineDate().getTime().equals(task.getDeadlineDate().getTime())) {
                    System.out.println("Внимание! Задача " + taskList.get(i).getTheme()
                            + " пересекается по времени с текущей!");
                }
            }
            System.out.println("Вы уверены что хотите продолжить? Введите Y для продолжения N для отмены.");
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("y")) {
                taskList.add(task);
            } else {
                System.out.println("Задача не была добавлена в список.");
            }
        }
    }

    // удаляет задачу из списка
    public void removeTask(Task task) {
        taskList.remove(task);
    }
}
