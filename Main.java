package FinalOOPLab;

class Time {
    private int hour;
    private int min;
    private int sec;

    public Time(int hour, int min, int sec) {
        this.hour = hour;
        this.min = min;
        this.sec = sec;
    }

    public int getHour() {
        return hour;
    }

    public int getMin() {
        return min;
    }

    public int getSec() {
        return sec;
    }

    public void add(Time otherTime) {
        int totalSec = this.sec + otherTime.sec;
        int carry = totalSec / 60;
        int remainingSec = totalSec % 60;

        int totalMin = this.min + otherTime.min + carry;
        carry = totalMin / 60;
        int remainingMin = totalMin % 60;

        int totalHour = this.hour + otherTime.hour + carry;

        System.out.println("Total Time: " + totalHour + " hours, " + remainingMin + " minutes, " + remainingSec + " seconds");
    }
}

public class Main {
    public static void main(String[] args) {
        Time time1 = new Time(1, 30, 45);
        Time time2 = new Time(2, 15, 20);

        System.out.println("Time 1: " + time1.getHour() + " hours, " + time1.getMin() + " minutes, " + time1.getSec() + " seconds");
        System.out.println("Time 2: " + time2.getHour() + " hours, " + time2.getMin() + " minutes, " + time2.getSec() + " seconds");

        time1.add(time2);
    }
}
