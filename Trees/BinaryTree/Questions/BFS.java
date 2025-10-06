package Trees.BinaryTree.Questions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import Trees.BinaryTree.Implementation.Node;

public class BFS {
    
    static void bfsTree(Node root){

        if(root==null) return;

        Queue<Node> que = new LinkedList<>();
        
        que.add(root);
        while (!que.isEmpty()) {
            
            // take the top node
            Node temp = que.peek();
            if(temp.left != null) que.add(temp.left);
            if(temp.right != null) que.add(temp.right);
            System.out.print(temp.val + " ");
            que.remove();
        }

    }


    // return ans list
    static List<List<Integer>> bfsTree2(Node root){

        List<List<Integer>> ans = new ArrayList<>();
        if(root==null) return ans;      // at this point ans is empty

        Queue<Node> que = new LinkedList<>();   
        // add the root to the queue
        que.add(root);

        while (!que.isEmpty()) {
            
           int levelSize = que.size();      // at very 1st, the que size is 1, inner loop will run 1 time, adding the node's value to the temp  list, then temp be add to the final ans, then add its child to the queue, node making the que size to be two, so for next time the inner loop will run two time this time, adding the nodes at that level to the temp list, this will continue till last level
            List<Integer> levelNodes = new ArrayList<>();       // temp list to store current level node values
           // looping through each level
           for(int i =0; i<levelSize; i++){

            Node temp = que.peek();
            // adding top nodes child to the queue
            if(temp.left!=null) que.add(temp.left);
            if(temp.right!=null) que.add(temp.right);

            // now adding current level node to temp ans list
            levelNodes.add(temp.val);
            que.remove();               // removing the top ele from the queue
           }

           ans.add(levelNodes);
        }

        // finally return ans
        return ans;

    }



    public static void main(String[] args) {
        
        //creating node
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);
        Node g = new Node(7);
        // Node h = new Node(-8);
        // connecting the nodes to get the desired tree structure
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g; 
        bfsTree(a);
    }
}
