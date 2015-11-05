import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ramya.shenoy on 10/25/15.
 */
public class ShortSearch {
    public static void main(String[] args)  throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        while(T-- > 0){
            String input = bf.readLine();
            String[] nodesEdges = input.split(" ");
            int N = Integer.parseInt(nodesEdges[0]);
            int M = Integer.parseInt(nodesEdges[1]);

            HashMap<Integer, ArrayList<Integer>> adjacency = new HashMap<Integer, ArrayList<Integer>>();
            int i = 1;
            while(i <= M){
                String[] line = bf.readLine().split(" ");
                int k = Integer.parseInt(line[0]);
                int v = Integer.parseInt(line[1]);
                if(adjacency.containsKey(k)){
                    ArrayList<Integer> value = adjacency.get(k);
                    value.add(v);
                }else{
                    ArrayList<Integer> value = new ArrayList<Integer>();
                    value.add(v);
                    adjacency.put(k, value);
                }

                if(adjacency.containsKey(v)){
                    ArrayList<Integer> value = adjacency.get(v);
                    value.add(k);
                }else{
                    ArrayList<Integer> value = new ArrayList<Integer>();
                    value.add(k);
                    adjacency.put(v, value);
                }
                i++;
            }

            int source = Integer.parseInt(bf.readLine());
            boolean[] flag = new boolean[N+1];
            int[] pred = new int[N+1];
            Queue q = new LinkedList();
            int[] distance = new int[N+1];

            for(i= 1; i <= N; i++){
                flag[i] = false;
                pred[i] = -1;
            }

            flag[source] = true;
            q.add(source);
            distance[source] = 0;
            while(!q.isEmpty()){
                int k = (Integer)q.poll();
                if(adjacency.containsKey(k)){
                    ArrayList<Integer> values = adjacency.get(k);
                    for(int v: values){
                        if(flag[v] == false){
                            flag[v] = true;
                            distance[v] = distance[k] + 1;
                            pred[v] = k;
                            q.add(v);
                        }

                    }
                }

            }

            for(int m =1 ; m <= N; m++){
                if(m == source){
                    continue;
                }
                if(distance[m] > 0){
                    System.out.print(distance[m] * 6);
                }else{
                    System.out.print("-1");
                }
                if(m < N)
                    System.out.print(" ");
            }

            System.out.println();
        }
    }
}
