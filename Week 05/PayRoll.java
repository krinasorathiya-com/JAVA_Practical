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

    double monthlySalary() {
        return stipend;
    }
}

public class PayRoll {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter FullTime employee name: ");
        String name1 = sc.nextLine();

        System.out.print("Enter ID: ");
        int id1 = sc.nextInt();

        System.out.print("Enter fixed salary: ");
        double salary = sc.nextDouble();
        sc.nextLine();

        System.out.print("\nEnter PartTime employee name: ");
        String name2 = sc.nextLine();

        System.out.print("Enter ID: ");
        int id2 = sc.nextInt();

        System.out.print("Enter hours: ");
        double hours = sc.nextDouble();

        System.out.print("Enter rate per hour: ");
        double rate = sc.nextDouble();
        sc.nextLine();

        System.out.print("\nEnter Intern name: ");
        String name3 = sc.nextLine();

        System.out.print("Enter ID: ");
        int id3 = sc.nextInt();

        System.out.print("Enter stipend: ");
        double stipend = sc.nextDouble();

        Employee[] employees = {
            new FullTime(name1, id1, salary),
            new PartTime(name2, id2, hours, rate),
            new Intern(name3, id3, stipend)
        };

        double total = 0;

        System.out.println("\n--- Payroll ---");

        for (Employee e : employees) {

            double sal = e.monthlySalary();

            System.out.println("Name: " + e.name);
            System.out.println("ID: " + e.id);
            System.out.println("Salary: " + sal);

            total += sal;

            if (e instanceof Intern) {
                System.out.println("Note: This is an Intern.");
            }

            System.out.println();
        }

        System.out.println("Total Salary = " + total);

        sc.close();
    }
}
