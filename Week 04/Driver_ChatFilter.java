import java.util.Scanner;

public class Driver_ChatFilter {
    public static void main(String[] args) {
        String[] logs = {
            "10:50 Student Hello there",
            "11:11 bob How are you",
            "15:10 krina"
        };

        System.out.print("Enter keyword: ");
        try (Scanner sc = new Scanner(System.in)) {
            String keyword = sc.nextLine();
            ChatFilter.filterLogs(logs, keyword);
        }
    }
}