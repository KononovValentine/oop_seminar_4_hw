package tasks;

import java.util.Calendar;

public class Task {
    private int duration;
    private Calendar deadlineDate;
    private String priority;
    private String theme;
    private String responsible;
    private String description;
    private boolean isNotificationDeadline = false;

    public Task(int duration, Calendar deadlineDate, String priority, String theme, String responsible,
                String description) {
        this.duration = duration;
        this.deadlineDate = deadlineDate;
        this.priority = priority;
        this.theme = theme;
        this.responsible = responsible;
        this.description = description;
        System.out.println("Создана задача \"" + theme + "\", по умолчанию уведомление о дедлайне выключено!");
    }

    // Включает уведомления
    public void setNotificationDeadlineOn() {
        isNotificationDeadline = true;
        System.out.println("Уведомление о дедлайне для " + theme + " включено.");
    }

    // Выключает уведомления
    public void setNotificationDeadlineOff() {
        isNotificationDeadline = false;
        System.out.println("Уведомление о дедлайне для " + theme + " отключено.");
    }

    // Возвращает дату
    public Calendar getDeadlineDate() {
        return deadlineDate;
    }

    // Возвращает тему
    public String getTheme() {
        return theme;
    }

    // Выводит уведомление о дедлайне
    public void deadlineNotification(Calendar date2) {
        if (isNotificationDeadline) {
            String[] differentDate = getDifference(date2);
            int day = Integer.parseInt(differentDate[0]);
            int month = Integer.parseInt(differentDate[1]);
            int year = Integer.parseInt(differentDate[2]);
            if (month <= 0 && year <= 0) {
                if (day == 3) {
                    System.out.println("Внимание! По задаче \"" + theme + "\" дедлайн через 3 дня.");
                } else if (day == 2) {
                    System.out.println("Внимание! По задаче \"" + theme + "\" дедлайн через 2 дня.");
                } else if (day == 1) {
                    System.out.println("Внимание! По задаче \"" + theme + "\" дедлайн через 1 день.");
                } else if (day == 0) {
                    System.out.println("Внимание! По задаче \"" + theme + "\" дедлайн сегодня.");
                } else if (day < 0) {
                    System.out.println("Внимание! По задаче \"" + theme + "\" дедлайн просрочен на "
                            + day * -1 + " дня(дней).");
                }
            }
        }
    }

    // Сравнивает текущую дату с датой дедлайна
    private String[] getDifference(Calendar date2) {
        Calendar date1 = this.deadlineDate;
        String stringBuilder = (date1.get(Calendar.DATE) - date2.get(Calendar.DATE)) +
                "/" +
                (date1.get(Calendar.MONTH) - date2.get(Calendar.MONTH)) +
                "/" +
                (date1.get(Calendar.YEAR) - date2.get(Calendar.YEAR));
        return stringBuilder.split("/");
    }
}
