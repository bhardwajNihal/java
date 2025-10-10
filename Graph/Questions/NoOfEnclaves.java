package Graph.Questions;

public class NoOfEnclaves {
    

    // leetcode 1020.
    
    // given grid with 0s and 1s
    // with 0 representing sea and 1 land
    // we have to basically count the no. of lands from where we can't directly escape in 1 step
    
    // so approach is simple, same as the surrounded region questions

    // mark all the boundary lands and their neighbours via dfs
    // all other lands are enclosed, thus escaping them takes more than 1 step
    // simply count enclosed lands and return
        

    
static void dfs(int row, int col, int[][] board, int[][] visited){

        int[] dr  = {-1,1,0,0};
        int[] dc = {0, 0, -1, 1};

        for(int k=0; k<4; k++){

            int nr = row + dr[k];
            int nc = col + dc[k];

            // check for boundary
            if(nr>=0 && nr<board.length && nc>=0 && nc<board[0].length){

                //mark unvisited neigbouring 0s
                if(board[nr][nc] == 1 && visited[nr][nc]!=1){
                    visited[nr][nc] = 1;
                    //call dfs for the neighbours
                    dfs(nr, nc, board, visited);
                }
            }
        }
    }

    public int numEnclaves(int[][] board) {
        
        int m = board.length;
        int n = board[0].length;

        int[][] visited = new int[m][n];  

        // mark all boundary 1s

        // marking 1st row
        int row = 0; 
        for(int k = 0; k<n; k++){
            // call dfs for unvisited 0s
            if(board[row][k] == 1 && visited[row][k] != 1){
                visited[row][k] = 1;
                dfs(row, k,  board, visited);
            }
        } 
        // marking 1st column
        int col = 0;
        for(int k = 0; k<m; k++){
            // call dfs for unvisited 0s
            if(board[k][col] == 1 && visited[k][col] != 1){
                visited[k][col] = 1;
                dfs(k, col,  board, visited);
            }
        }

        // last row
        row = m-1; 
        for(int k = 0; k<n; k++){
            // call dfs for unvisited 0s
            if(board[row][k] == 1 && visited[row][k] != 1){
                visited[row][k] = 1;
                dfs(row, k,  board, visited);
            }
        } 
        // last column
        col = n-1;
        for(int k = 0; k<m; k++){
            // call dfs for unvisited 0s
            if(board[k][col] == 1 && visited[k][col] != 1){
                visited[k][col] = 1;
                dfs(k, col,  board, visited);
            }
        }

        // lastly count all unvisted 1s
        // as they aren't connected to the boundary
        int count = 0;
        for(int i = 0; i<m ;i++){
            for(int j = 0 ; j<n; j++){
                if(board[i][j]==1 && visited[i][j] != 1){
                    count++;
                }
            }
        }

        return count;
    }
}
