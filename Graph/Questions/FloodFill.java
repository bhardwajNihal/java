package Graph.Questions;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    
     static class Pair{
        int row; 
        int col;

        public Pair(int row , int col){
            this.row = row; 
            this.col = col;
        }
    }


    // Tc = O(4*n*m)        // in worst case calling dfs or bfs for all cell, and then traversing through its 4 neigbours
    // Sc = O(n*m) + O(n*m) // for the copy and the stack space for worst case


// approach 1 : using BFS
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        if(image[sr][sc]==color) return image;
        // approach 

        // same as bfs
        // utilize que
            // add the starting cell to the que
            // color all of its neighbours that are of same color as start
            // remove
            // repeat for all the neighbours

        int currColor = image[sr][sc];
        Queue<Pair> que = new LinkedList<Pair>();

        // add the starting cell to the queue and mark it 
        que.add(new Pair(sr, sc));
        image[sr][sc] = color;

        // now traverse through all neigbours till que is empty
        while(!que.isEmpty()){

            // extract current row, and col, remove from the queue
            int cr = que.peek().row;
            int cc = que.peek().col;
            que.remove();

            // technique to traverse horizotally and vertically 
            int[] dr  = {-1,1,0,0};
            int[] dc = {0, 0, -1, 1};

        // loop through all the neighbours
            for(int k = 0; k<4; k++){

                // get neigbours based on delta row and col, mark and add to queue for further traversal
                int nr = cr + dr[k];
                int nc = cc + dc[k];

            // check for boundary
                if(nr>=0 && nr<image.length && nc >=0 && nc <image[0].length){

                    // if the neighbour is of same color as the starting cell then mark it and add
                    if(image[nr][nc] == currColor){
                        image[nr][nc] = color;
                        que.add(new Pair(nr, nc));
                    }
                }
            }


        }
        return image;
    }



    // approach 2 : using DFS

    // ideally we should never tamper the original data
    // so make the copy of the original matrix given, then continue
     static void dfs(int row, int col, int[][] grid, int color, int originalColor){

        int[] dr  = {-1,1,0,0};
        int[] dc = {0, 0, -1, 1};

        // loop through all the neighbours
            for(int k = 0; k<4; k++){

                // get neigbours based on delta row and col, mark and add to queue for further traversal
                int nr = row + dr[k];
                int nc = col + dc[k];

            // check for boundary
                if(nr>=0 && nr<grid.length && nc >=0 && nc <grid[0].length){

                    // if the neighbour is of same color as the starting cell then mark it
                    // call recursively to traverse neighbours of that cell
                    if(grid[nr][nc] == originalColor){
                        grid[nr][nc] = color;
                        dfs(nr, nc, grid, color, originalColor);
                    }
                }
            }
    }
    public int[][] floodFill_2(int[][] image, int sr, int sc, int color) {
        
        int m = image.length;
        int n = image[0].length;

        // create a copy of original matrix
        int[][] copy = new int[m][n];
        for(int i =0; i<m; i++){
            for(int j = 0; j<n; j++){
                copy[i][j] = image[i][j];
            }
        }

    // if current color is same as provided return without altering
        if(image[sr][sc] == color) return copy;


    // mark current cell as color
    copy[sr][sc] = color;
    // now apply dfs
    dfs(sr, sc, copy, color, image[sr][sc]);

    return copy;
    }

}
