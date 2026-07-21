
class Generics<T , U>{

    private T value1;
    private U value2;

    void getresult(){
        System.out.println(value1+" " +value2);
    }

    void setvalue(T value1,U value2){
        this.value1=value1;
        this.value2=value2;
    }
}

public class MultipleGenerics {
    public static void main(String[] args) {
        Generics<Integer,String> object  = new Generics<>();
        object.setvalue(12, "hellow");
        object.getresult();
    
    }

}
