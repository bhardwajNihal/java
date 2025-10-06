package Trees.BinaryTree.Questions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import Trees.BinaryTree.Implementation.Node;

public class Infectednodes {
    

    // given a tree, and an infected node
    // find out the time taken for entire tree to get infected
    // if every minute each neighbour of a node is infected


    // approach
    // maintain a queue to traverse through each node
    // a map to keep track already infected nodes
    // a map keep track of parent , as for any node only child is accessible 

    // tc = O(N)+O(N)+O(N)= O(3N)    ---, for finding start, parent and infection each
    // sc =  O(3N) ---> to keep track of parent, infected set, and in worst case the queue size

  public static int timeToInfect(Node node, Map<Node, Node> parent) {
        
        if(node==null) return 0;

        Set<Integer> infected = new HashSet<>();

        Queue<Node> que = new LinkedList<>();
        
        // adding 1st node to que, and marking it as infected
        que.add(node);
        infected.add(node.val);
        int time = 0;

        while (!que.isEmpty()) {
            
            boolean infectedNeighbours = false;
            int levelsize = que.size();     // as que size is dynamic, better to extract earlier
            // loop through the current que size for current round
            for(int i =0;  i<levelsize; i++){

                Node temp = que.poll(); // getting the current node to check for neighbours

                // checking uninfected children
                if(temp.left!=null && !infected.contains(temp.left.val)){
                    que.add(temp.left);
                    infected.add(temp.left.val);
                    infectedNeighbours = true;
                }
                if(temp.right!=null && !infected.contains(temp.right.val)){
                    que.add(temp.right);
                    infected.add(temp.right.val);
                    infectedNeighbours = true;
                }
                
                // check if parent infected
                Node currNodeParent = parent.get(temp);

                if(currNodeParent!=null && !infected.contains(currNodeParent.val)){
                    que.add(currNodeParent);
                    infected.add(currNodeParent.val);
                    infectedNeighbours = true;
                }
            }
            if(infectedNeighbours) time++;

        }                                                                                                                                                           
        
        return time;
    }   
    
    // helper to map child to its parent
    static void preOrder(Node root, Map<Node, Node> parent){

        if(root == null) return;
        
        // keeping track of parent
        if(root.left!=null) {
            parent.put(root.left,root);
            preOrder(root.left, parent);
        }
        if(root.right!=null){
            parent.put(root.right, root);
            preOrder(root.right, parent);
        }
    }
    
    // given the value of starting node, 
    // helper to find the node, given its value, for further traversal to find out infected neigbours
    static Node findStart(Node root, int start){
        
        if(root==null) return null;

        if(root.val== start){
             return root;
        }

        Node foundLeft = findStart(root.left, start);
        if(foundLeft != null) return foundLeft;
        
        return findStart(root.right, start);    // node will be found for sure
        
    }

    public int amountOfTime(Node root, int start) {
        
        // finding start node based on its val
        Node sn = findStart( root,  start);

        Map<Node, Node> parent = new HashMap<>();
        // got the parent for each node
        preOrder(root, parent);

        int time = timeToInfect(sn, parent);

        return time;
    }

}
