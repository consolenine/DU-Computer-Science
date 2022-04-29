// WAP to print the sum and product of digits of an integer
import java.util.*;

class P1 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int x = in.nextInt();
        int sum = 0;
        int product = 1;
        while (x != 0) {
            int digit = x % 10;
            sum += digit;
            product *= digit;
            x =  x/10;
        }
        System.out.println("Sum:" + sum);
        System.out.println("Product: " + product);
    }
}