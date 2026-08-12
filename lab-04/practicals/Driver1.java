import java.util.*;

public class Driver1 {
    public static void main(String[] args) {
        String[] log={
            "10:05 alice Hello there",
            "01:22 hiii whatsss uppp",
            "11:10",
            "01:11 ye ye ye"
            
        };
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter a keyword you wannt to search!:-");
        String keyword=sc.nextLine();

        String result = Chat.fill(log,keyword);

        System.out.println(result);

        sc.close();
    }

    }
    

