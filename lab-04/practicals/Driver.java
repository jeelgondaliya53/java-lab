public class Driver {

    public static void main(String args[]) {

        String[] password = {
            "abc",
            "abc1234",
            "Abc!123",
            "xyzzzzzz1",
            "J123@",
            "Jeel@12367"
        };

        for (String pass : password) {

            System.out.println("Password: " + pass);

            System.out.println("Length >= 8: "
                    + Password.checkLength(pass));

            System.out.println("Uppercase: "
                    + Password.checkupercase(pass));

            System.out.println("Digit: "
                    + Password.checkdigit(pass));

            System.out.println("Special character: "
                    + Password.checkpattern(pass));

            System.out.println("Strength: "
                    + Password.strength(pass));

            System.out.println("-------------------------");
        }
    }
}