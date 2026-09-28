import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface NotBlank {
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

class SignupForm {

    @NotBlank
    @MaxLength(20)
    String name;

    @NotBlank
    @MaxLength(30)
    String email;

    @NotBlank
    @MaxLength(10)
    String mobile;

    SignupForm(String name, String email, String mobile) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
    }
}

public class FormValidator {

    public static void main(String[] args) {

        SignupForm form = new SignupForm(
            "",
            "krina@example.com",
            "12345678901"
        );

        List<String> errors = new ArrayList<>();

        Field[] fields = form.getClass().getDeclaredFields();

        for (Field field : fields) {

            try {
                field.setAccessible(true);

                String value = (String) field.get(form);

                if (field.isAnnotationPresent(NotBlank.class)) {
                    if (value == null || value.trim().isEmpty()) {
                        errors.add(field.getName() + " cannot be blank");
                    }
                }

                if (field.isAnnotationPresent(MaxLength.class)) {
                    MaxLength max = field.getAnnotation(MaxLength.class);

                    if (value != null && value.length() > max.value()) {
                        errors.add(
                            field.getName() +
                            " must not exceed " +
                            max.value() +
                            " characters"
                        );
                    }
                }

            } catch (Exception e) {
                System.out.println(e);
            }
        }

        if (errors.isEmpty()) {
            System.out.println("Form is valid.");
        } else {
            System.out.println("Validation Errors:");

            for (String error : errors) {
                System.out.println(error);
            }
        }
    }
}
