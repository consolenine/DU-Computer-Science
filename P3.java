// WAP to compute the sum of the first n terms of the following series

// (a) S = 1+1/2+1/3+1/4+......
// (b) S = 1 + 1/2! + 1/3! + 1/4! +......
// (c) S =1-2+3-4+5............
import java.util.*;

public class P3 {

    static float factorial(int n) {
        float fact = 1.0f;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number of terms: ");
        int n = in.nextInt();
        float s1 = 1.0f, s2 = 1.0f;
        int sign = -1, s3 = 1;
        for (float i = 2; i <= n; i++) {
            s1 += 1.0f/i;
            s2 += 1/factorial((int) i);
            s3 += sign*i;
            sign = -sign;
        }
        System.out.println("Sum of first series: "+s1);
        System.out.println("Sum of second series: "+s2);
        System.out.println("Sum of third series: "+s3);
    }
}
