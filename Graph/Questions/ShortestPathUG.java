package Graph.Questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathUG {
    

    // approach
    
    // will maintain a distance array, with initially set a infinity
    
    // will apply simple bfs
    // explore all the neighbours, starting from the source
    // update the distance array, compare current distance with already present value, if lesser then update and add the node to the queue
    // repeat till the queue becomes empty
    
    
    // sc = O(3N)    // one for the graph, the que, and the dist array
    // tc = O(V + 2E)   // standard bfs tc
            
    public int[] shortestPath(ArrayList<ArrayList<Integer>> graph, int src) {

        int m = graph.size();

        // intitialize a distance array
        // with all value initially as infinity
        int[] dist = new int[m];
        Arrays.fill(dist,Integer.MAX_VALUE);
        
        
        // now update distance of the source
        // intialize a que and add the src to it
        dist[src] = 0;
        Queue<Integer> que = new LinkedList<>();
        
        que.add(src);
        
        
        // now simple bfs
        // explore all the neighbours and update the distance with the min value
        
        while(!que.isEmpty()){
            
            // get the top ele and pop
            int node = que.peek();
            que.remove();
            
            for(int i=0; i<graph.get(node).size(); i++){
                
                int neigh = graph.get(node).get(i);
                int ndist = dist[node] + 1;       // calculating neighbour distance, by adding 1 to the dist of the parent till now
                
                // compare current distance with that of already present in the dist array for the neighbour
                // if dist is lesser 
                // update the dist array and add the node to the que
                if(ndist < dist[neigh]){
                    
                    dist[neigh] = ndist;
                    que.add(neigh);
                }
            }
        }
        
        
        for(int i =0;  i<m ; i++){
            if(dist[i] == Integer.MAX_VALUE) dist[i] = -1;
        }
        
        return dist;
    }
}
