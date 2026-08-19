class MyResource implements AutoCloseable {

    public MyResource() {
        System.out.println("Resource opened.");
    }

    public void use() {
        System.out.println("Using resource...");
        throw new RuntimeException("Original error: Something went wrong!");
    }

    @Override
    public void close() {
        System.out.println("Resource closed automatically.");
    }
}

public class Closeable{
    public static void main(String[] args) {

        try (MyResource resource = new MyResource()) {

            resource.use();

        } catch (Exception e) {

            System.out.println("Exception caught: " + e.getMessage());
        }

        System.out.println("Program continues normally.");
    }
}