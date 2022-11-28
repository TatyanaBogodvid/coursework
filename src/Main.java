public class Main {

    private static final Employee[] EMPLOYEES = new Employee[10];

    public static void main(String[] args) {
        EMPLOYEES[0] = new Employee("Иванов И.И.", 1, 5645);
        EMPLOYEES[1] = new Employee("Сидоров А.Р.", 1, 5433);
        EMPLOYEES[2] = new Employee("Петров С.И.", 5, 1300);
        EMPLOYEES[3] = new Employee("Васильев А.Р.", 3, 3500);
        EMPLOYEES[4] = new Employee("Укропов О.В.", 4, 8532);
        EMPLOYEES[5] = new Employee("Петрушкин Л.Д.", 1, 5240);
        EMPLOYEES[6] = new Employee("Подушкин. А.Н.", 3, 1043);
        EMPLOYEES[7] = new Employee("Хлорушкин Д.В.", 5, 1030);
        EMPLOYEES[8] = new Employee("Картинкин Л.К.", 2, 10120);
        EMPLOYEES[9] = new Employee("Лампочкин П.Л.", 4, 1030);

        printInfo();

        int allSalary = calculateAllSalary();
        System.out.println("Сумма ЗП: " + allSalary);

        Employee employeeWithMinSalary = findEmployeeWithMinSalary();
        System.out.println("Сотрудник с минимальной ЗП: " + employeeWithMinSalary);

        Employee employeeWithMaxSalary = findEmployeeWithMaxSalary();
        System.out.println("Сотрудник с максимальной ЗП: " + employeeWithMaxSalary);

        double averageSalary = findAverageSalary();
        System.out.println(averageSalary);

        printName();
    }
    private static void printInfo() {
        for (Employee employee: EMPLOYEES){
            if (employee != null){
            System.out.println(employee);
            }
        }
    }

    private static int calculateAllSalary() {
        int sum = 0;
        for (Employee employee: EMPLOYEES){
            if (employee != null){
                sum = sum + employee.getSalary();
            }
        }
        return sum;
    }

    private static Employee findEmployeeWithMinSalary(){
        int min = Integer.MAX_VALUE;
        Employee employeeWithMinSalary = null;
        for (Employee employee: EMPLOYEES){
            if (employee != null && employee.getSalary() < min) {
                min = employee.getSalary();
                employeeWithMinSalary = employee;
            }
        }
        return employeeWithMinSalary;
    }

    private static Employee findEmployeeWithMaxSalary(){
        int max = Integer.MIN_VALUE;
        Employee employeeWithMaxSalary = null;
        for (Employee employee: EMPLOYEES){
            if (employee != null && employee.getSalary() > max) {
                max = employee.getSalary();
                employeeWithMaxSalary = employee;
            }
        }
        return employeeWithMaxSalary;
    }

    private static double findAverageSalary() {
        int count = 0;
        for (Employee employee: EMPLOYEES){
            if (employee != null){
                count++;
            }
        }
        if  (count != 0){
        return (double) calculateAllSalary() / count;
        }
        return 0;
    }

    private static void printName() {
        for (Employee employee: EMPLOYEES){
            if (employee != null){
                System.out.println(employee.getName());
            }
        }
    }



}