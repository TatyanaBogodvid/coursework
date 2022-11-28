public class Main {

    private static final Employee[] EMPLOYEES = new Employee[10];

    public static void main(String[] args) {
        EMPLOYEES[0] = new Employee("Иванов И.И.", 1, 5645);
        EMPLOYEES[1] = new Employee("Сидоров А.Р.", 1, 5433);
        EMPLOYEES[2] = new Employee("Петров С.И.", 5, 1300);
        EMPLOYEES[3] = new Employee("Васильев А.Р.", 3, 3500);
        EMPLOYEES[4] = new Employee("Укропов О.В.", 4, 8532);
        EMPLOYEES[5] = new Employee("Петрушкин Л.Д.", 1, 5240);
        EMPLOYEES[6] = new Employee("Подушкин. А.Н.", 3, 10043);
        EMPLOYEES[7] = new Employee("Хлорушкин Д.В.", 5, 1030);
        EMPLOYEES[8] = new Employee("Картинкин Л.К.", 2, 10120);
        EMPLOYEES[9] = new Employee("Лампочкин П.Л.", 4, 1030);

        printInfo();

        double allSalary = calculateAllSalary();
        System.out.println("Сумма ЗП: " + allSalary);

        Employee employeeWithMinSalary = findEmployeeWithMinSalary();
        System.out.println("Сотрудник с минимальной ЗП: " + employeeWithMinSalary);

        Employee employeeWithMaxSalary = findEmployeeWithMaxSalary();
        System.out.println("Сотрудник с максимальной ЗП: " + employeeWithMaxSalary);

        double averageSalary = findAverageSalary();
        System.out.println(averageSalary);

        printName();

        indexedSalary(10);

        Employee employeeWithMinSalaryInDep = findEmployeeWithMinSalaryInDep(3);
        System.out.println("Сотрудник с минимальной ЗП в отделе: " + employeeWithMinSalaryInDep);

        Employee employeeWithMaxSalaryInDep = findEmployeeWithMaxSalaryInDep(3);
        System.out.println("Сотрудник с максимальной ЗП в отделе: " + employeeWithMinSalaryInDep);

        double allSalaryInDep = calculateAllSalaryInDep(3);
        System.out.println(allSalaryInDep);

        double averageSalaryInDep = findAverageSalaryInDep(3);
        System.out.println("Средняя ЗП в отделе: " + averageSalaryInDep);

        printNameInDep(3);

    }
    private static void printInfo() {
        for (Employee employee: EMPLOYEES){
            if (employee != null){
            System.out.println(employee);
            }
        }
    }

    private static double calculateAllSalary() {
        double sum = 0;
        for (Employee employee: EMPLOYEES){
            if (employee != null){
                sum = sum + employee.getSalary();
            }
        }
        return sum;
    }

    private static Employee findEmployeeWithMinSalary(){
        double min = Double.MAX_VALUE;
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
        double max = Double.MIN_VALUE;
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
        return calculateAllSalary() / count;
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

    private static void indexedSalary(int index) {
        for (Employee employee: EMPLOYEES) {
            if (employee != null){
                employee.setSalary(employee.getSalary() + employee.getSalary() * index / 100);
                System.out.println("После индексации ЗП на " + index + " % сотрудник " +
                        employee.getName() + " получает " + employee.getSalary() + "рублей.");
            }
        }
    }

    private static Employee findEmployeeWithMinSalaryInDep(int numDep){
        if (numDep <= 0 && numDep > 5) {
            System.out.println("Номер отдела должен быть от 1 до 5");
        }
        double min = Double.MAX_VALUE;
        Employee employeeWithMinSalaryInDep = null;
        for (Employee employee: EMPLOYEES){
            if (employee != null && employee.getSalary() < min && employee.getNumDepartment() == numDep) {
                min = employee.getSalary();
                employeeWithMinSalaryInDep = employee;
            }
        }
        return employeeWithMinSalaryInDep;
    } //Почему выводится не индексированная ЗП?

   private static Employee findEmployeeWithMaxSalaryInDep(int numDep){
        double max = Double.MIN_VALUE;
        Employee employeeWithMaxSalaryInDep = null;
        for (Employee employee: EMPLOYEES){
            if (employee != null && employee.getSalary() > max && employee.getNumDepartment() == numDep) {
                max = employee.getSalary();
                employeeWithMaxSalaryInDep = employee;
            }
        }
        return employeeWithMaxSalaryInDep;
    } // Почему не работает код выводит такой же результат как минимальная ЗП?

    private static double calculateAllSalaryInDep(int numDep) {
        double sum = 0;
        for (Employee employee: EMPLOYEES){
            if (employee != null && employee.getNumDepartment() == numDep){
                sum = sum + employee.getSalary();
            }
        }
        return sum;
    }

    private static double findAverageSalaryInDep(int numDep) {
        int count = 0;
        for (Employee employee: EMPLOYEES){
            if (employee != null && employee.getNumDepartment() == numDep){
                count++;
            }
        }
        if  (count != 0){
            return calculateAllSalaryInDep(numDep) / count;
        }
        return 0;
    }

    private static void indexedSalaryInDep(int numDep, int index) {
        for (Employee employee: EMPLOYEES) {
            if (employee != null && employee.getNumDepartment() == numDep){
                employee.setSalary(employee.getSalary() + employee.getSalary() * index / 100);
                System.out.println("После индексации ЗП на " + index + " % сотрудник " +
                        employee.getName() + " получает " + employee.getSalary() + "рублей.");
            }
        }
    }

    private static void printNameInDep(int numDep) {
        for (Employee employee: EMPLOYEES){
            if (employee != null && employee.getNumDepartment() == numDep){
                System.out.println(employee.getName());
            }
        }
    }












}