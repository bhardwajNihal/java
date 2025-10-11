import java.util.ArrayList;
import java.util.List;

public class PossibleTask_I {
    


      // approach
    // just to make sure the graph doesn't have circular dependency
    // as it has it, not possible to carry out all the task
    
    // so simply check for the cycle in the directed graph
    
    static boolean dfs(List<List<Integer>> graph, int node, int[] visited, int[] path){
        
        // mark unvisited node and add to path
        if(visited[node] != 1){
            visited[node] = 1; 
            path[node] = 1;
        }
        
        
        // traverse through all its neighbours
        for(int i = 0; i<graph.get(node).size(); i++){
            
            int neighbour = graph.get(node).get(i);
            
            // not visited call for dfs 
            if(visited[neighbour] != 1){
                if(dfs(graph, neighbour, visited, path)) return true; 
                
            }
            else{       // if visited is in the same path, i.e. path is not marked
                if(path[neighbour] == 1) return true;
            }
        }
        path[node] = 0;     // backtrack
        return false;
    }
    public boolean isPossible(int V, int P, int[][] edges) {
   
    // converting to adj. list
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<V; i++){
            graph.add(new ArrayList<>());       // need to initialize empty lists inside the list before adding to be able to access
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
        }
        
        int[] visited = new int[V];
        int[] path = new int[V];
        
        for(int i =0; i<V; i++){
            if(visited[i] != 1){
                // if has cycle, not possible to complete all the task, thus return false
                if(dfs(graph, i, visited, path)) return false;
            }
        }
        
        // if it has no cycle, then all the task can be carried out independently
        return true;
        
         }
}
