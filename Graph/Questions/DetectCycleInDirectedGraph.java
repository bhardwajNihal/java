import java.util.ArrayList;
import java.util.List;

public class DetectCycleInDirectedGraph {

    
    
    // approach
    // will use dfs
    // check if any path is revisited
    // will maintain two arrays one for visited one and 2nd one for the path
    // one every visit push the node to the path array, if cycle is not found till the dead end, backtrack and explore diffrent path
    // if any visited node is found on the same path
    // conclude that the graph has the cycle
    
     
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
    
    
    
    public boolean isCyclic(int V, int[][] edges) {
        
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
                if(dfs(graph, i, visited, path)) return true;
            }
        }
        return false;
        
        
    }
}