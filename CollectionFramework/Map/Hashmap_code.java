import java.util.HashMap;

public class Hashmap_code {

    // Order is NOT guaranteed in HashMap.

    public static void main(String[] args) {

        HashMap<Integer, String> student = new HashMap<>();

        // ------------------------------------------
        // put()
        // ------------------------------------------

        student.put(1, "akash");
        student.put(2, "vijay");
        student.put(3, "rahul");

        System.out.println(student);

        // Duplicate key replaces old value
        student.put(2, "rupinder");

        System.out.println(student);

        // ------------------------------------------
        // get()
        // ------------------------------------------

        String value = student.get(1);
        System.out.println(value);

        // Key not present
        System.out.println(student.get(100));

        // ------------------------------------------
        // containsKey()
        // ------------------------------------------

        System.out.println(student.containsKey(2));
        System.out.println(student.containsKey(10));

        // ------------------------------------------
        // containsValue()
        // ------------------------------------------

        System.out.println(student.containsValue("akash"));
        System.out.println(student.containsValue("vijay"));

        // ------------------------------------------
        // size()
        // ------------------------------------------

        System.out.println(student.size());

        // ------------------------------------------
        // remove()
        // ------------------------------------------

        student.remove(1);

        System.out.println(student);

        // ------------------------------------------
        // keySet()
        // ------------------------------------------

        System.out.println(student.keySet());

        // ------------------------------------------
        // values()
        // ------------------------------------------

        System.out.println(student.values());

        // ------------------------------------------
        // entrySet()
        // ------------------------------------------

        System.out.println(student.entrySet());

        // ------------------------------------------
        // Traversing HashMap
        // ------------------------------------------

        for (Integer key : student.keySet()) {
            System.out.println(key + " -> " + student.get(key));
        }

        System.out.println();

        //  student.entrySet(): returns >> [1=Akash, 2=Rahul, 3=Vijay]

        for (var entry : student.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // ------------------------------------------
        // isEmpty()
        // ------------------------------------------

        System.out.println(student.isEmpty());

        // ------------------------------------------
        // clear()
        // ------------------------------------------

        student.clear();

        System.out.println(student);

        System.out.println(student.isEmpty());
    }
}