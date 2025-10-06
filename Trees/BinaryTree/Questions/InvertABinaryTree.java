package Trees.BinaryTree.Questions;

import Trees.BinaryTree.Implementation.Node;

public class InvertABinaryTree {
    
    // leetcode 226
    // simply swap each nodes left and right
    // TC = O(N);
    // SC = O(h)
    static void invert(Node root){
        if(root==null || (root.left==null && root.right==null)) return;
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

        if(root.left!=null) invert(root.left);
        if(root.right!=null) invert(root.right);
    }
}
