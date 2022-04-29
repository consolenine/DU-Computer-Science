// Write a function to print Fibonacci series and call it from main
import java.util.*;

public class P9 {
    static void fibonacci(int x) {
        int n1=0, n2=1, n3; 
        System.out.print(n1+" "+n2);
            
        for(int i=2;i<x;++i) {    
            n3=n1+n2;    
            System.out.print(" "+n3);    
            n1=n2;    
            n2=n3;    
        } 
    }
    public static void main(String args[]) {
        System.out.print("Enter number of terms for Fibonacci series: ");
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        fibonacci(count);   
    }
}