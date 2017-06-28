import java.util.Comparator;

public class WeeklyEntry {
    public static final Comparator<WeeklyEntry> BY_WEEKDAY = getComparatorByDay();

    private Weekday weekday;
    private String notes;

    public WeeklyEntry(String weekday, String notes) {
        this.weekday=Weekday.valueOf(weekday.toUpperCase());
        this.setNotes(notes);
    }

    public Weekday getWeekday() {
        return this.weekday;
    }

    public String getNotes() {
        return this.notes;
    }

    private void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return this.weekday.toString()+" - "+this.notes;
    }

    private static Comparator<WeeklyEntry> getComparatorByDay() {
        return Comparator.comparing(w->w.weekday);
    }
}
