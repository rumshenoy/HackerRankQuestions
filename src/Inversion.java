import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by ramya.shenoy on 10/13/15.
 */
public class Inversion {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("src/shouldBe56.txt"));
        int [] input = new int[15];
        int i = 0;
        while(scanner.hasNextInt()){
            input[i++] = scanner.nextInt();
        }
        int[] o = countInversions(input, 0, 15);
        for(i=0; i<15; i++){
            System.out.println(o[i]);
        }
    }

    private static int[] countInversions(int[] array, int left, int right) {
        if(left == right || right >left){
            return array;
        }else{
            int mid = (left+right)/2;
            int[] firstHalf = countInversions(array , left, mid);
            int[] secondHalf = countInversions(array, mid+1, right);
            return merge(array, left, mid, right);
        }
    }

    private static int[] merge(int[] array, int left, int mid, int right) {
        int i = left;
        int j = mid;
        int k=0;
        int n = right - left;
        int[] tmp = new int[n];

        while(i <= mid && j < right){
            if(array[i] < array[j]){
                 tmp[k++] = array[i++];
            }else{
                tmp[k++] = array[j++];
            }
        }

        while(i <=mid){
            tmp[k++] = array[i++];
        }

        while(j < right){
            tmp[k++] = array[j++];
        }

        for(i=0; i < n; i++){
            array[left+i] = tmp[i];
        }
        return array;
    }
}
