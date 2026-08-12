public class Password {

    public static final String length=".{8,}";
    public static final String uppercaseletters=".*[A-Z].*";
    public static final String digit=".*[0-9].*";
    public static final String specialpattern=".*[^a-zA-Z0-9].*";

    public static boolean checkLength(String pass) {
        return pass.matches(length);
    }

    public static boolean checkupercase(String pass) {
        return pass.matches(uppercaseletters);
    }

    public static boolean checkdigit(String pass) {
        return pass.matches(digit);
    }

    public static boolean checkpattern(String pass) {
        return pass.matches(specialpattern);
    }

    public static String strength(String pass) {

        int count = 0;

        if (checkLength(pass)) {
            count++;
        }

        if (checkupercase(pass)) {
            count++;
        }

        if (checkdigit(pass)) {
            count++;
        }

        if (checkpattern(pass)) {
            count++;
        }

        if (count <= 1) {
            return "weak password!";
        }
        else if (count <= 3) {
            return "medium password";
        }
        else {
            return "strong password!";
        }
    }
}