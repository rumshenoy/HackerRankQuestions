import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by ramya.shenoy on 10/23/15.
 */
public class CavityMap {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int i = 0;
        BigInteger[][] series = new BigInteger[n][n];
        for (i = 0; i < n; i++) {
            String line = bf.readLine();
            for (int j = 0; j < n; j++) {
                series[i][j] = new BigInteger(String.valueOf(line.charAt(j)));
            }
        }

        for (i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0 && i < n - 1 && j > 0 && j < n - 1) {
                    if (series[i][j].compareTo(series[i - 1][j]) > 0 && series[i][j].compareTo(series[i + 1][j]) > 0 &&
                            series[i][j].compareTo(series[i][j - 1]) > 0 && series[i][j].compareTo(series[i][j + 1]) > 0) {
                        System.out.print("X");
                    } else {
                        System.out.print(series[i][j]);
                    }
                } else {
                    System.out.print(series[i][j]);
                }
            }
            System.out.print("\n");

        }
    }
}
