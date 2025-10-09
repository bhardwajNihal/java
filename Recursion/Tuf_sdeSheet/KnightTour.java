package Tuf_sdeSheet;

public class KnightTour {
    

    // brute
    // check from each cell whether the knight moved to any valid position
    static boolean isValid(int[][] board, int r, int c){

        if (board[0][0] != 0) return false;     // knight must start with 0,0 always
        int n = board.length;
        if(board[r][c] == (n*n)-1) return true; 

        // up-right
        if(r-2>=0 && c+1<board.length && board[r-2][c+1] == board[r][c]+1) return true;

        // up-left
        else if (r-2>=0 && c-1>=0 && board[r-2][c-1] == board[r][c]+1) return true;

        // right-up
        else if(r-1>=0 && c+2<board.length && board[r-1][c+2] == board[r][c]+1) return true;

        // right-down
        else if(r+1<board.length && c+2<board.length && board[r+1][c+2] == board[r][c]+1) return true;

        // down-right
        else if(r+2<board.length && c+1<board.length && board[r+2][c+1] == board[r][c]+1) return true;

        // down-left
        else if(r+2<board.length && c-1>=0 && board[r+2][c-1] == board[r][c]+1) return true;

        // left-up
        else if(r-1>=0 && c-2>=0 && board[r-1][c-2] == board[r][c]+1) return true;

        // left-down
        else if(r+1<board.length && c-2>=0 && board[r+1][c-2] == board[r][c]+1) return true;

        else return false;
    }

    public static boolean checkValidGrid(int[][] grid) {
        
        for(int i =0; i<grid.length; i++){
            for(int j = 0; j<grid.length; j++){

                System.out.println(isValid(grid, i,j));
            }
        }
        return true;
    }


    public static void main(String[] args) {
        
        int[][] grid = {{24,11,22,17,4},
                        {21,16,5,12,9},
                        {6,23,10,3,18},
                        {15,20,1,8,13},
                        {0,7,14,19,2}};

        System.out.println("ans : " + checkValidGrid(grid));
    }
}
