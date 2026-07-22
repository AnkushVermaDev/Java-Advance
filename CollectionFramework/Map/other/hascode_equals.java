package other;

import java.util.Objects;

class A {
    int age;

    void setAge(int age) {
        this.age = age;
    }

    int getAge() {
        return age;
    }
}

class B {
    int age;

    void setAge(int age) {
        this.age = age;
    }

    int getAge() {
        return age;
    }

    // Override equals() to compare age values
    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        B other = (B) obj;
        return age == other.age;
    }

    // Whenever equals() is overridden, hashCode() should also be overridden.
    @Override
    public int hashCode() {
        return Objects.hash(age);
    }
}

public class hascode_equals {

    public static void main(String[] args) {

        // -----------------------------------------------------
        // equals() inherited from Object
        // -----------------------------------------------------

        A obj1 = new A();
        A obj2 = new A();

        obj1.setAge(20);
        obj2.setAge(20);

        System.out.println("===== Object class equals() =====");

        System.out.println(obj1.equals(obj1)); // true
        System.out.println(obj1.equals(obj2)); // false

        System.out.println();

        // -----------------------------------------------------
        // == with primitives
        // -----------------------------------------------------

        System.out.println("===== == with primitives =====");

        System.out.println(5 == 5);      // true
        System.out.println(5 == 10);     // false

        System.out.println();

        // -----------------------------------------------------
        // == with objects
        // -----------------------------------------------------

        System.out.println("===== == with objects =====");

        String s1 = new String("akash");
        String s2 = new String("akash");

        System.out.println(s1 == s2); // false

        System.out.println();

        // -----------------------------------------------------
        // equals() with String
        // -----------------------------------------------------

        System.out.println("===== equals() with String =====");

        System.out.println(s1.equals(s2)); // true

        System.out.println();

        // -----------------------------------------------------
        // String Pool
        // -----------------------------------------------------

        System.out.println("===== String Pool =====");

        String s3 = "akash";
        String s4 = "akash";

        System.out.println(s3 == s4);       // true
        System.out.println(s3.equals(s4));  // true

        System.out.println();

        // -----------------------------------------------------
        // Custom class overriding equals()
        // -----------------------------------------------------

        B b1 = new B();
        B b2 = new B();

        b1.setAge(25);
        b2.setAge(25);

        System.out.println("===== Custom equals() =====");

        System.out.println(b1 == b2);       // false
        System.out.println(b1.equals(b2));  // true

        System.out.println();

        // -----------------------------------------------------
        // hashCode()
        // -----------------------------------------------------

        System.out.println("===== hashCode() =====");

        System.out.println("b1 hashCode : " + b1.hashCode());
        System.out.println("b2 hashCode : " + b2.hashCode());

        System.out.println("Same hashCode? " + (b1.hashCode() == b2.hashCode()));

    }
}