interface Switchable {
    void on();
    void off();

    default void toggle() {
        on();
    }
}

class Fan implements Switchable {
    public void on() {
        System.out.println("fan is on");
    }

    public void off() {
        System.out.println("fan is off");
    }
}

class Light implements Switchable {
    public void on() {
        System.out.println("light is on");
    }

    public void off() {
        System.out.println("light is off");
    }
}

@FunctionalInterface
interface Permission {
    boolean maySwitchOn(Switchable device, int hour);
}

public class Remote {
    public static void main(String[] args) {
        Switchable[] dev = {
            new Fan(),
            new Light()
        };

        for (Switchable d : dev) {
            d.toggle();
        }

        Permission p1 = new Permission() {
            public boolean maySwitchOn(Switchable device, int hour) {
                return hour >= 6 && hour <= 22;
            }
        };

        Permission p2 = (device, hour) -> hour >= 6 && hour <= 22;

        System.out.println("Anonymous class at 10AM: " +
                p1.maySwitchOn(dev[0], 10));

        System.out.println("Lambda at 12PM: " +
                p2.maySwitchOn(dev[1], 24));
    }
}