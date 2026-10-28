import java.util.NoSuchElementException;

class Stack<T> {
    private Object[] elements;
    private int top;

    Stack(int capacity) {
        elements = new Object[capacity];
        top = -1;
    }

    public void push(T value) {
        if (top == elements.length - 1) {
            throw new IllegalStateException("Stack is full");
        }
        elements[++top] = value;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if (top == -1) {
            throw new NoSuchElementException("Stack is empty");
        }
        T value = (T) elements[top];
        elements[top--] = null;
        return value;
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if (top == -1) {
            throw new NoSuchElementException("Stack is empty");
        }
        return (T) elements[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }
}

public class GenericStack {
    public static void main(String[] args) {
        Stack<Integer> numbers = new Stack<>(5);
        numbers.push(10);
        numbers.push(20);

        System.out.println("Integer top: " + numbers.peek());
        System.out.println("Popped: " + numbers.pop());

        Stack<String> names = new Stack<>(5);
        names.push("Jeel");
        names.push("Riya");

        System.out.println("String top: " + names.peek());
        System.out.println("Popped: " + names.pop());

        System.out.println("Stack empty: " + names.isEmpty());
    }
}