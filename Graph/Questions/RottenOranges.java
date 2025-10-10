package Graph.Questions;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    
    
    // given a matrix with 0s, 1s, and 2s
    // with 0 -> empty, 1 - fresh and 2 - rotten
    // find minimum time to rot all oranges
    // if a rotten oranges  rots its all neighbours in 4 directions in unit time

        // approach
    // will follow the normal bfs approach of marking neighbours levelwise
    // will maintain a  custom ds to store row, col and time of rotten oranges in the queue
    // 1st push all the already rotten oranges to the queue, along with the time of rotting 1st to be 0

    // then marking all its neighbours as rotten incrementing the time 

    // sc = O(n*m)  , worst case
    // tc = 2 * O(n*m) + 4(n*m)        // 1st two for find rotten oranges and last loop for checking if any oranges left, 2nd one for traversing all neighbours to rot

    // creating custom class
    static class Marking{
        int row;
        int col;
        int time;
        public Marking(int row, int col, int time){
            this.row = row; 
            this.col = col;
            this.time = time;
        }
    }

    public int orangesRotting(int[][] grid) {
        
        int time = 0;
        Queue<Marking> que = new LinkedList<Marking>();
        // first find the rotten oranges
        for(int i = 0; i< grid.length; i++){
            for(int j =0; j< grid[0].length; j++){
                if(grid[i][j] == 2){        // if found add to the que, with initial time to be 0

                    que.add(new Marking(i,j,0));
                }
            }
        }

        // now all the initial rotten oranges are added to the queue
        // now to traverse through their neighbouring oranges one by one, and rot them

        // now applying bfs
        while(!que.isEmpty()){

            // extract the top
            int cr = que.peek().row;
            int cc = que.peek().col;
            int ct = que.peek().time;

            // update time 
            time = Integer.max(time, ct);
            que.remove();

            // now that we have the top
            // rot all its neighbours
            int[] drow = {-1,1,0,0};
            int[] dcol = {0,0,-1,1};

            for(int k=0; k<4; k++){
                int nr = cr + drow[k];
                int nc = cc + dcol[k];
                int nt = ct;
                // now we got the neighbour
                // check for boundary
                if(nr>=0 && nr<grid.length && nc>=0 && nc < grid[0].length){

                    // check if cell has the orange
                    if(grid[nr][nc] == 1){
                        // mark it as rotten, add to que with incremented time
                        grid[nr][nc] = 2;
                        que.add(new Marking(nr, nc, nt+1));
                    }
                }
                

            }
        }
        // now check if any oranges left, if so, return -1
        for(int i = 0; i< grid.length; i++){
            for(int j =0; j< grid[0].length; j++){
                if(grid[i][j]==1) return -1;
            }
        }
        return time;
    }
}
