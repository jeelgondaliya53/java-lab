import java.io.*;

class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    int id;
    String name;
    transient String password;

    Student(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }
}

public class SerializationDemo {
    public static void main(String[] args) {
        Student[] students = {
            new Student(1, "Jeel", "abc123"),
            new Student(2, "xyzzz", "xyz456")
        };

        try {
            // Save objects to a file
            ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("students.dat")
            );
            out.writeObject(students);
            out.close();

            System.out.println("Objects saved successfully.");

            // Read objects into fresh objects
            ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("students.dat")
            );
            Student[] loaded = (Student[]) in.readObject();
            in.close();

            // Display loaded values
            for (Student s : loaded) {
                System.out.println("ID: " + s.id);
                System.out.println("Name: " + s.name);
                System.out.println("Password: " + s.password);
                System.out.println();
            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}