package Generics;

// T mean type 

class Generics<T>{

    private T value;
    
    void getValue(){
        System.out.println(value);
    }

    void setvalue(T value){
        this.value=value;
    }
}

public class BasicGeneric {
    public static void main(String[] args) {

        Generics<Integer>  object  = new Generics<>();
        object.setvalue(12);
        object.getValue();


        Generics<String>  object2  = new Generics<>();
        object2.setvalue("hellow world");
        object2.getValue();



    }
}
