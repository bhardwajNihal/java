package Graph.Questions;

import java.util.ArrayList;
import java.util.List;

public class DetectCycleUGDFS {
    

    // detect cycle in undirected graph

    // using dfs

    // sc = 2 * O(N)  // 1st for stack space, and 2nd for visited array
    // tc = O(N + 2E) + O(N)        // 1st on visited each node and its neighbours, 2nd for looping through each node for unconnected component, as no need to call dfs externally to each node individually, just the start of unconnected ones

    static boolean dfs(int node, int parent, List<List<Integer>> graph, int[] visited){
        
        // go to each unvisited neighbour
        // mark it 
        // if visited neigbour found with different parent return true
        
        // mark current node as visited
        if(visited[node]!=1) visited[node] = 1;
        
        // loop through its neighbours
        // call dfs for each unvisited one
        for(int i = 0; i<graph.get(node).size(); i++){
            
            // if unvisited mark it and call dfs
            int neighbour = graph.get(node).get(i);
            if(visited[neighbour] != 1){
                 if(dfs(neighbour, node, graph, visited)) return true;
            }
            
            // now if node is visited, but parent is different return true
            else{
                if(neighbour != parent) return true;
            }
        }
        
        return false;
    } 
    
    public boolean isCycle(int V, int[][] edges) {
        
        // converting to adjacency list 
        
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<V; i++){
            graph.add(new ArrayList<>());       // need to initialize empty lists inside the list before adding to be able to access
        }
        
        for(int[] edge : edges){
            
            int u = edge[0];
            int v = edge[1];
            
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        
        // now we have the adj. list of the graph
        
        //loop through each node starting from 0
        // call detect cycle for each node
        // to tackle unconnected graph
        
        // initialize a visited graph
        int[] visited = new int[V];
        for(int i=0; i<V; i++){
            // call for unvisited graph
            if(visited[i] != 1){
                if(dfs(i, -1, graph, visited)) return true;
            }
        }
        return false;
        
    }
}
