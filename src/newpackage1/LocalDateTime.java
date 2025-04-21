
package newpackage1;


public final class LocalDateTime {

    private int year;
    private int month;
    private int hour;
    private int minute;

// Default constructor
    public LocalDateTime() {
        this(0, 0, 0, 0);
    }

// Full constructor
    public LocalDateTime(int year, int month, int hour, int minute) {
        this.year = year;
        this.month = month;
        this.hour = hour;
        this.minute = minute;
    }

// Setters
    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

// Getters
    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    @Override
    public String toString() {
        return String.format("%02d/%02d - %02d:%02d", month, year, hour, minute);
    }
}