import java.lang.annotation.*;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface NotBlank { }

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

class SignupForm {
    @NotBlank @MaxLength(20) String username;
    @NotBlank @MaxLength(30) String email;
    @NotBlank @MaxLength(15) String password;

    SignupForm(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}

class Validator {
    public static boolean validate(Object obj) {
        boolean isValid = true;
        Field[] fields = obj.getClass().getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            try {
                String value = (String) field.get(obj);

                if (field.isAnnotationPresent(NotBlank.class)) {
                    if (value == null || value.trim().isEmpty()) {
                        System.out.println(field.getName() + " cannot be blank");
                        isValid = false;
                    }
                }

                if (field.isAnnotationPresent(MaxLength.class)) {
                    MaxLength max = field.getAnnotation(MaxLength.class);
                    if (value != null && value.length() > max.value()) {
                        System.out.println(field.getName() + " must be at most " + max.value() + " characters");
                        isValid = false;
                    }
                }
            } catch (Exception e) {
                System.out.println("Error checking " + field.getName());
                isValid = false;
            }
        }
        return isValid;
    }
}


public class ValidatorMain {
    public static void main(String[] args) {
        SignupForm form = new SignupForm(
            "jeel", 
            "jkjk@gmail.com", 
            "123063qaad"
        );

        boolean isValid = Validator.validate(form);
        
        if (isValid) {
            System.out.println("Form is valid");
        }
    }
}