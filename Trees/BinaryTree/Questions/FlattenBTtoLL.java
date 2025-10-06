package Trees.BinaryTree.Questions;

import Trees.BinaryTree.Implementation.Node;

public class FlattenBTtoLL {
    

    // tc = O(N)
    // sc = O(h)
    Node prev = null;
    public void flatten(Node root) {

        if(root==null) return;

        flatten(root.right);
        flatten(root.left);
        
        root.right = prev;
        root.left = null;
        prev = root;
       
    }
}
