package Trees.BinaryTree.Questions;

import Trees.BinaryTree.Implementation.Node;

public class IsBalanced {

    // leetcode 110 - check if a tree is balanced or not

    // a tree is balanced if the difference between the height of the child nodes is no more than 1;
    // applies of each child node.

        static boolean isBalanced(Node root) {
            if(root == null || (root.left==null && root.right==null)) return true;

            // calculate height of each child for the current node
            int hl = 0;
            int hr = 0;
            // now for actual left and right height for current node, 1 should be added to connect the edge of the node to its child if they exist
            if(root.left!=null) hl = 1+height(root.left);
            if(root.right!=null) hr = 1+height(root.right);
            
            //  check the height diff, return false if more than 1
            if((hl > hr) && hl-hr > 1) return false;
            if((hr > hl) && hr-hl > 1) return false;
            // now recursively check for each node
            return isBalanced(root.left) && isBalanced(root.right);
        }

        
        // helper
        static int height(Node root){
        if(root==null || (root.left==null && root.right==null )) return 0;
        return 1 + Integer.max(height(root.left), height(root.right));
        }

}
