package Tuf_sdeSheet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    

    // approach
    // given the 2-d matrix, with all marked a . first
    // iterate over each row --> then each column
    // check if the given cell is safe or not, if yes mark it Q
    // once the given row is marked with one queen, call recursion with next row, 
    // then unmark while backtracking

    static void nQueens(List<List<String>> board, int row, List<List<String>> ans ){
        
        if(row == board.size()){
            List<String> temp = new ArrayList<>();
            for(int i=0; i<board.size(); i++){      // just fethching individual cell value, putting it to string, then a list to finally be addded to the ans 2d list, to match ans format
                String crrRow = "";
                for(int j=0; j<board.get(i).size(); j++){
                    crrRow += board.get(i).get(j);
                }
                temp.add(crrRow);
            }
            ans.add(temp);
            return;
        }

        // iterate over the current row
            for(int j=0; j<board.get(row).size();j++){

                //check if safe
                if(isSafe(board, row, j)){
                    // mark Queen
                    board.get(row).set(j, "Q");
                    // make further recursion call to fill next row
                    nQueens(board, row+1, ans);
                    // unmark while backtrack
                    board.get(row).set(j, ".");
                }
                
            }

    }

    // helper to check if the cell is safe
    static boolean isSafe(List<List<String>> board, int row, int col){

        // no need to check row, as once the queen is marked, call is made to next row
        // so no way any queen lies in the current row

        // check col
        int i = 0;
        int j = col;
        while (i<board.size()) {
            if(board.get(i).get(j).equals("Q")) return false;
            i++;
        }

    // check diagonals
    // also no need to check below diagonals, as calls are successive, no chance of next row to be marked

    // check upper diagonals, excluding current cell
        // NE
        i = row;
        j = col;
        while (i>0 && j<board.get(0).size()-1) {
            if(board.get(i-1).get(j+1).equals("Q")) return false;
            i--;
            j++;
        }

        // NW
        i = row;
        j = col;
        while (i>0 && j>0) {
            if(board.get(i-1).get(j-1).equals("Q")) return false;
            i--;
            j--;
        }

        return true;
    }


    public static void main(String[] args) {

        List<List<String>> board = new ArrayList<>();
        for(int i =0; i<4; i++){
            List<String> row = new ArrayList<>();
            for(int j=0; j<4; j++){
                row.add(".");
            }
            board.add(row);
        }
        List<List<String>> ans = new ArrayList<>(); 
        
        nQueens(board, 0,ans);

        System.out.println(ans);
    }
}
