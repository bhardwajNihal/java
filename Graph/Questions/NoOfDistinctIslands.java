import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NoOfDistinctIslands {
    


    // approach
    // will maintain a list of pairs
    // where pair will store the difference of current row and col with the base row and col
    
    //will dfs into each unvisited 1s in an order
    // calculate the pair, and push it to the list
    
    // from the main function
    // everytime the unvisited 1 is found, initialize a list
    // call for dfs
    // after the call in that particular iteration, will have the list of pairs
    // will add the temp list to a set
    // set will take care of the duplicates
    
    // finally the no. of items in the set will be the ans
    
    
    // sc = O(2 * m*n)  ---> for the visited matrix, and the list in the worse case
    // tc = O(n*m) + O(4 * m * n) + O(log(n*m))       // for calling dfs for each unvisited cell, and 2nd for exploring each neighbours in the four directions, last one for storing pairs to the set
    
    
    static void dfs(int br, int bc, int cr, int cc, int[][] grid, int[][] visited, List<String> list){
        
        // calculate the relative difference b/w base and current cell
        int rdiff = cr - br;
        int cdiff = cc - bc;
        
        // add the difference pair to the list
        list.add(rdiff + ", " + cdiff);
        
        // mark as visited 
        visited[cr][cc] = 1;
        
        
        // now traverse through all the neighbours
        // simple dfs
        
        // delta rows and col, to traverse 4 directions
        int[] drow = {-1, 1, 0, 0};
        int[] dcol = {0, 0, -1, 1};
        
        int m = grid.length; 
        int n = grid[0].length; 
        
        for(int k = 0; k< 4; k++){
            
            // neighbour cell
            int nr = cr + drow[k];
            int nc = cc + dcol[k];
            
            
            // call for dfs for the neighbour
            
            // chech for boundary
            if(nr>=0 && nr<m && nc >=0 && nc<n){
                
                //if its univisited 1
                if(grid[nr][nc] == 1 && visited[nr][nc] != 1){
                    
                    // call for dfs
                    dfs(br, bc, nr, nc, grid, visited, list);
                }
            }
            
        }
        
        
        
        
    }
    
    
    int countDistinctIslands(int[][] grid) {
        
        int m = grid.length; 
        int n = grid[0].length; 
        
        int[][] visited = new int[m][n];
        
        Set<List<String>> set = new HashSet<>();
        
        for(int i = 0;  i< m ; i++){
            for(int j =0; j< n ; j++){
                // for unvisited 1s
                if(grid[i][j]==1 && visited[i][j] != 1){
                    
                    //initialize an empty list
                    // list of String makes it easier to store the relative row and col difference
                    // and later to be compared to be added to the set 
                    List<String> temp = new ArrayList<>();
                    
                    // call for dfs
                    // it will traverse the entire island
                    // and will add the diff pair to the temp list for the current iteration
                    dfs(i, j, i, j, grid, visited, temp);
                    
                    // finally add the current list to the set
                    set.add(temp);
                    
                }
            }
        }
        
        return set.size();
        
    }
}
