package basic.TypeConversion;



public class WrapperClass {

    public static void main(String[] args) {

        System.out.println("========== WRAPPER CLASS EXAMPLES ==========\n");

        // ---------------------------------------------------------------------
        // 1. Primitive Data Type
        // ---------------------------------------------------------------------
        int primitiveInt = 12;
        System.out.println("Primitive int : " + primitiveInt);

        // ---------------------------------------------------------------------
        // 2. Boxing (Primitive -> Wrapper Object)
        // ---------------------------------------------------------------------
        Integer intWrapper = Integer.valueOf(primitiveInt);
        System.out.println("Wrapper Object : " + intWrapper);

        // ---------------------------------------------------------------------
        // 3. Unboxing (Wrapper Object -> Primitive)
        // ---------------------------------------------------------------------
        int primitiveAgain = intWrapper.intValue();
        System.out.println("Primitive Again : " + primitiveAgain);

        // ---------------------------------------------------------------------
        // 4. Autoboxing
        // ---------------------------------------------------------------------
        Integer autoBox = primitiveInt;
        System.out.println("Autoboxing : " + autoBox);

        // ---------------------------------------------------------------------
        // 5. Auto-Unboxing
        // ---------------------------------------------------------------------
        int autoUnbox = autoBox;
        System.out.println("Auto Unboxing : " + autoUnbox);

        // ---------------------------------------------------------------------
        // 6. String to Primitive
        // Integer.parseInt() :>> Meaning: Converts a String into a primitive int.
        // ---------------------------------------------------------------------
        String number = "250";
        int converted = Integer.parseInt(number);
        System.out.println("String to int : " + converted);

        // ---------------------------------------------------------------------
        // 7. String to Wrapper Object
        // ---------------------------------------------------------------------
        Integer wrapperFromString = Integer.valueOf(number);
        System.out.println("String to Integer : " + wrapperFromString);

        // ---------------------------------------------------------------------
        // 8. Primitive to String
        // ---------------------------------------------------------------------
        String stringNumber = Integer.toString(primitiveInt);
        System.out.println("Primitive to String : " + stringNumber);

        // ---------------------------------------------------------------------
        // 9. Integer.MAX_VALUE
        // ---------------------------------------------------------------------
        System.out.println("Maximum int value : " + Integer.MAX_VALUE);

        // ---------------------------------------------------------------------
        // 10. Integer.MIN_VALUE
        // ---------------------------------------------------------------------
        System.out.println("Minimum int value : " + Integer.MIN_VALUE);

        // ---------------------------------------------------------------------
        // 11. Compare two numbers
        // ---------------------------------------------------------------------
        int compare = Integer.compare(10, 20);
        System.out.println("Compare 10 and 20 : " + compare);

        // ---------------------------------------------------------------------
        // 12. Sum
        // ---------------------------------------------------------------------
        int sum = Integer.sum(15, 25);
        System.out.println("Sum : " + sum);

        // ---------------------------------------------------------------------
        // 13. Wrapper can store null
        // ---------------------------------------------------------------------
        Integer nullable = null;
        System.out.println("Wrapper can store null : " + nullable);

        // ---------------------------------------------------------------------
        // 14. Primitive cannot store null
        // ---------------------------------------------------------------------
        // int value = null; // Compile-time Error

        System.out.println("\n========== END ==========");
    }
}