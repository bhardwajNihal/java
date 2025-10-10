package Graph.Traversals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BFS {
    
    // Breadth first search (also called as levelwise traversal)

    // usually graph are of two types
        // 1-based indexed
        // 0-based indexed

    
    // taking a 1-based indexed graph with following adjacency list
        // 1 --> [2, 6]
        // 2 --> [1, 3, 4]
        // 3 --> [2]
        // 4 --> [2, 5]
        // 5 --> [4, 8]
        // 6 --> [1, 7, 9]
        // 7 --> [6, 8]
        // 8 --> [7, 5]
        // 9 --> [6]

    // we have to do levelwise traversal

    public static void main(String[] args) {
        
    //initializing graph
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<List<Integer>> graph = new ArrayList<>();
        // initialing new list inside graph, to make it accessible, or will give index out of bound err
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
                graph.get(i).add(null);
            }


    // Traversal
    // will maintain a que to add current node and it's neighbours
    // and visited array to maintain the visited nodes
        // let say start node is 6
        int start = 1;
        Queue<Integer> que = new LinkedList<>();
        int[] visited = new int[n+1];

        que.add(start);
        visited[start] = 1;

        while(!que.isEmpty()){

            int temp = que.peek();

            for(int i = 0; i<graph.get(temp).size(); i++){
                
                int neighbour = graph.get(temp).get(i);
                if(visited[neighbour] != 1){        // if neighbour not visited
                    
                    que.add(neighbour);         // add to que, and mark visited
                    visited[neighbour] = 1;
                }
            }
            // finally print and remove top ele
            System.out.print(temp + " ");           // successfully prints graph levelwise
            que.remove();
        }
    }


    // TC = O(N) + O(2E)
        // N for the que
        // 2E, inside the que, for loop will run no. of degrees no. of times
        // and the loop in itself run n no. of times
        // and total degrees = 2E, where E is no. of edges

    // SC = O(2N), one for the queue, and one for the visited array
    // for the ans list , sc = O(3N)



    // gfg solution
    // given the adj list of 0-indexed based graph
    // Function to return Breadth First Search Traversal of given graph.
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> graph) {
        // code here
        
        Queue<Integer> que = new LinkedList<>();
        int[] visited = new int[graph.size()];      // graph is 0 based

        que.add(0);
        visited[0] = 1;
    
    // final output array
    ArrayList<Integer> bfs = new ArrayList<>();

        while(!que.isEmpty()){

            int temp = que.peek();
        
            for(int i = 0; i<graph.get(temp).size(); i++){
                
                int neighbour = graph.get(temp).get(i);
                if(visited[neighbour] != 1){        // if neighbour not visited
                    
                    que.add(neighbour);         // add to que, and mark visited
                    visited[neighbour] = 1;
                }
            }
            // finally add temp to traversal graph and remove top ele
            bfs.add(temp);
            que.remove();     
        }
        
        return bfs;
    }
}
