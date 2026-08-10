import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        String[] logs = {
            "10:05 alice Hello there",
            "10:10 bob How are you",
            "10:15 charlie"
        };

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter keyword: ");
        String keyword = sc.nextLine();

        ChatFilter.filterLogs(logs, keyword);

        sc.close();
    }
}