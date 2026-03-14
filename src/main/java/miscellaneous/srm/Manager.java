package miscellaneous.srm;

public class Manager extends Employee{

    private int salary;
    private String grade;

    @Override
    void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    int getSalary() {
        return this.salary;
    }

    @Override
    String setGrade(String grade) {
        return this.grade = grade;
    }

    @Override
    String getGrade() {
        return this.grade;
    }
}
