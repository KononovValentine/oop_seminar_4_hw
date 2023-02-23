package tasks;

import java.util.Calendar;

public class Bug extends Task{
    private String playbackSteps;

    public Bug(int duration, Calendar deadlineDate, String priority, String theme, String responsible,
               String description, String playbackSteps) {
        super(duration, deadlineDate, priority, theme, responsible, description);
        this.playbackSteps = playbackSteps;
    }
}
