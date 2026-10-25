import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Column {
    String name();
}

class Student {
    @Column(name = "name")
    String name;

    @Column(name = "age")
    int age;

    @Column(name = "city")
    String city;

    public String toString() {
        return name + " " + age + " " + city;
    }
}

public class StudentMain {
    public static void main(String[] args) throws Exception {
        String[] header = {"name", "age", "city"};
        String[] data = {"Jeel", "18", "Ahmedabad"};

        Student student = new Student();

        for (Field field : Student.class.getDeclaredFields()) {
            Column column = field.getAnnotation(Column.class);

            if (column != null) {
                String columnName = column.name();
                int index = -1;

                for (int i = 0; i < header.length; i++) {
                    if (header[i].equals(columnName)) {
                        index = i;
                        break;
                    }
                }

                if (index == -1) {
                    System.out.println("Missing column: " + columnName);
                    continue;
                }

                field.setAccessible(true);

                if (field.getType() == int.class) {
                    field.set(student, Integer.parseInt(data[index]));
                } else {
                    field.set(student, data[index]);
                }
            }
        }

        System.out.println(student);
    }
}