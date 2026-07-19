package basic.Looping;

public class Loops {

    public static void main(String[] args) {

        // ==========================
        // FOR LOOP
        // ==========================
        System.out.println("For Loop");

        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }

        // ==========================
        // WHILE LOOP
        // ==========================
        System.out.println("\nWhile Loop");

        int iterating = 1;

        while (iterating <= 5) {
            System.out.println(iterating);
            iterating++;
        }

        // ==========================
        // DO-WHILE LOOP
        // ==========================
        System.out.println("\nDo While Loop");

        int dowhile_iterating = 1;

        do {
            System.out.println(dowhile_iterating);
            dowhile_iterating++;        // Important
        } while (dowhile_iterating <= 5);

        // ==========================
        // ENHANCED FOR LOOP (For-Each)
        // ==========================
        System.out.println("\nFor Each Loop");

        int[] car_array = {1, 2, 3, 4};

        for (int value : car_array) {
            System.out.println(value);
        }
    }
}