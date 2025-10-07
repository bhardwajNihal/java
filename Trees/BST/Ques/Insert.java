package Trees.BST.Ques;

import Trees.BinaryTree.Implementation.Node;

public class Insert {
    
// given a value insert to bst
// if val is greater insert at right, if smaller then left

    // tc = O(logN)  .. very efficient
    // sc = O(h)
    public Node insertIntoBST(Node root, int val) {
        
        Node node = new Node(val);
        if(root==null) return node;     // for empty tree, new node is the new tree
    
    // if node value is smaller than root
        if(node.val < root.val){
            // root's left is null simply insert the node to the left
            if(root.left==null) root.left = node;
            // if the spot in not empty simply call recursively to insert to child nodes
            else insertIntoBST(root.left, node.val);
        } 
    // same for right
        else {
            if(root.right==null) root.right = node;
            else insertIntoBST(root.right, node.val);
        }


        return root;
    }
}
