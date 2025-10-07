package Trees.BST.Ques;

import Trees.BinaryTree.Implementation.Node;

public class Search {
    
    // search for a given value in a bst
    /// simple, look at left if smaller, right if greater same as binary search
    // tc = O(logN)
    // sc = O(h)
    public Node searchBST(Node root, int val) {
        
        if(root==null) return null;

        if(root.val == val) return root;

    // look at left subtree if value is less than the current node
        if(val > root.val) return searchBST(root.right, val);
    // if greater then at the right
        if(val < root.val) return searchBST(root.left, val);

        return null;

    }
}
