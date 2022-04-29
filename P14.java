// WAP that prints a table indicating the number of occurrences of each alphabet in the text.
// Draw horizontal and vertical histogram for the same
import java.util.*;

public class P14 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = in.next();

        int x, alphabet[] = new int[26];
        for(int i=0;i<text.length();i++) {
            if(text.charAt(i)>='A' && text.charAt(i)<='Z') {
                x=((int)text.charAt(i))-65;
                alphabet[x]++;
            }
            else if(text.charAt(i)>='a' && text.charAt(i)<='z') {
                x=((int)text.charAt(i))-97;
                alphabet[x]++;
            }
        }
    
        System.out.print("\nAlphabet No. of Occurrences\n");
        for(int i=0;i<26;i++)  {
            if (alphabet[i] != 0) {
                System.out.print("\n  " + (char)(65+i) + " " + alphabet[i]);
            }
        }
    }
}
