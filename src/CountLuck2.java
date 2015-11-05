import java.util.Scanner;

/**
 * Created by ramya.shenoy on 10/22/15.
 */
public class CountLuck2 {
    
    public static class Node{
        int row;
        int column;
        Node prev;

        public Node(int row, int column) {
            this.row = row;
            this.column = column;
        }
        
        
    }

    public static void visit(char[][] maze, int startR, int startC, boolean[][] seen, Node prev, Node tail){
        if(startR < 0 || startC <0 || startR >= maze.length || startC >= maze[0].length || seen[startR][startC]){
            return;
        }

        if(maze[startR][startC] == 'X'){
            return;
        }

        if(maze[startR][startC] == '*'){
            tail.prev = prev;
            return;
        }

        seen[startR][startC] = true;
        Node node = new Node(startR, startC);
        node.prev = prev;

        visit(maze, startR-1, startC, seen, node, tail);
        visit(maze, startR, startC -1, seen, node, tail);
        visit(maze, startR+1, startC, seen, node, tail);
        visit(maze, startR, startC +1, seen, node, tail);
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while(T-- > 0){
            int rows = sc.nextInt();
            int columns = sc.nextInt();

            int startR=0, startC=0;
            int endR=0, endC=0;

            char[][] maze = new char[rows][columns];
            for(int r = 0; r < rows; r++){
                String str = sc.next();
                int c = str.indexOf('M');

                if(c>=0){
                    startR=r;startC=c;
                }
                c = str.indexOf("*");
                if(c>=0){
                    endR=r;endC=c;
                }
                maze[r] = str.toCharArray();
            }
            
            int k = sc.nextInt();
            boolean[][] seen = new boolean[rows][columns];
            Node head = null;
            Node tail = new Node(endR, endC);
            visit(maze, startR, startC, seen, head, tail);
            
            
            int counter = 0;
            Node node = tail.prev;
            
            while(node != null){
                int option =0;
                
                if(node.row-1 >=0 && node.row-1 <rows && maze[node.row-1][node.column] == '.'){
                    option++;
                }
                if(node.row+1>=0 && node.row+1<rows && maze[node.row+1][node.column]=='.')
                    option++;
                if(node.column-1>=0 && node.column-1<columns && maze[node.row][node.column-1]=='.')
                    option++;
                if(node.column+1>=0 && node.column+1<columns && maze[node.row][node.column+1]=='.')
                    option++;

                if(option > 2 || (node == tail.prev && option > 1) || (node.row == startR && node.column == startC && option >1)
                        || (node.prev!=null && node.prev.row == startR && node.prev.column == startC && option >1)){
                    counter++;
                }

                node = node.prev;
            }
            
           System.out.println(counter==k?"Impressed":"Oops!");


        }
        
        
        
        
        
    }
}
