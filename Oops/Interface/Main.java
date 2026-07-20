public class Main {

    public static void main(String[] args) {

        // Interface reference pointing to implementation object
        PublicInterface obj = new DemoClass();

        // Calling Abstract Method
        obj.abstractMethod();

        // Calling Default Method
        obj.defaultMethod();

        // Calling Default Method that internally calls Private Method
        obj.callPrivateHelper();

        // Calling Static Method
        PublicInterface.staticMethod();

        // Accessing Constant
        System.out.println("Constant = " + PublicInterface.CONSTANT);

        // Not Allowed
        // obj.staticMethod();       // ❌ Static methods belong to the interface
        // obj.privateHelper();      // ❌ Private methods are accessible only inside the interface
        // PublicInterface.CONSTANT = 200; // ❌ final variable
    }
}