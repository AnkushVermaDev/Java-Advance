package CollectionFramework.Iterable;

import java.util.ArrayList;
import java.util.Iterator;

public class iteratorDemo {
    public static void main(String[] args) {
         ArrayList<String> cars = new ArrayList<String>();
         cars.add("Volvo");
         cars.add("BMW");
         cars.add("Ford");
         cars.add("Mazda");


         Iterator<String> looping  = cars.iterator();

         while (looping.hasNext()) {
            System.out.println(looping.next());
         }

    }
    
}
