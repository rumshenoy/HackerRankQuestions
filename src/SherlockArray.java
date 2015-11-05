import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SherlockArray {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named CountLuck. */
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-- > 0){
            int n = sc.nextInt();
            int a[] = new int[n];
            int i = 0;
            int right = 0;
            while(i < n){
                a[i] = sc.nextInt();
                right += a[i];
                i++;
            }

            int left = a[0];
            i = 1;
            while(i < n ){
                right = right - a[i] - left;
                if(left == right){
                    break;
                }
                left = left + a[i];
                i++;
            }

            System.out.println(i);
            System.out.println(left);
            System.out.println(right);
            if(i > 0 && i < n){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}