package miscellaneous.srm;

public abstract class Employee {
    abstract void setSalary(int salary);
    abstract int getSalary();
    abstract String setGrade(String grade);
    abstract String getGrade();

    private void label(){
        System.out.println("Salary : " + getSalary() + " Grade : " + getGrade());
    }
}
