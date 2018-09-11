package tasks;

public class Recursion {
    public static void main(String[] args) {
        int n = 4;

        System.out.println(fibonacci(40));
        System.out.println(n +"! = "+factorial(n));
    }

    private static long fibonacci(int n) {
        if (n <= 1) return n;
        else return fibonacci(n - 1) + fibonacci(n - 2);
    }

    private static long factorial(int n){
        if (n <= 1) return 1;
        else return n*factorial(n - 1);
    }
}
