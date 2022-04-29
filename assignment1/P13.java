// Write a menu driven program to perform following actions on an array entered by the user:
// i) Print the even-valued elements
// ii) Print the odd-valued elements
// iii) Calculate and print the sum and average of the elements of array
// iv) Print the maximum and minimum element of array
// v) Remove the duplicates from the array
// vi) Store and the array in reverse order without using additional array
import java.util.*;

public class P13 {
    static void printMenu() {
        System.out.println("\n1) Print the even-valued elements");
        System.out.println("2) Print the odd-valued elements");
        System.out.println("3) Calculate and print the sum and average of the elements of array");
        System.out.println("4) Print the maximum and minimum element of array");
        System.out.println("5) Remove the duplicates from the array");
        System.out.println("6) Store and the array in reverse order without using additional array");   
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number of array elements: ");
        int n = in.nextInt();
        int numArray[] = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter array element: ");
            numArray[i] = in.nextInt();
        }

        char cont = 'y';
        while (cont == 'y') {
            printMenu();
            System.out.print("Enter your choice: ");
            int choice = in.nextInt();
            switch (choice) {
                case 1: {
                    System.out.print("Even valued elements of array are: ");
                    for (int i: numArray) {
                        if (i % 2 == 0) {
                            System.out.print(" "+i);
                        }
                    }
                    System.out.println();
                    break;
                }
                case 2: {
                    System.out.print("Odd valued elements of array are: ");
                    for (int i: numArray) {
                        if (i % 2 != 0) {
                            System.out.print(" "+i);
                        }
                    }
                    System.out.println();
                    break;
                }
                case 3: {
                    int sum = 0, avg = 0;
                    System.out.print("Sum of array elements is: ");
                    for (int i: numArray) {
                        sum += i;
                    }
                    System.out.println(sum);
                    avg = sum / n;
                    System.out.print("Average of array elements is: ");
                    System.out.println(avg);
                    break;
                }
                case 4: {
                    int max = numArray[0], min = numArray[0];
                    for (int i: numArray) {
                        if (i > max) max = i;
                        if (i < min) min = i;
                    }
                    System.out.println("Maximum element is: "+max);
                    System.out.println("Minimum element is: "+min);
                    break;
                }
                case 5: {
                    int j = 0;
                    int temp[] = new int[n];
                    for (int i: numArray) {
                        boolean duplicate = false;
                        for (int k = 0; k < j; k++) {
                            if (temp[k] == i) {
                                duplicate = true;
                            }
                        }
                        if (!duplicate) {
                            temp[j++] = i;
                        }
                    }
                    numArray = new int[j];
                    for (int i = 0; i < j; i++) {
                        numArray[i] = temp[i];
                    }

                    //Printing filtered array
                    System.out.print("Duplicates removed\nNew array:");
                    for (int i: numArray) {
                        System.out.print(" "+i);
                    }
                    break;
                }
                case 6: {
                    if(numArray == null || numArray.length <= 1){
                        System.out.println("Invalid array.");
                    }
                    for (int i = 0; i < numArray.length / 2; i++) {
                        int temp = numArray[i];
                        numArray[i] = numArray[numArray.length - 1 - i];
                        numArray[numArray.length - 1 - i] = temp;
                    }
                    System.out.print("Reversed array is: ");
                    for (int i: numArray) {
                        System.out.print(" "+i);
                    }
                    break;
                }
                default: {
                    System.out.println("Invalid Choice!");
                }
            }
            System.out.print("\nDo you want to continue? Y/N");
            cont = Character.toLowerCase(in.next().charAt(0));
            if (cont == 'n') System.out.println("Exiting now.");
        }
    }
}
