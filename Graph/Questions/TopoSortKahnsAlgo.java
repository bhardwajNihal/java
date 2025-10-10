import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopoSortKahnsAlgo {
    

    // kahn's algorithm
    
    // maintain an indegree array
    // contains no. of incoming edges to each node
    
    
    // initialize a queue
    // push nodes with indegree 0
    // decrement the indegree of all its neighbour, push to ans array
    // repeat same process with all the nodes
    // till all indegree becomes 0
    
    
    // tc = O( V + E);
    // sc = O(2N) 
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
       
       
       // defining indegree
       int[] indegree = new int[V];
       for(int i = 0 ; i<V; i++){
           
           for(int neighbour : graph.get(i)){
               indegree[neighbour]++;
           }
       }
       
       // now we have the indegree array
       
       
       //initializing a queue
       Queue<Integer> que = new LinkedList<>();
       
       // push nodes to que with indegree 0
       for(int i=0; i<indegree.length; i++){
          if(indegree[i] == 0) que.add(i);
       }
       
       
       ArrayList<Integer> ans = new ArrayList<>();
       // now decrement indegree of neighbours, if become zero add them to ans and queue to further mark mark their neighbours
       while(!que.isEmpty()){
           
           // add to ans ans remove
           int node = que.peek();
           ans.add(node);
           que.remove();
           
           // decrement indegree of the neighbours
           for(int i = 0; i<graph.get(node).size(); i++){
               int neighbour = graph.get(node).get(i);
               indegree[neighbour]--;
               if(indegree[neighbour] == 0) que.add(neighbour);
           }
           
          
       }
      
      
      return ans;
      
    }
}
