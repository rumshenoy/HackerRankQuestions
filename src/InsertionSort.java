import java.io.*;
import java.util.*;

public class InsertionSort {

    public static void insertionSortPart2(int[] ar)
    {
        // Fill up the code for the required logic here
        // Manipulate the array as required
        // The code for Input/Output is already provided

        /*
        1 4 3 5 6 2
        1 3 4 5 6 2
        1 3 4 5 6 2
        1 3 4 5 6 2
        1 2 3 4 5 6 */
        int start = ar.length;
        int i, j;
        for(i=1; i <ar.length; i++){
            int key = ar[i];
            j = i-1;
            while((j >=0) && ar[j] > key){
                ar[j+1] = ar[j];
                j--;
            }
            ar[j+1] = key;
            printArray(ar);
        }

    }



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
        for(int i=0;i<s;i++){
            ar[i]=in.nextInt();
        }
        insertionSortPart2(ar);

    }
    private static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
        System.out.println("");
    }
}
