import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CountingSort {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named CountingSort. */
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int[] a= new int[m];

        int i =0, j=0;
        while(i < m){
            a[i] = sc.nextInt();
            i++;
        }

        int max =0;
        int n = sc.nextInt();
        int[] b= new int[n];
        while(j < n){
            b[j] = sc.nextInt();
            if(b[j] > max){
                max = b[j];
            }

            j++;
        }

        int[] c = new int[100];
        int[] d = new int[100];

        for(int k =0; k < a.length; k++){
            c[max - a[k]] = c[max - a[k]] + 1;
        }

        for(int k =0; k < b.length; k++){
            d[max - b[k]] = d[max - b[k]] + 1;
        }

        for(int l =99 ; l >= 0; l--){
            if(c[l] < d[l]){
                System.out.print(max - l+ " ");
            }
        }



    }
}