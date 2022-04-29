// WAP to find mean, variance and Standard Deviation for given n numbers.
import java.util.*;

public class P10 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter count of total numbers: ");
        int count = in.nextInt();
        int[] array = new int[count];
        for (int i = 0; i < count; i++) {
            System.out.print("Enter number: ");
            array[i] = in.nextInt();
        }

        int sum = 0;
        for (int i: array) {
            sum += i;
        }
        float mean = (float) sum / count;
        System.out.println("Mean of given numbers is: "+mean);

        double vSum = 0;
        for (double i: array) {
            vSum += Math.pow((i - (double) mean), 2.0);
        }
        double variance = vSum / count;
        System.out.println("Variance of given numbers is: "+variance);

        //Standar Deviation
        double stdDev = Math.sqrt(variance);
        System.out.println("Standard deviation of given numbers is: "+stdDev);
    }
}
