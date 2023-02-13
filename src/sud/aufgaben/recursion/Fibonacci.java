package sud.aufgaben.recursion;

public class Fibonacci {

    public static void startFibonacci(int n) {
        Fibonacci.fibonacci(n, 0, 1);
    }

    private static void fibonacci(int n, long a, long b) {
        if (n == 0) {
            System.out.println(a);
        } else {
            fibonacci(n - 1, b, a + b);
        }
    }

    public static void main(String[] args) {
        Fibonacci.startFibonacci(10);
    }

}
