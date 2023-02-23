/*
С учетом информации полученной ранее знакомимся с параметрическим полиморфизмом и продолжаем погружаться в ООП.
Спроектировать и реализовать планировщик дел для работы с задачами разных приоритетов.

Например:
Должен быть класс Задачи (общий/родительский и подтипы)
У задачи должно быть длительность, дедлайн, приоритет, тема, ответсвенный... - параметры на Ваше усмотрение
**У задачи должна быть возможность включить или выключить нотификацию на разные события, например, приближение дедлайна.

Должен быть класс Календарь, в который можно добавлять Задачи.
*** При пересечении задач по времени - выводить сообщение пользователю.

**** Должна быть возможность выгрузки Календаря в файл (тип на Ваше усмотрение)
**** Файл должен содержать следующие данные: id, дату добавления записи, время добавления записи, дедлай задачи,
ФИО автора и др
 */

import tasks.Issue;
import tasks.Task;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Program {

    public static void main(String[] args) {
        Calendar calendar = new GregorianCalendar(2023, Calendar.FEBRUARY, 23);
        Issue task = new Issue(3, calendar, "High", "Сделать домашнее задание"
                , "Валентин", "", "Станислав");
        Issue task2 = new Issue(2, calendar, "Low", "Бездельничать"
                , "Валентин", "", "Валентин");
        task.setNotificationDeadlineOn();
        Calendar calendar1 = new GregorianCalendar();
        task.deadlineNotification(calendar1);

        DailyPlanner dailyPlanner = new DailyPlanner();
        dailyPlanner.addTask(task);
        dailyPlanner.addTask(task2);
    }
}
