class Generic<T extends  Number>{

    private T value1;

    void getresult(){
        System.out.println(value1);
    }

    void setvalue(T value1){
        this.value1=value1;
    }
}


public class RestrictGenericType {
    public static void main(String[] args) {
        Generic<Integer> object  = new Generic<>();
        // Generic<String> object  = new Generic<>(); // it will show error
        object.setvalue(12);
        object.getresult();
    }
}
