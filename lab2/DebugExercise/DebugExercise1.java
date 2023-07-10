package DebugExercise;

/**
 * Exercise for learning how the debug, breakpoint, and step-into
 * feature work.
 */
public class DebugExercise1 {
    public static double divideThenRound(int top, int bottom) {
        double quotient = (double) top / (double) bottom;
        double result = Math.round(quotient);
        return result;
    }

    public static void main(String[] args) {
        int t = 10;
        int b = 2;
        int result = (int) divideThenRound(t, b);
        System.out.println("round(" + t + "/" + b + ")=" + result);

        int t2 = 9;
        int b2 = 4;
        int result2 = (int) divideThenRound(t2, b2);
        System.out.println("round(" + t2 + "/" + b2 + ")=" + result2);

        int t3 = 3;
        int b3 = 4;
        int result3 = (int) divideThenRound(t3, b3);
        System.out.println("round(" + t3 + "/" + b3 + ")=" + result3);
    }
}
