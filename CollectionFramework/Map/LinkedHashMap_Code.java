package CollectionFramework.Map;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMap_Code {

    public static void main(String[] args) {

        // LinkedHashMap with:
        // Initial Capacity = 3
        // Load Factor = 0.75
        // Access Order = true
        LinkedHashMap<String, Integer> map =
                new LinkedHashMap<String, Integer>(3, 0.75f, true) {

                    @Override
                    protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest) {
                        // Keep only the latest 3 entries
                        return size() > 3;
                    }
                };

        System.out.println("======== INSERTION ========");

        map.put("A", 1);
        System.out.println(map);

        map.put("B", 2);
        System.out.println(map);

        map.put("C", 3);
        System.out.println(map);

        // Capacity exceeded -> A removed automatically
        map.put("D", 4);
        System.out.println(map);

        // Capacity exceeded -> B removed automatically
        map.put("E", 5);
        System.out.println(map);

        System.out.println("\n======== ACCESS ORDER ========");

        System.out.println("Accessing C");
        map.get("C");
        System.out.println(map);

        System.out.println("Accessing D");
        map.get("D");
        System.out.println(map);

        System.out.println("Accessing E");
        map.get("E");
        System.out.println(map);

        System.out.println("\n======== INSERT AGAIN ========");

        // Eldest (least recently used) entry is removed
        map.put("F", 6);
        System.out.println(map);

        map.put("G", 7);
        System.out.println(map);

        System.out.println("\n======== ITERATION ========");

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println("\n======== METHODS ========");

        System.out.println("Contains Key F : " + map.containsKey("F"));
        System.out.println("Contains Value 7 : " + map.containsValue(7));
        System.out.println("Size : " + map.size());
        System.out.println("Keys : " + map.keySet());
        System.out.println("Values : " + map.values());
        System.out.println("Entries : " + map.entrySet());

        System.out.println("\n======== REMOVE ========");

        map.remove("F");
        System.out.println(map);

        System.out.println("\n======== CLEAR ========");

        map.clear();
        System.out.println("Is Empty : " + map.isEmpty());
    }
}