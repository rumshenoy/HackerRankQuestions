import java.util.*;
import java.io.*;

public class CountInversions{
    public static void main(String[] args) throws FileNotFoundException {
        int[] arr = new int[100000];

        Scanner scanner = new Scanner(new File("src/IntegerArray.txt"));
        int i = 0;
        while(scanner.hasNextInt()){
            arr[i++] = scanner.nextInt();
        }
        DArray da = new DArray(arr);

        da.mergeSort();
    }
}
class DArray {
    private int[] a;
    private int nElems;

    public DArray(int[] array) {
        nElems = array.length;
        a = new int[nElems];

        for (int i = 0; i < nElems; i++)
            a[i] = array[i];
    }

    public void display() {
        for (int i = 0; i < nElems; i++)
            System.out.print(a[i] + " ");

        System.out.println("");
    }

    public void mergeSort() {
        int[] temp = new int[nElems];

        long inv_count = recMergeSort(temp, 0, nElems - 1);
        System.out.println(inv_count);
    }

    private long recMergeSort(int[] temp, int lowerBound, int upperBound) {
        long inv_count = 0;

        if (lowerBound == upperBound)
            return 0;
        else {
            int mid = (lowerBound + upperBound) / 2;

            inv_count += recMergeSort(temp, lowerBound, mid);
            inv_count += recMergeSort(temp, mid + 1, upperBound);

            inv_count += merge(temp, lowerBound, mid + 1, upperBound);
        }

        return inv_count;
    }

    private long merge(int[] temp, int lowPtr, int highPtr, int upperBound) {
        int mid = highPtr - 1;
        int lowerBound = lowPtr;

        int n = upperBound - lowerBound + 1;
        long inv_count = 0;

        int j = 0;
        while (lowPtr <= mid && highPtr <= upperBound) {
            if (a[lowPtr] <= a[highPtr]) {
                temp[j++] = a[lowPtr++];
            } else {
                temp[j++] = a[highPtr++];
                inv_count += mid - lowPtr + 1;
              /*
             if a[lowPtr]>a[highPtr], then a[lowPtr] is larger than
             all the rest elements in a[highPtr] because the two arrays
             are already sorted
             */
            }
        }

        while (lowPtr <= mid)
            temp[j++] = a[lowPtr++];

        while (highPtr <= upperBound)
            temp[j++] = a[highPtr++];

        for (j = 0; j < n; j++)
            a[lowerBound + j] = temp[j];

        return inv_count;
    }
}