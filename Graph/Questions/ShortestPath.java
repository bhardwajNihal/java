package Graph.Questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ShortestPath {
    

     // approach
    
    // adj list of the graph will contain pairs, with neighbours along with their edge weight
    
    // applying topo sort, add the nodes to the stack
    
    // maintain a distance array initially all elements set to infinity
    // now, take the top ele from the stack
    
    // compare to the current value of the distance array, corresponding to the current node
    // update if the weight is lesser



    // custom class to store pair
    static class Pair{
        
        int node;
        int weight;
        
        public Pair(int n, int w){
            this.node = n;
            this.weight = w;
        }
    }
    
    
    // topo sort algo
    static void topo(List<List<Pair>> graph, int currnode, Stack<Integer> st, int[] visited){
        
        // mark as visited
        visited[currnode] = 1;
        
        // dfs and mark neighbours till depth
        int m = graph.get(currnode).size();
        for(int i = 0; i<m; i++){
            
            int neighbour = graph.get(currnode).get(i).node;
            
            // if not visited, call for dfs
            if(visited[neighbour] != 1){
                topo(graph, neighbour, st, visited);
            }
        }
        
        // add to stack while backtracking
        st.push(currnode);
    }
    
    public int[] shortestPath(int V, int E, int[][] edges) {
        
        
        // creating adjacency list to store pairs
        
        List<List<Pair>> graph = new ArrayList<>();
        for(int i = 0; i< V; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] edge : edges){
            
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            
            graph.get(u).add(new Pair(v,w));
        }
        
        
        // now we have the graph in the desired format
        
        
        // prepare the stack using topo sort
          
        Stack<Integer> st = new Stack<>();
        int[] visited = new int[V];
        for(int i = 0; i<V; i++){
           if(visited[i] != 1) topo(graph, i, st, visited);
        }
        
        // for unconnected node, the visited will be zero
        // based on that later, dist for that node will be marked as -1
        
        
        // now we have the nodes in the stack in reverse topo order
        // just take them one by one
        // compare the weight of neighbour, add the minimum one
        
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        // remove the very 1st ele from the stack
        // update the dist array for that node as 0, 
        
        dist[0] = 0;
        
        while(!st.isEmpty()){
            
            int top = st.peek();
            st.pop();
            
            // explore all the neighbours
            // add the weight to the dist array
            for(int i =0; i<graph.get(top).size(); i++){
                
                int neigh = graph.get(top).get(i).node;
                if(dist[top] != Integer.MAX_VALUE){
                    int weight = graph.get(top).get(i).weight + dist[top];  // add previous weight till the neighbour
                    dist[neigh] = Integer.min(dist[neigh], weight);
                }
            }
        }
        
        // now once the stack is empty
        // we have the dist array with the shortest part from 0 to all the nodes
        
        // add to ans and return 
        int[] ans = new int[V];
        Arrays.fill(ans,-1);
        for(int i = 0; i<V; i++){
            if(dist[i] != Integer.MAX_VALUE){
                ans[i] = dist[i];
            }
        }
        
        return ans;
        
    }
}
