import java.util.Scanner;

abstract class Employee {
    String name;
    int id;

    Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    abstract double monthlySalary();
}

class FullTime extends Employee {
    double salary;

    FullTime(String name, int id, double salary) {
        super(name, id);
        this.salary = salary;
    }

    @Override
    double monthlySalary() {
        return salary;
    }
}

class PartTime extends Employee {
    double hours, rate;

    PartTime(String name, int id, double hours, double rate) {
        super(name, id);
        this.hours = hours;
        this.rate = rate;
    }

    @Override
    double monthlySalary() {
        return hours * rate;
    }
}

class Intern extends Employee {
    double stipend;

    Intern(String name, int id, double stipend) {
        super(name, id);
        this.stipend = stipend;
    }

    @Override
    double monthlySalary() {
        return stipend;
    }
}

public class Main {
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter FullTime employee name: ");
            String name1 = sc.nextLine();
            
            System.out.print("Enter FullTime ID: ");
            int id1 = sc.nextInt();
            
            System.out.print("Enter FullTime salary: ");
            double salary = sc.nextDouble();
            sc.nextLine();
            
            System.out.print("Enter PartTime employee name: ");
            String name2 = sc.nextLine();
            
            System.out.print("Enter PartTime ID: ");
            int id2 = sc.nextInt();
            
            System.out.print("Enter working hours: ");
            double hours = sc.nextDouble();
            
            System.out.print("Enter rate per hour: ");
            double rate = sc.nextDouble();
            sc.nextLine();
            
            System.out.print("Enter Intern name: ");
            String name3 = sc.nextLine();
            
            System.out.print("Enter Intern ID: ");
            int id3 = sc.nextInt();
            
            System.out.print("Enter Intern stipend: ");
            double stipend = sc.nextDouble();
            
            Employee[] employees = {
                new FullTime(name1, id1, salary),
                new PartTime(name2, id2, hours, rate),
                new Intern(name3, id3, stipend)
            };
            
            double total = 0;
            double largest = 0;
            String largestEmployee = "";
            
            for (int i = 0; i < employees.length; i++) {
                
                double sal = employees[i].monthlySalary();
                
                System.out.println("\nName = " + employees[i].name);
                System.out.println("ID = " + employees[i].id);
                System.out.println("Salary = " + sal);
                
                total = total + sal;
                
                if (sal > largest) {
                    largest = sal;
                    largestEmployee = employees[i].name;
                }
                
                if (employees[i] instanceof Intern) {
                    System.out.println("Note: This employee is an Intern.");
                }
            }
            
            System.out.println("\n----------------------");
            System.out.println("Total Salary = " + total);
            System.out.println("Largest Salary = " + largest);
            System.out.println("Highest Paid Employee = " + largestEmployee);
        }
    }
}