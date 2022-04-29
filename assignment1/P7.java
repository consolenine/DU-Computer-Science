// WAP to compute the factors and prime factors of a given number.
import java.util.*;

public class P7 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = in.nextInt();

        System.out.println("\nFactors of "+n+" are: ");
        for (int i = 1; i <= n/2; i++) {
            if (n % i == 0) {
                System.out.print(i+" ");
            }
        }

        System.out.println("\nPrime Factors of "+n+" are: ");
        for (int i = 1; i <= n/2; i++) {
            if (n % i == 0) {
                boolean isPrime = true;
                for (int j = 2; j <= i/2; j++) {
                    if (i % j == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if (isPrime) {
                    System.out.print(i+" ");
                }
            }
        }
        

    }
}
