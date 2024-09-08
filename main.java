public class EmployeeTest {

    public static void main(String[] args) {

        Date birth = new Date(7, 24, 1949);
        Date hire = new Date(3, 12, 1988);

        Employee employee = new Employee("Bob", "Blue", birth, hire);

        System.out.println(employee);
    }
}

class Date {
    private int month;
    private int day;
    private int year;

    private static final int[] daysPerMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public Date(int month, int day, int year) {
        if (month <= 0 || month > 12) {
            throw new IllegalArgumentException("month (" + month + ") must be 1-12");
        }
        if (day <= 0 || (day > daysPerMonth[month] && !(month == 2 && day == 29))) {
            throw new IllegalArgumentException("day (" + day + ") out-of-range for the specified month and year");
        }
        if (month == 2 && day == 29 && !(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))) {
            throw new IllegalArgumentException("day (" + day + ") out-of-range for the specified month and year");
        }
        this.month = month;
        this.day = day;
        this.year = year;

        System.out.printf("Date object constructor for date %s%n", this);
    }

    @Override
    public String toString() {
        return String.format("%d/%d/%d", month, day, year);
    }
}

class Employee {
    private String firstName;
    private String lastName;
    private Date birthDate;
    private Date hireDate;

    public Employee(String firstName, String lastName, Date birthDate, Date hireDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.hireDate = hireDate;
    }

    @Override
    public String toString() {
        return String.format("%s, %s Hired: %s Birthday: %s", lastName, firstName, hireDate, birthDate);
    }
}
