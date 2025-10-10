import java.util.LinkedList;
import java.util.Queue;

public class Nearest1 {
    

    // approach
    // using bfs
    // maintain a visited matrix
    // and a distances matrix
    
    // start with the cells with 1s
    // mark as visited and distance to be 0
    
    // repeat the same for the 2nd level
    // mark distance as 1, and so on...
    
    
    // custom class for holding row, col, and the distance
    static class Triplet{
        
        int row;
        int col; 
        int distance;
        
        public Triplet(int r, int c, int d){
            this.row = r;
            this.col = c;
            this.distance = d;
        }
    }
    
    static void helper(int[][] grid, int[][] distance, int[][] visited){
        
        int m = grid.length;
        int n = grid[0].length;
        
        // initialize queue to store row, col and distance
        Queue<Triplet> que = new LinkedList<Triplet>();
        
        // add the 1s to que
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                
                if(grid[i][j] == 1){
                    que.add(new Triplet(i,j,0));
                    visited[i][j] = 1;
                    distance[i][j] = 0;
                }
                
            }
        }
        
        
        // now applying bfs
        // marking as visited, and maintaining distance matrix
        while(!que.isEmpty()){
            
            // extract peek ele, then remove
            int cr = que.peek().row;
            int cc = que.peek().col;
            int dist = que.peek().distance;
            que.remove();
            
            // traverse all four neighbours
            int[] dr = {-1,1,0,0};
            int[] dc = {0,0,-1,1};
            
            for(int k=0; k<4; k++){
                
                int nr = cr + dr[k];
                int nc = cc + dc[k];
                
                // check  for the valid boundary
                if(nr>=0  && nr<m && nc>=0 && nc<n){
                    
                    // for unvisited 0s
                    // add to que and mark as visited, and mark distance
                    if(grid[nr][nc] == 0 && visited[nr][nc] !=1){
                        que.add(new Triplet(nr,nc, dist+1));
                        visited[nr][nc] = 1;
                        distance[nr][nc] = dist+1;      // distance increments levelwise
                        
                    }
                }
            }
            
            
        }
        
    }
    
    // Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] visited = new int[m][n];
        int[][] dist = new int[m][n];
        
        helper(grid,dist, visited);
        
        return dist;
        
    }
}
