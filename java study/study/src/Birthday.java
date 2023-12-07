import java.time.LocalDate;
import java.time.Period;

public class Birthday {
    private int year, month, day;

    public Birthday(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public int age() {
        LocalDate birthDate = LocalDate.of(year, month, day);
        LocalDate currentDate = LocalDate.of(2017, 12, 25);
        Period agePeriod = Period.between(birthDate, currentDate);
        int age = agePeriod.getYears();
        return age;
    }
}
