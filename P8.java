// WAP to calculate GCD of two numbers.
import java.util.Scanner;

public class P8 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int n1 = in.nextInt();

        System.out.print("Enter second number: ");
        int n2 = in.nextInt();
        
        int gcd = 1;

        for (int i = 1; i <= n1 && i <= n2; ++i) {
            if (n1 % i == 0 && n2 % i == 0) {
                gcd = i;
            }      
        }
        System.out.println("GCD of " + n1 +" and " + n2 + " is " + gcd);
        }
}
