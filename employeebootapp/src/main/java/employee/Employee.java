package employee;

public class Employee {

    private String name;

    private int yearOfBirth;

    public Employee(String name, int yearOfBirth) {
        this.name = name;
        if (yearOfBirth < 1900) {
            throw new IllegalArgumentException("Invalid year: " + yearOfBirth);
        }
        this.yearOfBirth = yearOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public int getAge(int atYear) {
        return atYear - yearOfBirth;
    }
}
