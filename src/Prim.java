import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ramya.shenoy on 10/26/15.
 */
public class Prim {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = bf.readLine().split(" ");
        int N = Integer.parseInt(nm[0]);
        int M = Integer.parseInt(nm[1]);

        int[][] adj = new int[N+1][N+1];
        for(int i =1; i <=N; i++){
            for(int j =1; j<=N; j++){
                adj[i][j] = -1;
            }
        }
        int i =1;
        while(i <= M){
            String[] line = bf.readLine().split(" ");
            int v1 = Integer.parseInt(line[0]);
            int v2 = Integer.parseInt(line[1]);
            int d = Integer.parseInt(line[2]);

            if(adj[v1][v2] > 0){
                if(d < adj[v1][v2]){
                    adj[v1][v2] = adj[v2][v1] = d;
                }
            }else{
                adj[v1][v2] = d;
                adj[v2][v1] = d;
            }

            i++;
        }

        int source = Integer.parseInt(bf.readLine());
        BigInteger mincost;
        boolean[] visited = new boolean[N+1];
        BigInteger[] dist = new BigInteger[N+1];
        int[] p = new int[N+1];
        int infinity = (2 ^ 32) ^ Integer.MAX_VALUE;

        for(i = 1 ; i <= N; i++){
            dist[i] = BigInteger.valueOf(infinity);
            p[i] = 0;
        }

        int current = 1;
        int total = 1;
        visited[current] = true;
        dist[current] = BigInteger.ZERO;

        while(total <= N){
            for(i =1; i <= N; i++){
                if(adj[current][i] >= 0){
                    if(visited[i] == false){
                        if( dist[i].compareTo(BigInteger.valueOf(adj[current][i])) > 0){
                            dist[i] = BigInteger.valueOf(adj[current][i]);
                            p[i] = current;
                        }
                    }
                }
            }
            mincost = BigInteger.valueOf(infinity);
            for(int j=1; j <= N;j++){
                if(visited[j] == false){
                    if(dist[j].compareTo(mincost) < 0){
                        mincost = dist[j];
                        current = j;
                    }
                }
            }
            visited[current] = true;
            total++;
        }

        mincost = BigInteger.ZERO;
        for(i=1; i<=N; i++){
            mincost = mincost.add(dist[i]);
        }
        System.out.println(mincost);
    }

}
