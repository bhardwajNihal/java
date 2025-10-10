package Graph.Traversals;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DFS {
    
    // given the adj list, apply Dfs to the graph
    // approach
        // for every node, go to the atmost depth from the node, then return
        // ignore already visited node
        // using recursion

        // for the current index
        // the 1st neighbour is traversed, then successively call for next neigbour
        // the loop calls out all the neigbours of the current node
        // which furhter calls its neighbour
        // if the node is not visited
            // add to the ans list
            // mark it as visited, to be ignored in further recursions


        // TC = O(N) + O(2E),   each vertex is visited once (because of the visited[] check).
            // for each vertex, we iterate through all its neighbors
        // SC = O(3N), ans list, visited array, and worst case call stack to be N

    static void dfs(ArrayList<ArrayList<Integer>> graph, int index, ArrayList<Integer> ans, int[] visited){

        if(graph.size()==0) return;
        if(visited[0]!=1){
            ans.add(0);
            visited[0] = 1;
        }
        for(int i =0; i<graph.get(index).size(); i++){

            int neighbour = graph.get(index).get(i);
            if (visited[neighbour] != 1) {
                // mark the ele and add to ans
                ans.add(neighbour);
                visited[neighbour] = 1;

                // further recursive call for depth traversal
                dfs(graph, neighbour, ans, visited);

            }
            
        }
    }


    public static void main(String[] args) {
        
        // initializing a graph
        // 1 --> [2, 3]
        // 2 --> [1, 5, 6]
        // 3 --> [1, 4, 7]
        // 4 --> [3, 8]
        // 5 --> [2]
        // 6 --> [2]
        // 7 --> [3, 8]
        // 8 --> [7, 4]

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        
        for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }
            for(int i=0; i<m; i++){     // iterate m times take adj nodes as input
            // take node pairs as input
                int n1 = sc.nextInt();
                int n2 = sc.nextInt();

                // add each to other's neighbour
                graph.get(n1).add(n2);
                graph.get(n2).add(n1);
        }

    

    // traversal
        ArrayList<Integer> ans = new ArrayList<>();
        int[] visited = new int[m];

        // then call for depth traversal
        dfs(graph, 0, ans, visited );

        System.out.println(ans);

    }



    
}
