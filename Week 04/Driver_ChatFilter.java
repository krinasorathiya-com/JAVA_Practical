import java.util.Scanner;

public class Driver_ChatFilter {
    public static void main(String[] args) {
        String[] logs = {
            "10:05 alice Hello there",
            "10:10 bob How are you",
            "10:15 charlie"
        };

        System.out.print("Enter keyword: ");
        try (Scanner sc = new Scanner(System.in)) {
            String keyword = sc.nextLine();
            ChatFilter.filterLogs(logs, keyword);
        }
    }
}