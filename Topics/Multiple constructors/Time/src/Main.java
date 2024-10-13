class Time {

    int hours;
    int minutes;
    int seconds;

    public Time(int hours) {
        this.hours = hours;
    }

    public Time(int hours, int minutes) {
        this(hours, minutes, 20);
    }

    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }
}