package Graph.Questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class NoOfProvices {
    

    class Solution {

    static void dfs(List<List<Integer>> graph, int index, int[] visited){
        if(graph.size()==0) return;
        if(visited[0]!=1){
            visited[0] = 1;
        }
        for(int i =0; i<graph.get(index).size(); i++){

            int neighbour = graph.get(index).get(i);
            if (visited[neighbour] != 1) {
                // mark the ele
                visited[neighbour] = 1;

                // further recursive call for depth traversal
                dfs(graph, neighbour, visited);

            }
            
        }
    }


    public int findCircleNum(int[][] mat) {
        
        // converting to adjacency list
        // 0-based graph
        List<List<Integer>> graph = new ArrayList<>();
        for(int i =0; i<mat.length; i++){ 
            graph.add(new ArrayList<>());
        }
        for(int i =0; i<mat.length; i++){
            for(int j =0; j<mat.length; j++){

                if(mat[i][j] == 1){
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }


        // now we have the graph in  desired format
        int count = 0;
        int[] visited = new int[mat.length];    // maintaining a visited arr

    // iterating over each node of the graph
    // if a particular node is not visited, calling dfs for it, incrementing the counter
    // if will further mark every connected nodes of the current one as visited
    // thus inside the loop, the next dfs will only be called in case of non-connected nodes
    // each time dfs is called counter is incremented, hence we get no. of provices
        for(int i = 0; i<mat.length; i++){

            if(visited[i]!=1){
                count++;
                dfs(graph,i,visited);
            }
        }

        return count;
    }
}


    // TC = O(N) + O(V+2E)      // one for the loop, one for the dfs call
    // sc = O(2N) , one for visited, one for the stack in worst case 
}
