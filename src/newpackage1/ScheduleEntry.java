
package newpackage1;


public final class ScheduleEntry implements Bookable {

    private int ID;
    private LocalDateTime time;
    private boolean available;

    public ScheduleEntry() {
        this(0, null, true);
    }

    public ScheduleEntry(int ID, LocalDateTime time, boolean available) {
        this.ID = ID;
        this.time = time;
        this.available = available;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public void book() {
        setAvailable(false);
        System.out.println("Your schedule entry has been booked!");
    }

    @Override
    public String toString() {
        return String.format("ID: %d\nTime: %s\nAvailable: %s", getID(), getTime(), isAvailable());
    }
}