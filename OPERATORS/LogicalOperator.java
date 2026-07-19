public class LogicalOperator {
    /*
    
    Logical operator is used to check the logical relation between the conditions

    (condition 1) && (condition 2) : both condition must be true so it will execute only then 
    (condition 1) || (condition 2) : any one condition must be true so it will execute only then

    
    
    
    */
    public static void main(String[] args) {

    boolean isAuth = true;
    String role  = "admin";
    int age = 45;



    System.out.println((isAuth==true) && (age>18));
    System.out.println((role=="admin") || (age<18));

        
    }
}
