import java.util.ArrayList;
import java.util.List;


// ? super Integer :>> any object which is equal to integer or superclass of it

public class SuperGeneric {

    public static void addNumbers(List<? super Integer> list) {
        list.add(10);
        list.add(20);
        list.add(30);

        System.out.println(list);
    }

    public static void main(String[] args) {

        List<Integer> intList = new ArrayList<>();
        List<Number> numList = new ArrayList<>();
        List<Object> objList = new ArrayList<>();

        addNumbers(intList);   // Works
        addNumbers(numList);   // Works
        addNumbers(objList);   // Works
    }
}