import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Find {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Find. */
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T >0){
            int M = sc.nextInt();
            int N = sc.nextInt();
            int[] a = new int[N];
            int i=0;
            while(i <N){
                a[i] = sc.nextInt();
                i++;
            }
            find(a, N, M);

            T--;
        }
    }

    public static void find(int[] a, int N, int M){
        for(int j =0; j < N; j++){
            for(int k =0; k < N; k++ ){
                if((a[j] + a[k]) == M && k != j){
                    j = j+1;
                    k = k +1;
                    if(k < j){
                        System.out.println(k + " " + j);
                    }else{
                        System.out.println(j + " " + k);
                    }
                    return;
                }
            }
        }
    }
}