package Graph.Questions;

public class SurroundedRegions {
 
    
       
        // approach
        // initialize a visited matrix with 0s
        // visit all the boundary elements, 
        // if 0, mark it and all it's neighbours as visited using dfs
        // after marking all boundary 0s as visited
        // call for dfs for unvisited zeroes
    static void dfs(int row, int col, char[][] board, int[][] visited){

        int[] dr  = {-1,1,0,0};
        int[] dc = {0, 0, -1, 1};

        for(int k=0; k<4; k++){

            int nr = row + dr[k];
            int nc = col + dc[k];

            // check for boundary
            if(nr>=0 && nr<board.length && nc>=0 && nc<board[0].length){

                //mark unvisited neigbouring 0s
                if(board[nr][nc] == 'O' && visited[nr][nc]!=1){
                    visited[nr][nc] = 1;
                    //call dfs for the neighbours
                    dfs(nr, nc, board, visited);
                }
            }
        }
    }

    public void solve(char[][] board) {

        int m = board.length;
        int n = board[0].length;

        int[][] visited = new int[m][n];  

        // mark all boundary 0s

        // marking 1st row
        int row = 0; 
        for(int k = 0; k<n; k++){
            // call dfs for unvisited 0s
            if(board[row][k] == 'O' && visited[row][k] != 1){
                visited[row][k] = 1;
                dfs(row, k,  board, visited);
            }
        } 
        // marking 1st column
        int col = 0;
        for(int k = 0; k<m; k++){
            // call dfs for unvisited 0s
            if(board[k][col] == 'O' && visited[k][col] != 1){
                visited[k][col] = 1;
                dfs(k, col,  board, visited);
            }
        }

        // last row
        row = m-1; 
        for(int k = 0; k<n; k++){
            // call dfs for unvisited 0s
            if(board[row][k] == 'O' && visited[row][k] != 1){
                visited[row][k] = 1;
                dfs(row, k,  board, visited);
            }
        } 
        // last column
        col = n-1;
        for(int k = 0; k<m; k++){
            // call dfs for unvisited 0s
            if(board[k][col] == 'O' && visited[k][col] != 1){
                visited[k][col] = 1;
                dfs(k, col,  board, visited);
            }
        }

        // lastly mark all unvisted 0s as X
        // as they aren't connected to the boundary
        for(int i = 0; i<m ;i++){
            for(int j = 0 ; j<n; j++){
                if(board[i][j]=='O' && visited[i][j] != 1){
                    board[i][j] = 'X';
                }
            }
        }
    }
}
