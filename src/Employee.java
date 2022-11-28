public class Employee {

    private static int idGenerator = 1;

    private final int id;
    private final String name;
    private int numDepartment;
    private double salary;

    public Employee (String name, int numDepartment, int salary){
        this.id = idGenerator++;
        this.name = name;
        this.numDepartment = numDepartment;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getNumDepartment() {
        return numDepartment;
    }

    public double getSalary() {
        return salary;
    }

    public void setNumDepartment(int numDepartment) {
        this.numDepartment = numDepartment;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString(){
        return "id: " + id + " ФИО сотрудника " + name + " номер департамента: "
                + numDepartment + " зарплата сотрудника: " + salary;
    }
}
