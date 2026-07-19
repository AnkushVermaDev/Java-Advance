package basic.TypeConversion;
/*

implicit type conversion mean convert one type to another type.
its ususally done by jvm during compilation time and no data loss happend here
its also called widening type conversion.




*/
public class ImplicitConverstion {
    public static void main(String[] args) {
        int age =18;
        float  floatvalue  = age;
        System.out.println(floatvalue); //18.0
        

    }
}
