package Graph.Questions;

import java.util.LinkedList;
import java.util.Queue;

public class NoOfIslands {
    

    // given matrix m X n , of char 0 and 1
    // 1 = land , 0 = water
    // find out the no. of islands

    // approach
        
        // initialize a counter, and a visited matrix
        // iterate over the matrix
        // if land is found, which is not visited
            // traverse through all its neighbours and mark them as visited
            // increment the counter
        // now find another unvisited land
        // if found increment the counter, and traverse through neigbour
        
        // this way, everytime an unvisited land is found
        // means its not the part of the previous island
        // thus its the new island
        
        // counter finally holds the no. of island
        // thus return the counter


    // SC = ~ 2 *O(M*N) ---> 1st one for extra matrix, and 2nd for que size in worst case 
    // TC = O(m×n)+O(8×m×n)     , each cell is called for bfs, then in bfs 8 possible directions are check for each cell

    // leetcode 200 - 4 directions

    // custom class for pair
    static class Pair{
        
        int row;
        int col;
        
        public Pair(int row, int col){
            this.row = row; 
            this.col = col;
        }
    }
    
    
    static void bfs(int row, int col, char[][] grid, int[][] visited){
        
        Queue<Pair> que = new LinkedList<Pair>();
        
        // add 1st ele to que, mark as visited
        que.add(new Pair(row, col));
        visited[row][col] = 1;
        
        // loop till loop is empty
        while(!que.isEmpty()){
            
            // extracted top ele from the que
            int cRow = que.peek().row;
            int cCol = que.peek().col;
            que.remove();
            
            // now we got the top ele
            // just traverse all it's neigbours and mark as visited
            
            // traverse all neighbours horizontally
            for(int dRow = -1; dRow<=1; dRow++){
                
                    int nr = cRow + dRow;
                    int nc = cCol;
                    // check of boundary, if its land, and unvisited
                    if(nr>=0 && nr<grid.length){
                        if(grid[nr][nc] == '1' && visited[nr][nc]!=1){
                            
                            // mark neighbours and push to queue for further traverse their neighbours
                            visited[nr][nc] = 1;
                            que.add(new Pair(nr, nc));
                        }
                    }
                
            }
            // mark all neighbours vertically
            for(int dCol = -1; dCol<=1; dCol++){
                
                    int nr = cRow;
                    int nc = cCol + dCol;
                    // check of boundary, if its land, and unvisited
                    if(nc>=0 && nc<grid[0].length){
                        if(grid[nr][nc] == '1' && visited[nr][nc]!=1){
                            
                            // mark neighbours and push to queue for further traverse their neighbours
                            visited[nr][nc] = 1;
                            que.add(new Pair(nr, nc));
                        }
                    }
                
            }
            
            
        }
    }
     
    public int numIslands(char[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        
        int count = 0;
        int[][] visited = new int[m][n];
        
        
        for(int i =0; i<m; i++){
            for(int j = 0; j<n; j++){
                
                // call for traversal if unvisted land is found
                // will mark all the connected lands as visited
                if(grid[i][j] == '1' && visited[i][j] != 1){
                    count++;
                    bfs(i,j,grid,visited);
                }
                
            }
        }
        
        return count;
        
    }




    // gfg - 8 directions, where diagonal connections is also considered neighbour

    // just the traversal technique is different
    static void bfs_8dir(int row, int col, char[][] grid, int[][] visited){
        
        Queue<Pair> que = new LinkedList<Pair>();
        
        // add 1st ele to que, mark as visited
        que.add(new Pair(row, col));
        visited[row][col] = 1;
        
        // loop till loop is empty
        while(!que.isEmpty()){
            
            // extracted top ele from the que
            int cRow = que.peek().row;
            int cCol = que.peek().col;
            que.remove();
            
            // now we got the top ele
            // just traverse all it's neigbours and mark as visited
            
            // looping technique to touch all the neighbours vertically, horizontally, and diagonally
            for(int dRow = -1; dRow<=1; dRow++){
                for(int dCol = -1; dCol<=1; dCol++){
                    
                    int nr = cRow + dRow;
                    int nc = cCol + dCol;
                    
                    // check of boundary, if its land, and unvisited
                    if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length){
                        if(grid[nr][nc] == 'L' && visited[nr][nc]!=1){
                            
                            // mark neighbours and push to queue for further traverse their neighbours
                            visited[nr][nc] = 1;
                            que.add(new Pair(nr, nc));
                        }
                    }
                }
            }
            
            
        }
    }
     
}

