import java.lang.annotation.*;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Column {
    String name();
}

class Student {

    @Column(name = "student_name")
    String name;

    @Column(name = "student_age")
    int age;

    @Column(name = "student_email")
    String email;

    public void display() {
        System.out.println("Name  : " + name);
        System.out.println("Age   : " + age);
        System.out.println("Email : " + email);
    }
}

public class ColumnMapper {

    public static void main(String[] args) {

        String[] headers = {
            "student_name",
            "student_age",
            "student_email"
        };

        String[] values = {
            "Krina",
            "20",
            "krina@gmail.com"
        };

        Student student = new Student();

        Field[] fields = student.getClass().getDeclaredFields();

        for (Field field : fields) {

            if (field.isAnnotationPresent(Column.class)) {

                Column column = field.getAnnotation(Column.class);

                String columnName = column.name();

                for (int i = 0; i < headers.length; i++) {

                    if (headers[i].equals(columnName)) {

                        try {
                            field.setAccessible(true);

                            if (field.getType() == String.class) {
                                field.set(student, values[i]);
                            }
                            else if (field.getType() == int.class) {
                                field.setInt(student, Integer.parseInt(values[i]));
                            }

                        } catch (IllegalAccessException | NumberFormatException e) {
                            System.out.println(e);
                        }
                    }
                }
            }
        }

        student.display();
    }
}