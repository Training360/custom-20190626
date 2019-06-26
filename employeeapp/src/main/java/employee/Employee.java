package employee;

public class Employee {

    private String name;

    private int yearOfBirth;

    public Employee(String name, int yearOfBirth) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
    }

    public int getAge(int atYear) {
        return atYear - yearOfBirth;
    }
}
