import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Run {
}

class MyTests {

    @Run
    public void testAddition() {
        int a = 10;
        int b = 20;

        if (a + b == 30) {
            System.out.println("testAddition: PASS");
        }
    }

    @Run
    public void testSubtraction() {
        int a = 20;
        int b = 10;

        if (a - b == 10) {
            System.out.println("testSubtraction: PASS");
        }
    }

    public void normalMethod() {
        System.out.println("This method should not run.");
    }

    @Run
    public void testMultiplication() {
        int a = 5;
        int b = 4;

        if (a * b == 20) {
            System.out.println("testMultiplication: PASS");
        }
    }
}

public class MiniTestRunner {

    public static void main(String[] args) {

        MyTests testObject = new MyTests();

        Method[] methods = testObject.getClass().getDeclaredMethods();

        int count = 0;

        for (Method method : methods) {

            if (method.isAnnotationPresent(Run.class)
                    && method.getParameterCount() == 0) {

                try {
                    method.invoke(testObject);
                    count++;
                } catch (java.lang.reflect.InvocationTargetException | IllegalAccessException e) {
                    System.out.println("Test failed: " + method.getName());
                }
            }
        }

        System.out.println("Total tests executed: " + count);
    }
}