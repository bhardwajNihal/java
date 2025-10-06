package Trees.BinaryTree.Questions;

public class Diameter {
    
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
    // helper function to calculate height of a subtree
    // definition here: 
    // height(null) = 0
    // height(leaf node) = 0   (because of the if condition below)
    static int height(TreeNode root){
        if(root==null || (root.left==null && root.right==null )) return 0;
        return 1 + Integer.max(height(root.left), height(root.right));
    }

    // diameter
    // check for diameter for each child, return the max out of it
    // for diameter, calculate the height of both left and right child
    // then to calculate the diameter the node is also to be included
    // thus, add +1 for each left and right child if exist, 
    // finally return the max diameter out of root, right and left
    public int diameter(TreeNode root) {
         // base case : if node is null, or a leaf node, height is 0;
        if(root == null || (root.left==null && root.right==null)) return 0;

        // diameter of the node
        // sum of left and right child height
        int currentDiameter = height(root.left) + height(root.right);
        // this is needed to add the edge length between the root and its child
        if(root.left!=null) currentDiameter++;      // if left child exist, then only adding 1 makes sense
        if(root.right!=null) currentDiameter++;      // same

        return Integer.max(currentDiameter, Integer.max(diameter(root.left),diameter(root.right)));
    }


    public static void main(String[] args) {
        
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);

        a.right = b;
        b.right = c;
    }
}

