package basic.Packages.secured_file;

// Parent Class
class StudentResult {

    public int marks = 65;

    private int bankAccount = 12345;

    public void showMarks() {
        System.out.println("Marks: " + marks);
    }

    // Protected method
    protected void addMarks(int marks) {
        this.marks += marks;
    }

    // Public method can access private data
    public void showBankAccount() {
        System.out.println("Bank Account: " + bankAccount);
    }

    // Private method
    private void secretMessage() {
        System.out.println("This is a private method.");
    }

    // Public wrapper to call private method
    public void callSecretMessage() {
        secretMessage();
    }
}

// Teacher inherits StudentResult
class Teacher extends StudentResult {

}

// Main Class
public class secured_pkg extends Teacher {

    public static void main(String[] args) {

        secured_pkg obj = new secured_pkg();

        // Protected method
        obj.addMarks(15);          // ✅ Allowed (Inherited)

        obj.showMarks();

        // Public method
        obj.showBankAccount();

        // Calls private method internally
        obj.callSecretMessage();

        // ❌ ERROR
        // obj.secretMessage();
        // secretMessage() has private access in StudentResult
    }
}