package Trees.BinaryTree.Questions;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import Trees.BinaryTree.Implementation.Node;

public class BoundaryTraversal {
    
    // getting all the left nodes, root exclusive
    static void left(Node root, ArrayList<Integer> ans){
    
        // for null node, or leaf node
        if(root==null || (root.left==null && root.right==null)) return;

        // recursively call all the left nodes, and add to the ans
        ans.add(root.val);
        if(root.left!=null) left(root.left, ans);
        else left(root.right, ans);     // if left doesn't exist, then check for right node
    }


// getting all the leaf nodes, root exclusive
    static void leaves(Node root, ArrayList<Integer> ans){
        
        if(root==null) return;      // if node is null simply return
        if(root.left==null && root.right==null) ans.add(root.val);  // add only leaf nodes to ans

        if(root.left!=null) leaves(root.left, ans);     // recursively call for all the childs
        if(root.right!=null) leaves(root.right, ans);
    }


// getting all the right nodes, root exclusive
    static void right(Node root, ArrayList<Integer> rightList){

        if(root.left==null && root.right==null) return;

        // recursively call all the right nodes, and add to the ans
        rightList.add(root.val);
        if(root.right!=null) right(root.right, rightList);
        else right(root.left, rightList);       // if the right node doesn't exist
    }
    
    ArrayList<Integer> boundaryTraversal(Node root) {
        
        ArrayList<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        
        // adding root upfront
        ans.add(root.val);
        // later call for left, and right with roots children

        // adding all the left nodes, exclusive of the root, and leaf node
        if(root.left!=null) left(root.left, ans);

        // add all the leaf nodes
        leaves(root.left, ans);     // avoiding root to be added again
        leaves(root.right, ans);    // calling left and right child of root, exclusive of root itself, as root is already added to ans, not to  be added again, as if its passed it fulfills the criteria of leaf node, thus gets added to the answer list again
        
        // adding all the right nodes  (reverse order, exclusive of leaf and root node)
        ArrayList<Integer> rightNodes = new ArrayList<>();
        if(root.right!=null) right(root.right,rightNodes);

        // now rightNodes have all the right nodes, including the root
        // reverse it, 
        // add all ele to the ans list

        Collections.reverse(rightNodes);
        for(int i = 0; i<rightNodes.size(); i++){
            ans.add(rightNodes.get(i));
        }

        return ans;
        
    }
}
