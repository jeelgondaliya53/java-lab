import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Run { }

class MyTestSuite {
    @Run
    public void testLogin() {
        System.out.println("Running: testLogin -> SUCCESS");
    }

    public void regularUtilityMethod() {
        System.out.println("This is a regular method, it should NOT run.");
    }

    @Run
    public void testDashboard() {
        System.out.println("Running: testDashboard -> SUCCESS");
    }

    @Run
    void testProfile() {
        System.out.println("Running: testProfile (package-private) -> SUCCESS");
    }
}

class TestRunner {
    public static void runTests(Class<?> clazz) {
        int runCount = 0;
        Method[] methods = clazz.getDeclaredMethods();

        try {
            Object testInstance = clazz.getDeclaredConstructor().newInstance();

            for (Method method : methods) {
                if (method.isAnnotationPresent(Run.class)) {
                    method.setAccessible(true);
                    method.invoke(testInstance);
                    runCount++;
                }
            }
        } catch (Exception e) {
            System.out.println("Error initializing or running tests: " + e.getMessage());
        }

        System.out.println("\nTotal methods executed: " + runCount);
    }
}

public class TestMain {
    public static void main(String[] args) {
        TestRunner.runTests(MyTestSuite.class);
    }
}