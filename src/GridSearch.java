import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ramya.shenoy on 10/24/15.
 */
public class GridSearch {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());

        while(T-- > 0){
            String RC = bf.readLine();
            String[] array1 = RC.split(" ");
            int R = Integer.parseInt(array1[0]);
            int C = Integer.parseInt(array1[1]);
            int i =0;
            String input = "";
            while(i < R){
                input +=bf.readLine();
                i++;
            }

            String rc = bf.readLine();
            String[] array2 = rc.split(" ");
            int r = Integer.parseInt(array2[0]);
            int c = Integer.parseInt(array2[1]);
            int j = 0;
            String[] pattern = new String[r];
            while(j < r){
                pattern[j] = bf.readLine();
                j++;
            }

            int l =0;
            if(input.contains(pattern[0])){
                int index = input.indexOf(pattern[0]);
                for(l =1 ; l < r; l++){
                    if(input.substring(index+C, index+C+c).equals(pattern[l])){
                        index = index + C;
                        continue;
                    }else{
                        System.out.println("NO");
                        break;
                    }
                }
            }

            if(l == r){
                System.out.println("YES");
            }

        }
    }
}
