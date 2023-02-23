package tasks;

import java.util.Calendar;

public class Issue extends Task{
    private String mentor;

    public Issue(int duration, Calendar deadlineDate, String priority, String theme, String responsible,
                 String description, String mentor) {
        super(duration, deadlineDate, priority, theme, responsible, description);
        this.mentor = mentor;
    }
}
