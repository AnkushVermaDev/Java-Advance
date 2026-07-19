package basic.TypeConversion;

public class ExplicitConversion {
    /*



explicit type conversion mean convert one type to another type.
its ususally done by user and  data loss happend here.
its also called shortening type conversion.




*/
    public static void main(String[] args) {
        double double_marks = 12.6;
        int int_marks = (int) double_marks;

        System.out.println(int_marks); // result : 12
    }    
}
