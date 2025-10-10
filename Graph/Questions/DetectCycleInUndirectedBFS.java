package Graph.Questions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetectCycleInUndirectedBFS {
    

    // tc = O(N) + O(2E)     // no. of nodes + summation of degrees (total no. of edges);
    // sc = 2 * O(N)        // visited array and que size in worst case
    static class Pair{
        
        int first; 
        int second; 
        
        public Pair(int f, int s){
            this.first = f;
            this.second = s;
        }
    }
    
    static boolean detectCycle(int node, List<List<Integer>> graph, int[] visited){
        
        // initialize a queue
        // to store the current node and its parent
        Queue<Pair> que = new LinkedList<Pair>();
        
        
        // add curr node, mark as visited
        que.add(new Pair(node, -1));       // 1st node has no parent
        visited[node] = 1;
        
        
        // apply bfs
        // to traverse through all nodes
        // check if any node is visited already but with different parent
        // if so return true, else false
        
        while(!que.isEmpty()){
            
        // extract the top node and remove
            int currNode = que.peek().first;
            int parent = que.peek().second;
            que.remove();
            
        // traverse through all its neighbours
        // check if the neighbour is visited and not its parent
            for(int i =0; i<graph.get(currNode).size(); i++){
                
                int neighbour = graph.get(currNode).get(i);
                
                // if neighbour in not visited, simply add to que and mark visited
                if(visited[neighbour] != 1){
                    visited[neighbour] = 1;
                    que.add(new Pair(neighbour, currNode));    // node and its parent added
                }
                
                // now if the node is visited
                // check if it has a different parent
                // as if so, then it has already been visited, thus confirming a cycle in the graph
                else{
                    if(neighbour != parent) return true;
                }
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
                if(detectCycle(i, graph, visited)) return true;
            }
        }
        return false;
        
    }

   
}
