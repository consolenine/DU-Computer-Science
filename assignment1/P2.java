//WAP to reverse a number.
import java.util.*;
public class P2 {
    public static void main(String args[]) {
        int reversed = 0;
        Scanner in = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int x = in.nextInt();
        while (x != 0) {
            int digit = x % 10;
            reversed = reversed*10 + digit;
            x /= 10;
        }
        System.out.println("Reverse number is: " + reversed);
    }
}
