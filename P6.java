// Write a function to find whether a given number is prime or not. Use the same to generate
// i) first n prime numbers
// ii) prime numbers up to n
// iii) n prime numbers starting from m1
import java.util.*;

public class P6 {
    static boolean checkPrime(int n) {
        if (n <= 1) {
            return false;
        }    
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }       
        }
        return true;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter value of n: ");
        int n = in.nextInt();
        System.out.print("Enter value of m1: ");
        int m1 = in.nextInt();
        int count = 0;

        System.out.print("First "+n+" prime numbers: ");
        for (int i = 2; count < n; i++) {
            if (checkPrime(i)) {
                System.out.print(i+" ");
                count++;
            }
            
        }

        System.out.print("\nPrime number upto "+n+": ");
        for (int i = 2; i < n; i++) {
            if (checkPrime(i)) {
                System.out.print(i+" ");
            }
        }

        System.out.print("\n"+n+" prime number starting from "+m1+": ");
        count  = 0;
        for (int i = m1; count < n; i++) {
            if (checkPrime(i)) {
                System.out.print(i+" ");
                count++;
            }
        }

    }
}
