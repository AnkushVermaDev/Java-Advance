package basic.Packages;

import basic.Packages.secured_file.secured_pkg;

public class public_pkg {

    public static void main(String[] args) {

        secured_pkg obj = new secured_pkg();

        obj.showMarks();          // ✅ public
        obj.showBankAccount();    // ✅ public

        // ❌ ERROR
        // obj.addMarks(20);
        // addMarks(int) has protected access in StudentResult

        // ❌ ERROR
        // obj.secretMessage();
        // secretMessage() has private access in StudentResult
    }
}