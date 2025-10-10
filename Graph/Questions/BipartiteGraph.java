import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BipartiteGraph {

    
     // approach
    // simple bfs
    // just check the color of neighbours
    // if it's not colored, color it with opposite color
    // if it's colored, check if its of opposite color
    // if not just return false
    // at last return true, means no neighbour found of same color


    // color array is enough to check if the cell is visited or not

    // sc = 2 * O(N)    // color array and que is worst case
    // tc = o(n) 
    
    static boolean bfs(List<List<Integer>> graph, int node,int[] color){
        
        // initilize a queue
        Queue<Integer> que = new LinkedList<>();
        
        // mark the very 1st node as visited, color with 0, push to que
        if(color[node] == -1){
            
            color[node] = 0;
            que.add(node);
        } 
        
        // bfs
        // explore neighbours, check if colored or not
        // if colored, check if correct
        // if not, mark, color, and add to queue
        while(!que.isEmpty()){
            
            int temp = que.peek();
            que.remove();
            
            int m = graph.get(temp).size();
            
            // iterate through all the neighbours of the current node
            for(int i = 0;  i< m; i++){
                
                int neighbour = graph.get(temp).get(i);
                int currColor = color[temp];
                
                // check if neighbour visited
                
                // if yes, check color, if same return false
                if(color[neighbour] != -1){
                    if(color[neighbour] == currColor) return false;
                }
                
                // if not visited
                // simply add to que, mark as visited, color opposite
                else{
                    que.add(neighbour);
                    
                    color[neighbour] = currColor == 0 ? 1 : 0;
                }
            }
        }
        
        // at end return true, means no neighbour with same color found till entire traversal
        return true;
        
    }
    
    
    public boolean isBipartite(int V, int[][] edges) {

        
    List<List<Integer>> graph = new ArrayList<>();
       
       for(int i = 0;  i<V;  i++){
           graph.add(new ArrayList<>());
       }
       
       for(int[] edge : edges){
           
           int u = edge[0];
           int v = edge[1];
           
           graph.get(u).add(v);
           graph.get(v).add(u);
       }
        
        
        int m = graph.size();
        int[] color = new int[m];
        Arrays.fill(color, -1);
        
        
        // call for dfs and fill the color 
        for(int i = 0; i< V; i++){
            
            if(color[i] == -1){
                if(!bfs(graph,i, color)) return false;
            }
        }
        return true;
    }
}