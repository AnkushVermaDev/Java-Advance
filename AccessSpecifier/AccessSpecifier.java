package basic.AccessSpecifier;


class Bank{
    private int amount=100;


    /*
        first level:>

        methods allows:>> public , private , protected
        static allowed
    
    
    */

    private void privatemsg(){
        System.out.println("private msg");
    }

    public void display(){
        System.out.println(amount);
    }
    public void setAmount(int amount){
        this.amount+=amount;
    }

    public static void usercontrol(){
        System.out.println("static method called of Bank class");
    }


    protected void printer(){  // confustion when to use it ?????
        System.out.println("protected method called");
    }
}





public class AccessSpecifier {    
    public static void main(String[] args) {
    Bank user  = new Bank();
    user.setAmount(100);
    user.display();
    user.printer();   // ✅ Allowed (same package) if out of package try to access shows error
    // user.privatemsg();  since its private in class running it will cause error
    Bank.usercontrol();


    }
}
