import java.io.*;

class Student implements Serializable {
    int rollNo;
    String name;
    transient String password;   

    Student(int rollNo, String name, String password) {
        this.rollNo = rollNo;
        this.name = name;
        this.password = password;
    }

    void display() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Password: " + password);
        System.out.println();
    }
}

public class SerializableDemo {
    public static void main(String[] args) {

        Student[] students = {
            new Student(101, "Krina", "abc123"),
            new Student(102, "Riya", "xyz456"),
            new Student(103, "Neha", "pqr789")
        };

        try {
            ObjectOutputStream out =
                new ObjectOutputStream(new FileOutputStream("students.dat"));

            out.writeObject(students);
            out.close();

            System.out.println("Objects saved successfully.\n");

        } catch (IOException e) {
            System.out.println("Error while saving: " + e);
        }

        try {
            ObjectInputStream in =
                new ObjectInputStream(new FileInputStream("students.dat"));

            Student[] loadedStudents = (Student[]) in.readObject();
            in.close();

            System.out.println("Objects loaded successfully.\n");

            for (Student s : loadedStudents) {
                s.display();
            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error while loading: " + e);
        }
    }
}