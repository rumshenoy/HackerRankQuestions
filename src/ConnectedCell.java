import java.io.*;

/**
 * Created by ramya.shenoy on 10/22/15.
 */
public class ConnectedCell {


    int currentDepth;

    public int visit(int startR, int startC, int[][] a, boolean[][] seen){
        if(startR >= 0 && startC >= 0 && startR < a.length && startC < a[0].length && seen[startR][startC] != true && a[startR][startC] !=0) {
            currentDepth++;

            seen[startR][startC] = true;

            visit(startR + 1, startC, a, seen);
            visit(startR - 1, startC, a, seen);
            visit(startR, startC + 1, a, seen);
            visit(startR, startC - 1, a, seen);
            visit(startR - 1, startC - 1, a, seen);
            visit(startR + 1, startC - 1, a, seen);
            visit(startR + 1, startC + 1, a, seen);
            visit(startR - 1, startC + 1, a, seen);
        }
        return currentDepth;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(bf.readLine());
        int n = Integer.parseInt(bf.readLine());

        int[][] a = new int[m][n];

        for(int i = 0; i < m; i++){
            String line = bf.readLine();
            String[] array = line.split(" ");
            for(int j = 0; j < n; j++){
                a[i][j] = Integer.parseInt(array[j]);
            }
        }

        boolean[][] seen = new boolean[m][n];
        ConnectedCell s = new ConnectedCell();
        int maxDepth =0, depth;
        for(int i=0; i < m; i++){
            for(int j =0; j < n ;j++){
                if(a[i][j] == 1 && seen[i][j] == false){
                    s.currentDepth = 0;
                    depth = s.visit(i, j, a, seen);
                    if(depth > maxDepth){
                        maxDepth = depth;
                    }
                }
            }
        }

        System.out.println(maxDepth);
    }
}
