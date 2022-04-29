//WAP to print a triangle of stars as follows (take number of lines from user):
import java.util.*;

public class P12 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter odd number of lines: ");
        int n = in.nextInt();
        if (n%2 == 0) {
            System.out.println("Please enter an odd number!");
            System.exit(-1);
        }

        System.out.print("\n");
        //     *
        //    ***
        //   *****
        //  *******
        // *********
        int spaces = n-1;
        System.out.println("First pattern: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < spaces; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < (i*2)+1; j++) {
                System.out.print("*");
            }
            --spaces;
            System.out.println();
        }
        System.out.print("\n");

        // *
        // **
        // ***
        // ****
        // *****
        System.out.println("Second pattern: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.print("\n");

        // *
        // **
        // ***
        // ****
        // *****
        System.out.println("Third pattern: ");
        spaces = n-1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < spaces; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            --spaces;
            System.out.println();
        }
        System.out.println();

        //     *
        //    ***
        //   *****
        //  *******
        //   *****
        //    ***
        //     *
        System.out.println("Fourth pattern: ");
        spaces = n/2;
        for (int i = 0; i < n/2; i++) {
            for (int j = 0; j < spaces; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < (i*2)+1; j++) {
                System.out.print("*");
            }
            --spaces;
            System.out.println();
        }
        spaces = 0;
        for (int i = (n/2)+1; i <= n; i++) {
            for (int j = 0; j < spaces; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < ((n-i)*2)+1; j++) {
                System.out.print("*");
            }
            ++spaces;
            System.out.println();
        }
        System.out.println();

        //      1
        //     121
        //    12321
        //   1234321
        //  123454321
        // 12345654321
        System.out.println("Fifth pattern: ");
        spaces = n-1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < spaces; j++) {
                System.out.print(" ");
            }
            int num = 0;
            for (int j = 0; j < (i*2)+1; j++) {
                if (j < i+1) num++;
                else num--;
                System.out.print(num);
            }
            spaces--;
            System.out.println();
        }
        System.out.println();
        //      1
        //     1 1
        //    1 2 1
        //   1 3 3 1
        //  1 4 6 4 1
        // 1 5 10 10 5 1
        System.out.println("Sixth Pattern: ");
        for (int line = 1; line <= n; line++) {
            for (int j = 0; j <= n - line; j++) {
                System.out.print(" ");
            }
 
            int c = 1;
            for (int i = 1; i <= line; i++) {
                System.out.print(c + " ");
                c = c * (line - i) / i;
            }
            System.out.println();
        }
        System.out.println();

        // ABCDEFGHI
        // ABCD FGHI
        // ABC   GHI
        // AB     HI
        // A       I
        System.out.println("Seventh Pattern: ");
        int alphabet = 65;    
        for(int i=0; i<n; i++) {
            for (int j = 0; j < n+4; j++) {
                if (j < n+i-1 & j > n-i-1) {
                    System.out.print(" ");
                }
                else System.out.print((char) (alphabet+j));
            }
            System.out.println();
        }
    }
}
