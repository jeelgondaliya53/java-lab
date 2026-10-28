import java.util.*;

public class UniqueVisitors {
    public static void main(String[] args) {
        List<String> logins = Arrays.asList(
            "jeel", "riya", "aman", "jeel",
            "priya", "riya", "karan", "aman"
        );

        Set<String> uniqueUsers = new HashSet<>(logins);
        Set<String> firstSeenOrder = new LinkedHashSet<>(logins);

        System.out.println("Unique user count: " + uniqueUsers.size());
        System.out.println("First three distinct names:");

        int count = 0;

        for (String name : firstSeenOrder) {
            if (count == 3) {
                break;
            }

            System.out.println(name);
            count++;
        }
    }
}