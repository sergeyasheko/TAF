public class Calculator {
    private String title;
    private int a;
    private int b;


    public Calculator(String title) {
        this.title = title;
    }

    public int sum(int a, int b){
        return a+b;
    }

    public int div(int a, int b){
        this.a = a; this.b = b;
        return a/b;
    }

    public double divDouble(double a, double b){
       return a/b;
    }
}
