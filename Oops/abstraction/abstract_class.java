package Oops.abstraction;


// Abstract Class

abstract class Animal {

    // Instance Variable
    String name = "Animal";

    // Constructor
    Animal() {
        System.out.println("Animal Constructor Called");
    }

    // Abstract Method (No Body)
    abstract void sound();

    // Concrete Method
    void eat() {
        System.out.println("Animal is eating.");
    }

    // Concrete Method
    void sleep() {
        System.out.println("Animal is sleeping.");
    }

    // Static Method
    static void info() {
        System.out.println("Animals are living organisms.");
    }
}

// Child Class
class Dog extends Animal {

    // Constructor
    Dog() {
        System.out.println("Dog Constructor Called");
    }

    // Implementing Abstract Method
    @Override
    void sound() {
        System.out.println("Dog barks.");
    }

    // Child Class Method
    void display() {
        System.out.println("Name : " + name);
    }
}

public class abstract_class {
    public static void main(String[] args) {

        // Parent Reference - Child Object
        Animal obj = new Dog();

        System.out.println();

        obj.sound();
        obj.eat();
        obj.sleep();

        System.out.println();

        Animal.info();

        System.out.println();

        Dog d = new Dog();
        d.display();
        
    }
}