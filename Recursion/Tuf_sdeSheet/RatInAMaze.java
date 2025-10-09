package Tuf_sdeSheet;

import java.util.ArrayList;

public class RatInAMaze {
    
    // Given a 2d matrix with 0s, and 1s, with 0 depicts the blocked path, 1 depicts the free path
    // give all possible paths to reach to the end

    // type-1 : (2 directions only, i.e. R,D);

    // approach
    
    static void maze_I(int[][] maze, int sr, int sc, int er, int ec, String currentPath){

        if(sr==er && sc==ec) {
            System.out.println(currentPath);
            return;
        }

        // if the right path is free
        if(sc<maze[sr].length-1 && maze[sr][sc+1]==1){
            // currentPath += "R";      // this is wrong, as it appends the char in the current stack, and once this call is over, the next call will recieve a polluted string, and not the empty string as it's supposed to be
            maze_I(maze, sr, sc+1, er, ec, currentPath+"R"); // "R" only for this branch
        }

        // if the down path is free
        if(sr<maze.length-1 && maze[sr+1][sc]==1){
            maze_I(maze, sr+1, sc, er, ec, currentPath+"D");
        }
    }



// type -2, rat can move in all four directions
// here, an extra parameter is used to keep track of the visited path, else will run into infinite loop, if rat enters a cycle inside a maze
    static void maze_II(int[][] maze, int sr, int sc, int er, int ec, String currentPath, boolean[][] visited){

        if(sr==er && sc==ec) {
            System.out.println(currentPath);
            return;
        }

        // mark current cell to be visited
        visited[sr][sc] = true;

        // if the right path is free
        if(sc<maze[sr].length-1 && maze[sr][sc+1]==1 && !visited[sr][sc+1]){
            // currentPath += "R";      // this is wrong, as it appends the char in the current stack, and once this call is over, the next call will recieve a polluted string, and not the empty string as it's supposed to be
            maze_II(maze, sr, sc+1, er, ec, currentPath+"R",visited); // "R" only for this branch
        }
        // if the down path is free
        if(sr<maze.length-1 && maze[sr+1][sc]==1 && !visited[sr+1][sc]){
            maze_II(maze, sr+1, sc, er, ec, currentPath+"D",visited);
        }
        // if the left path is free
        if(sc>0 && maze[sr][sc-1]==1 && !visited[sr][sc-1]){
            maze_II(maze, sr, sc-1, er, ec, currentPath+"L",visited);
        }   
        // if the up path is free
        if(sr>0 && maze[sr-1][sc]==1 && !visited[sr-1][sc]){
            maze_II(maze, sr-1, sc, er, ec, currentPath+"U",visited);
        }   

        // unmark the current cell while backtracking
        // for other possible paths to get free ones
         visited[sr][sc] = false;

    }



    // space optimized version
    // no need of extra matrix to keep track of the visited cell
    // instead just mark the visited cell as -1 inplace, later unmark it
    static void maze_II_better(int[][] maze, int sr, int sc, int er, int ec, String currentPath,ArrayList<String> ans){

        if(sr==er && sc==ec) {
            ans.add(currentPath);
            return;
        }

        // mark current cell to be visited
        maze[sr][sc] = -1;

        // if the right path is free
        if(sc<maze[sr].length-1 && maze[sr][sc+1]==1 && maze[sr][sc+1]!=-1){
            // currentPath += "R";      // this is wrong, as it appends the char in the current stack, and once this call is over, the next call will recieve a polluted string, and not the empty string as it's supposed to be
            maze_II_better(maze, sr, sc+1, er, ec, currentPath+"R", ans); // "R" only for this branch
        }
        // if the down path is free
        if(sr<maze.length-1 && maze[sr+1][sc]==1 && maze[sr+1][sc]!=-1){
            maze_II_better(maze, sr+1, sc, er, ec, currentPath+"D", ans);
        }
        // if the left path is free
        if(sc>0 && maze[sr][sc-1]==1 && maze[sr][sc-1]!=-1){
            maze_II_better(maze, sr, sc-1, er, ec, currentPath+"L",ans);
        }   
        // if the up path is free
        if(sr>0 && maze[sr-1][sc]==1 && maze[sr-1][sc]!=-1){
            maze_II_better(maze, sr-1, sc, er, ec, currentPath+"U",ans);
        }   

        // unmark for further calls
        maze[sr][sc] = 1;

    }


    public static void main(String[] args) {
        
        int[][] maze = {{1,1,1,1}, {1,1,1,1}, {1,0,1,1}, {0,0,0,1}};
        boolean[][] v = new boolean[maze.length][maze.length];

        maze_II(maze, 0, 0, maze.length-1, maze[0].length-1, "",v);
    }
}
