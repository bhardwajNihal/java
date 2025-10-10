import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalSort {
    

    // Perform DFS on all unvisited nodes.
    // After visiting all neighbours of a node, push it onto a stack (post-order).
    // Finally, reverse the stack (or pop sequentially) → gives topological order.

    // sc = O(2n);      // visited array, and stack
    // tc = O(V + E)    // standard directed graph dfs

    static void sort(List<List<Integer>> graph, int node,int[] visited, Stack<Integer> st){
        
        // mark as visited
        if(visited[node]!=1){
            visited[node] = 1;
        }
        
        // traverse through each neighbour
        int n = graph.get(node).size();
        for(int i = 0;  i<n; i++){
            
            // call for dfs for unvisited neighbours
            int neighbour = graph.get(node).get(i);
            
            if(visited[neighbour] != 1){
                sort(graph, neighbour, visited, st);
            }
        }
        
        // backtrack, and add to the stack
        st.push(node);
        
    }
    
    
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
       
       // converting to adj. list
       List<List<Integer>> graph = new ArrayList<>();
       
       for(int i = 0;  i<V;  i++){
           graph.add(new ArrayList<>());
       }
       
       for(int[] edge : edges){
           
           int u = edge[0];
           int v = edge[1];
           
           graph.get(u).add(v);
       }
       
       
       // now we have the graph's adj. list
       
       int[] visited = new int[V];
       Stack<Integer> st = new Stack<>();
       
       // call for dfs for each unvisited node
       for(int i = 0; i<V; i++){
           
           if(visited[i]!=1){
               sort(graph, i, visited, st);
           }
       }
       
       
       // finally add stack ele to a list and return
       
       ArrayList<Integer> ans = new ArrayList<>();
       while(!st.isEmpty()){
           ans.add(st.pop());
       }
       
       return ans;
        
    }
}
