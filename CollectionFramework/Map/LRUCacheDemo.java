package CollectionFramework.Map;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheDemo {

    public static void main(String[] args) {

        // Capacity = 3
        LinkedHashMap<String, Integer> cache =
                new LinkedHashMap<String, Integer>(16, 0.75f, true) {

                    @Override
                    protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest) {
                        return size() > 3;
                    }
                };

        // Add elements
        cache.put("A", 1);
        cache.put("B", 2);
        cache.put("C", 3);

        System.out.println("After adding A, B, C");
        System.out.println(cache);

        // Access B
        cache.get("B");

        System.out.println("\nAfter get(B)");
        System.out.println(cache);

        // Add D
        cache.put("D", 4);

        System.out.println("\nAfter put(D)");
        System.out.println(cache);

        // Access C
        cache.get("C");

        System.out.println("\nAfter get(C)");
        System.out.println(cache);

        // Add E
        cache.put("E", 5);

        System.out.println("\nAfter put(E)");
        System.out.println(cache);
    }
}