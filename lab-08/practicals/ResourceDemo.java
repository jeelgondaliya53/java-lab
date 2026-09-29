class FileResource implements AutoCloseable {

    public FileResource() {
        System.out.println("Resource opened");
    }

    public void use() {
        System.out.println("Using resource");
        throw new RuntimeException("Original error inside try block");
    }

    @Override
    public void close() {
        System.out.println("Resource closed");
    }
}

public class ResourceDemo {

    public static void main(String[] args) {

        try (FileResource resource = new FileResource()) {
            resource.use();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}