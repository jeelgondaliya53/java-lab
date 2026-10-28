class Box<T> {
    private T value;

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }
}

class Pair<A, B> {
    private A first;
    private B second;

    Pair(A first, B second) {
        this.first = first;
        this.second = second;
    }

    public void display() {
        System.out.println(first + " - " + second);
    }
}

public class GenericContainers {

    public static <T> T first(T[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }
        return array[0];
    }

    public static void main(String[] args) {
        Box<Integer> intBox = new Box<>();
        intBox.set(100);
        System.out.println("Box value: " + intBox.get());

        Box<String> strBox = new Box<>();
        strBox.set("Java Generics");
        System.out.println("Box value: " + strBox.get());

        Pair<String, Integer> pair =
            new Pair<>("Jeel", 20);
        pair.display();

        String[] names = {"Jeel", "Riya", "Aman"};
        System.out.println("First element: " + first(names));

        Integer[] numbers = {10, 20, 30};
        System.out.println("First number: " + first(numbers));
    }
}