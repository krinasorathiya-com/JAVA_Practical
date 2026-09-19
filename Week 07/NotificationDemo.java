@FunctionalInterface
interface Notifier {
    void send(String message);
}

// Marker interface
interface Urgent {
}

// Wrapper class for urgent senders
class UrgentNotifier implements Notifier, Urgent {
    private Notifier notifier;

    UrgentNotifier(Notifier notifier) {
        this.notifier = notifier;
    }

    @Override
    public void send(String message) {
        notifier.send(message);
    }
}

public class NotificationDemo {
    public static void main(String[] args) {

        // Email and SMS senders using lambda expressions
        Notifier email = message ->
                System.out.println("Email: " + message);

        Notifier sms = message ->
                System.out.println("SMS: " + message);

        // Mark the SMS sender as urgent
        Notifier urgentSms = new UrgentNotifier(sms);

        Notifier[] senders = {email, urgentSms};

        String message = "Your assignment is due tomorrow.";

        System.out.println("Broadcasting Message:");

        for (Notifier sender : senders) {
            sender.send(message);

            // Send again if the sender is urgent
            if (sender instanceof Urgent) {
                sender.send(message);
            }
        }
    }
}