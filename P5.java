// Write a function that checks whether a given string is Palindrome or not. Use this function to
// find whether the string entered by user is Palindrome or not.
import java.util.*;

public class P5 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = in.next();
        int flag = 0;
        
        for(int i=0; i < str.length(); i++){
            if(str.charAt(i) != str.charAt(str.length()-i-1)){
                flag = 1;
                break;
            }
        }
        
        if (flag != 0) {
            System.out.println(str + " is not a palindrome");
        }    
        else {
            System.out.println(str + " is a palindrome"); 
        }
    }
}
