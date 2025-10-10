package Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Intro {

    public static void main(String[] args) {

        // collection of nodes
        // anything with nodes and edges can be called as graphs, that's why linked list
        // and trees can also be called as graphs
        // interconnected to one or more neighbours

        // can be
        // directed
        // undirected

        // horizontal line connecting nodes is called edge
        // can be
        // unidirectional - in case of directed graph
        // bidirectional - in case of undirected graph

        // cycles in graph
        // in case of directed graph
        // if we start from a node, and be able to reach back to it
        // so directed graphs can be
        // directed cyclic graph (DCG)
        // directed acyclic graph (DAG)

        // in case of undirected graph
        // if there's a single cycle, it's called a undirected cyclic graph
        // can't assume a graph to be cyclic unless explicitely mentioned

        // paths
        // collection of nodes, given each node is reachable
        // a node cannot appear twice in a path
        // also for a path to be valid, every adjacent nodes should have an edge between
        // them

        // degrees in graph
        // for an undirected graph, the no. of nodes that are attacted to the node is
        // called its degree
        // total degree = 2 * no. of edges (as every edge is associated to two nodes)

        // for directed graph
        // there - indegree and outdegree of a node
        // indegree - no. of incoming edges
        // outdegree - no. of outgoingedges

        // edge weight
        // default weight of an edge is 1
        // can be any positive integer

        // representation
        // 1st given the no. of nodes and edges
        // for example
        // for graph n, m
        // n = 5 --. no. of nodes
        // m = 6 --> no. of edges

        // follwing this, given m no. of pairs of nodes connected to each other

        // matrix representations

        // 1. adjacency matrix
        // in a n X n matrix
        // for adjacent pairs mat[i][j] and mat[j][i] are marked as 1 for nodes i and j
        // rest are marked as 0
        // takes O(N^2) space , where N is the no. of nodes

        // if it's a weighted graph
        // then for the cell depicting adjacent cells
        // instead of storing 1, will store the weight of the edge given

        // check if the nodes are 1-based indexed

        // then define a (n+1) x (n+1) matrix
        // so that we have index corresponding to each node

        // for a given graph , n = 5, m = 6
        // 1 --- 2
        // |     | \
        // |     | 5
        // |     | /
        // 3 --- 4
        
        // take no. of nodes and edges as input
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int m = sc.nextInt();
            // define a matrix of size n+1
        //     int[][] matrix = new int[n + 1][n + 1];

        //     // loop through, no. of edges no. of times
        //     // take the pair as input
        //     // mark corresponding index depicting nodes as 1
        //     for (int i = 0; i <= n; i++) {
        //         int n1 = sc.nextInt();
        //         int n2 = sc.nextInt();       // in case of weighted graph, will take 3rd input, later instead of 1, will store it in the adj. matrix
        //         matrix[n1][n2] = 1;
        //         matrix[n2][n1] = 1;
        //     }

        //     // printing out the matrix
        //     // successfully shows the relationship between nodes, and hence the graph
        //     for (int[] row : matrix) {
        //         for (int ele : row) {
        //             System.out.print(ele + " ");
        //         }
        //         System.out.println();
        //     }

        // 2. adjacency list
        // much space optimized method
        // here, we maintain an array of size n+1, (n = no. of nodes)
        // for every index starting from 1
        // we maintain the list of it's neighbour
        // Space complexity = 2 * O(E), where E is the no. of edges
        // for a directed graph space is O(E)

            // initialize an Arraylist of ArraylisT
            // it to have n+1 lists

            List<List<Integer>> list = new ArrayList<>(n+1);

            // create n+1 empty lists (1-indexed graph), to fill to the outer list
            for (int i = 0; i <= n; i++) {
                list.add(new ArrayList<>());
            }
            for(int i=0; i<m; i++){     // iterate m times take adj nodes as input
            // take node pairs as input
                int n1 = sc.nextInt();
                int n2 = sc.nextInt();

                // add each to other's neighbour
                list.get(n1).add(n2);
                list.get(n2).add(n1);       // in case of directed graph, remove this
                                            // only one way depiction
            }

            // printing the graph
            // each node along with their neighbours
            for(int i =0; i<list.size(); i++){
                System.out.println(i+" --> " +list.get(i));
            }


        // in case of weighted graph
        // instead of storing the neighbours directly
        // will store pairs, with 2nd no. depicting weight




    // Connected components
        // not all the nodes in the graph will be necessarily connected
        // there may be given different collections to connected nodes
        
        // in that case
        // if the grapb is 1-based index
        // for that
        //  will loop through each nodes
            // for let say 10 nodes
                // loop from 1 to 10
            // check if the particular node is not visited
            // then call the traversal method giving that node
            // same for all 
    

    }

}


// theory✅
// representations✅
// traversals✅

// questions

// no. of provinces✅
// no. of islands ✅
// floodfill✅
// rottenoranges✅