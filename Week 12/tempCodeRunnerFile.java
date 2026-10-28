import java.util.*;

public class UniqueVisitors {

    public static void main(String[] args) {

        List<String> logins = Arrays.asList(
            "Krina",
            "Riya",
            "Neha",
            "Krina",
            "Aarav",
            "Riya",
            "Dev",
            "Neha"
        );

        HashSet<String> uniqueUsers =
            new HashSet<>(logins);

        LinkedHashSet<String> orderedUsers =
            new LinkedHashSet<>(logins);

        System.out.println(
            "Number of unique users: " +
            uniqueUsers.size()
        );

        System.out.println("First three distinct names:");

        int count = 0;

        for (String name : orderedUsers) {

            System.out.println(name);
            count++;

            if (count == 3) {
                break;
            }
        }
    }
}