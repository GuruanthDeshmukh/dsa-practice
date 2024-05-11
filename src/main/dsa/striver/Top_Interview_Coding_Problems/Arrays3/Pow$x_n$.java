package src.main.dsa.striver.Top_Interview_Coding_Problems.Arrays3;

public class Pow$x_n$ {
    public static void main(String[] args) {
        System.out.println(myPow(2.00000,10));
    }

    public static double myPow(double x, int n) {
        return findPower(x, n);
    }

    private static double findPower(double x, long n) {

        if (1 == n)
            return x;

        double finalProduct = 1.00000d;

        if (0 == n)
            return finalProduct;

        double product = findPower(x, Math.abs(n)/2);
        if(Math.abs(n) % 2 ==0) {
            finalProduct = product * product;
        } else {
            finalProduct = x * product * product;
        }

        if (n > 0)
            return finalProduct;
        else
            return 1 / finalProduct;
    }
}
