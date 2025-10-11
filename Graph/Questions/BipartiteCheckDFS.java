import java.util.Arrays;

public class BipartiteCheckDFS {
    


    
    // 2nd approach
    // using dfs
    // explore till the depth of the graph
    // check color the unvisited node with opposite
    // if colored move to next neighbour
    

    static boolean dfs(int[][] graph, int node, int[] color, int currColor){

        // color the uncolored node
        if(color[node] == -1) color[node] = currColor;

        // traverse through all the neighours till depth
        int m = graph[node].length;

        for(int i = 0; i<m; i++){

            int neighbour = graph[node][i];

            // check if colored
            
            // if not - call for dfs with opposite color
            if(color[neighbour] == -1){
                int nColor = currColor==0 ? 1 : 0; 
                if(!dfs(graph, neighbour, color, nColor)) return false; 
            }

            // if colored, check if the node has the intended color
            // if color matches the color of the neighbour return false
            else{
                if(color[neighbour] == currColor) return false;
            }
        }

        // at end if the no conflicts found with color till the end or complete traversal
        return true;

        

    }


    public boolean isBipartite(int[][] graph) {
        int m = graph.length;
        int[] color = new int[m];
        Arrays.fill(color, -1);
        
        // call for dfs and fill the color 
        for(int i = 0; i< m; i++){
            
            if(color[i] == -1){
                if(!dfs(graph, i, color, 0)) return false;
            }
        }
        return true;
    }
}
