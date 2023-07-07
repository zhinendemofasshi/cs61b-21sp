public class fib{
    public static int fib(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }
    public static int fib2(int n, int k, int f0, int f1) {
        if (n == k) {
            return f0;
        }
        return fib2(n, k + 1, f1, f0 + f1);
    }
    public static void main(String[] args) {
        int n = 5;
        System.out.println(fib2(n, 0, 0, 1));
    }
}
