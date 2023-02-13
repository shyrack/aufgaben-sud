package sud.aufgaben.recursion;

import java.math.BigInteger;

public class Faculty {

    public static BigInteger bigIterativeFaculty(long n) {
        BigInteger sum = new BigInteger("1");
        for (long i = n; i > 1; i--) {
            sum = sum.multiply(new BigInteger(String.valueOf(n)));
            System.out.println(Math.floor(1.0 * (n - i) / n * 100) + "%");
        }
        return sum;
    }

    public static long iterativeFaculty(long n) {
        long sum = 1;
        for (long i = n; i > 1; i--) {
            sum *= i;
        }
        return sum;
    }

    public static long recursiveFaculty(long n) {
        if (n > 1) {
            return n * recursiveFaculty(n - 1);
        }
        return n;
    }

    public static void main(String[] args) {
        System.out.println(bigIterativeFaculty(1000000));
    }

}
