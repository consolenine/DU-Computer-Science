// Create a two dimensional array to store 1's in upper left diagonal and 0's in rest of the cells, 
// similarly write functions for other three combinations (upper, right), (lower, left) and (lower, right).
import java.util.*;

public class P15 {
    static void printArray(int a[][]) {
        for (int[] i: a) {
            for (int j: i) {
                System.out.print(" "+j);
            }
            System.out.println();
        }
    }
    static void upperLeft(int size) {
        int array[][] = new int[size][size];
        System.out.println("Upper Left-------");
        for (int i = 0; i < (size/2) + (size % 2 == 0 ? 0 : 1); i++) {
            for (int j = 0; j < (size/2) + (size % 2 == 0 ? 0 : 1); j++) {
                if (i == j) {
                    array[i][j] = 1;
                }
                
            }
        }
        printArray(array);
    }
    static void upperRight(int size) {
        int array[][] = new int[size][size];
        System.out.println("Upper Right-------");
        for (int i = 0; i < (size/2) + (size % 2 == 0 ? 0 : 1); i++) {
            for (int j = (size/2); j < size; j++) {
                if ((i+j) == (size-1)) {
                    array[i][j] = 1;
                }
                
            }
        }
        printArray(array);
    }
    static void lowerLeft(int size) {
        int array[][] = new int[size][size];
        System.out.println("Lower Left-------");
        for (int i = (size/2); i < size; i++) {
            for (int j = 0; j < (size/2) + (size % 2 == 0 ? 0 : 1); j++) {
                if ((i+j) == (size-1)) {
                    array[i][j] = 1;
                }
                
            }
        }
        printArray(array);
    }
    static void lowerRight(int size) {
        int array[][] = new int[size][size];
        System.out.println("Lower Right-------");
        for (int i = (size/2); i < size; i++ ) {
            for (int j = (size/2); j < size; j++) {
                if (i == j) {
                    array[i][j] = 1;
                }
                
            }
        }
        printArray(array);
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter dimension of square matrix: ");
        int s = in.nextInt();

        upperLeft(s);
        upperRight(s);
        lowerLeft(s);
        lowerRight(s);
        
    }
}
