@FunctionalInterface 
interface Notifier{
    void send(String msg);
}
interface urgent{

}
public class Notification {

    public static void main(String[] args) {

        Notifier email = message ->
                System.out.println("Email: " + message);

        Notifier sms = message ->
                System.out.println("SMS: " + message);
        Notifier[] sender={
            sms,
            email
        };

        String message = "Notification....";

        for (Notifier s:sender) {
            s.send(message);
        }
    }
}
