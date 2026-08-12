public class Driver3 {

    public static void main(String[] args) {

        String template = "Dear {name}, order {id} ships {date}.";

        String[] names = {"name", "id"};
        String[] values = {"Riya", "A07"};

        String result = Template.fillTemplate(template, names, values);

        System.out.println(result);
    }
}