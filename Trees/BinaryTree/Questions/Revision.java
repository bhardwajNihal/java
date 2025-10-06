package Trees.BinaryTree.Questions;

import Trees.BinaryTree.Implementation.Node;

public class Revision {

    // helper 
    static int height(Node root){
        if(root == null || (root.left==null && root.right==null)) return 0;
        return 1 + Integer.max(height(root.left),height(root.right));
    }



    // given two nodes, have to find the lowest common ancestor
    // approach
    // get the path to both the node
    // the last common node is the ans
    

    // helper, to find the path to a target node
    // static List<Integer> path(Node root, int target)


    
}
