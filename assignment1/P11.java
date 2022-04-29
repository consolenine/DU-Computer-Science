// Write a program to convert a x (Base 10) number to Binary (Base 2) number
import java.util.*;

public class P11 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a deciaml number: ");
        int x = in.nextInt();

        System.out.print("Binary of "+x+" is: ");
        int binary[] = new int[64];    
        int index = 0;    
        while(x > 0) {    
            binary[index++] = x%2;    
            x = x/2;    
        }    
        for(int i = index-1;i >= 0;i--) {    
            System.out.print(binary[i]);    
        }    
        System.out.println();

    }
}
