// Public Interface
public interface PublicInterface {

    // Constant (public static final by default)
    int CONSTANT = 100;

    // Abstract Method (public abstract by default)
    void abstractMethod();

    // Default Method
    default void defaultMethod() {
        System.out.println("This is a default method.");
    }

    // Static Method
    static void staticMethod() {
        System.out.println("This is a static method.");
    }

    // Private Method (Java 9+)
    private void privateHelper() {
        System.out.println("This is a private helper method.");
    }

    // Default method calling private method
    default void callPrivateHelper() {
        privateHelper();
    }
}

class DemoClass implements PublicInterface {

    @Override
    public void abstractMethod() {
        System.out.println("Abstract method implemented.");
    }
}