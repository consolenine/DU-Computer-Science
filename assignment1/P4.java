//Write functions to find combination and permutation for given n and r.
import java.util.*;

public class P4 {
    static int findFact(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
        //return n == 1 ? 1 : n * findFact(n - 1);
    }
    static int permutation(int n, int r) {
        return findFact(n) / findFact(n - r);
    }
    static int combination(int n, int r) {
        return findFact(n) / (findFact(n - r) * findFact(r));
    }
    public static void main(String args[]) {
        int n, r, nPr, nCr;
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the value of n: ");
        n = in.nextInt();
        System.out.print("Enter the value of r: ");
        r = in.nextInt();
        if (r > n) {System.out.print("r needs to be smaller than n! Exiting"); System.exit(-1);}
        nPr = permutation(n, r);
        nCr = combination(n, r);

        System.out.println("Permutation: "+ nPr);
        System.out.println("Combination: "+ nCr);
    } 
}
