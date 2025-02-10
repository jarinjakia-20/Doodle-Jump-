// PracticeProblem 08(a)
 abstract class Employee {
    protected String name;
    protected int id;
    protected String department;

    public Employee(String name, int id, String department) {
        this.name = name;
        this.id = id;
        this.department = department;
    }

    public abstract double calculatePay();
}

class FullTimeEmployee extends Employee {
    private double fixedSalary;

    public FullTimeEmployee(String name, int id, String department, double fixedSalary) {
        super(name, id, department);
        this.fixedSalary = fixedSalary;
    }

    @Override
    public double calculatePay() {
        return fixedSalary;
    }
}

class PartTimeEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    public PartTimeEmployee(String name, int id, String department, double hourlyRate, int hoursWorked) {
        super(name, id, department);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculatePay() {
        return hourlyRate * hoursWorked;
    }
}

class ContractEmployee extends Employee {
    private String projectName;
    private double contractAmount;

    public ContractEmployee(String name, int id, String department, String projectName, double contractAmount) {
        super(name, id, department);
        this.projectName = projectName;
        this.contractAmount = contractAmount;
    }

    @Override
    public double calculatePay() {
        return contractAmount;
    }
}

public class PracticeProblem08 {
    public static void main(String[] args) {
        Employee fullTimeEmp = new FullTimeEmployee("Alice", 101, "HR", 60000);
        Employee partTimeEmp = new PartTimeEmployee("Bob", 102, "IT", 50, 160);
        Employee contractEmp = new ContractEmployee("Charlie", 103, "Finance", "Project A", 50000);

        System.out.println("Full-time Employee Pay: " + fullTimeEmp.calculatePay());
        System.out.println("Part-time Employee Pay: " + partTimeEmp.calculatePay());
        System.out.println("Contract Employee Pay: " + contractEmp.calculatePay());
    }
}

