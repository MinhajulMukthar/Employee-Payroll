import java.util.ArrayList;
import java.util.List;

abstract class Employee {
    private String name;
    private int id;

    // Created Parameterized Constructor
    public Employee(String name , int id){
        this.name = name;
        this.id = id;
    }

    // Getters
    public String getName() {
        return name;
    }

//    public void setName(String name) {
//        this.name = name;
//    }

//    public void setId(int id) {
//        this.id = id;
//    }

    public int getId() {
        return id;
    }

    // Abstract method to calculate all types of Employee salary
    public abstract double calculateSalary();

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id + '\'' +
                "salary='" + calculateSalary() +
                '}';
    }
}
class FullTimeEmployee extends Employee {
    private double monthlySalary;
    public FullTimeEmployee(String name, int id, double monthlySalary  ) {
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee{
    private int totalWorkingHours;
    private double perHoursWages;

    public PartTimeEmployee(String name , int id , int totalWorkingHours , double perHoursWages ){
        super(name, id);
        this.totalWorkingHours = totalWorkingHours;
        this.perHoursWages = perHoursWages;
    }

    @Override
    public double calculateSalary() {
        return totalWorkingHours * perHoursWages;
    }
}

class PayRoll {
    private List<Employee> employeeList;

    public PayRoll(){
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }
    public void removeEmployee(int id){
        Employee employeeToRemove = null;
        for (Employee employee : employeeList){
            if (employee.getId() == id){
                employeeToRemove = employee;
                break;
            }
        }
        if (employeeToRemove != null){
            employeeList.remove(employeeToRemove);
        }
    }

    public void display(){
        for (Employee employee : employeeList){
            System.out.println(employee);
            System.out.println();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        PayRoll payRoll = new PayRoll();
         FullTimeEmployee em1 = new FullTimeEmployee("Zainu" , 01 , 850000);
         FullTimeEmployee em2 = new FullTimeEmployee("ashdi" , 02 , 810000);
         FullTimeEmployee em3 = new FullTimeEmployee("Mainjas" , 03 , 560000);

         PartTimeEmployee em4 = new PartTimeEmployee("Faizan" , 04 ,45,100);
         PartTimeEmployee em5 = new PartTimeEmployee("Fairhan" , 05 ,45,120);
         PartTimeEmployee em6 = new PartTimeEmployee("Fajka" , 06 ,45,95);

         payRoll.addEmployee(em1);
         payRoll.addEmployee(em2);
         payRoll.addEmployee(em3);
         payRoll.addEmployee(em4);
         payRoll.addEmployee(em5);
         payRoll.addEmployee(em6);

        System.out.println("EMPLOYEE DETAILS : ");
         payRoll.display();

         payRoll.removeEmployee(05);
        System.out.println("UPDATED EMPLOYEE DETAILS");
        payRoll.display();
    }
}
