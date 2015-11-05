import java.util.Scanner;

/**
 * Created by ramya.shenoy on 10/23/15.
 */
public class MaxMin {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int T = sc.nextInt();
        int k =0;
        int[] a = new int[N];
        while(k < N){
            a[k] = sc.nextInt();
            k++;
        }

        while(T-- > 0){
            int i = sc.nextInt();
            int j = sc.nextInt();

            int min = a[i];
            while(i <=j){
                if(a[i] < min){
                    min = a[i];
                }
                i++;
            }

            System.out.println(min);
        }
    }
}
