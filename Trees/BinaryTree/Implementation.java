package Trees.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class Implementation {
    
    // creating a node to store the value and child node references
    public static class Node{
        public int val;
        public Node left;
        public Node right;

        public Node(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    // simple display of all the node of a tree
    public static void display(Node root){

        if(root == null) return;

        // print current node
        System.out.print(root.val + " ");

        // call left node
        display(root.left);
        // call right
        display(root.right);
    }

    // level-wise display
    // public static void displayLevelwise(Node root){

    //     if(root == null) return;

    //     // print current node, along with the children
    //     System.out.print(root.val + " ");
    //     System.out.print(root.left!=null ? root.left.val + " " : null);
    //     System.out.print(root.right!=null ? root.right.val + " " : null);

    //     System.out.println();

    //     // call child's children
    //     displayLevelwise(root.left);
    //     displayLevelwise(root.right);
        
    // }

    public static void displayChilds(Node root) {
        if(root == null) return;

        // print current node
        System.out.print(root.val + "-->");
        System.out.print(root.left!=null ? root.left.val+", " : "N ");
        System.out.println(root.right!=null ? root.right.val : "N ");

        // call child nodes
        displayChilds(root.left);
        displayChilds(root.right);
    }


// getting the size of the tree, maintaining a global count var
    // static int count = 0;
    // static void treeSize(Node root){

    //     if(root == null) return;
    //     count++;
    //     treeSize(root.left);
    //     treeSize(root.right);
        
    // }


    // better approach to count size;

    static int size(Node root){

        if(root == null) return 0;

        // can't we say that size of the tree = 1(i.e the root itself) + size of leftNode + size of rightNode
        return 1 + size(root.left) + size(root.right);
    }


    // sum of tree nodes
    static int sum(Node root){
        if(root == null) return 0;

        return root.val + sum(root.left) + sum(root.right); 
    }


    // max value of any node of the tree
    static int maxVal(Node root){

        if(root == null) return Integer.MIN_VALUE;

        // everytime, compare the current root value with its left and right child, so on...
        return Integer.max(root.val,Integer.max(maxVal(root.left), maxVal(root.right)));
    }


    // height✅
    // height of a tree is the max no. of edges from the leaf node to the root
    // approach
    // using recursion, count the height of each child successively
    // the max of all is the height of the tree
    public static int height(Node root){

        // if the root is null or its a leaf node, then height is 0
        if(root==null || (root.left==null && root.right==null )) return 0;

        // if the root a has a child, height is 1
        // so everytime the function is called recursively, child node is called, adding to 1,
        // the net height is the max of the height of left child and right one
        return 1 + Integer.max(height(root.left), height(root.right));
    }


    // min value
    static int minVal(Node root){

        if(root == null) return Integer.MAX_VALUE;

        // everytime, compare the current root value with its left and right child,
        // take min out of child nodes, and further min out it, and root node
        return Integer.min(root.val,Integer.min(minVal(root.left), minVal(root.right)));
    }

    // product of values
    static int product(Node root){
        if(root == null) return 1;

        return root.val * product(root.left) * product(root.right);
    }

    // complexity analysis
        // for given height h of the tree
        // level = h+1;
        // for given level L
            // max no. of nodes is (2^L) - 1
        // Thus, for given no. of nodes N, there is logN levels

        // as the no. of level grows, no. of nodes grow by 2^L
        // Thus, for traversal in a tree of level given L, 
            // time complexity = O(2^N);


    // types of traversals in a binary tree, are
        // preorder     (Root --> left --> right)
        // inorder      (Left --> Root --> right)
        // postorder    (left --> rigth --> root)
    
    // traversals can be implement in a very simple and efficient way using recursion

    static void preOrder(Node root){

        if(root == null) return;

        // simply print the root, then call left, then call right
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    static void inOrder(Node root){

        if(root == null) return;

        // this time call the left node first, then print the root, then call right node
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }
    static void postOrder(Node root){

        if(root == null) return;

        // call left, then right, then print the root
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
        
    }

    // level order traversal (Breadth First Search (BFS))
        // by using a QUEUE
        // traversal can be done in complexity of O(N);
    // not a recursive way
    // simple iteration
    // add a root to the que
        // before removing it from it, add its child to the queue, then print it
    // repeat same with every node
    static void BFS(Node root){
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

    


    public static void main(String[] args) {
        
        // basic binary tree implementation
        //            1
        //     2             3
        //   4   5     null      6
        //                     7   8

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
        // f.left = g;
        // f.right = h;

        // display(a);
        // System.out.println();

        // displayChilds(a);

        // treeSize(a);
        // System.out.println(count);

        // System.out.println(size(a));
        // System.out.println(sum(a));
        System.out.println("max : " + maxVal( a));
        System.out.println("height : " + height(a));
        System.out.println("min : " + minVal(a));
        System.out.println("product : " + product(a));
        

        // preOrder(a);
        // System.out.println();
        // inOrder(a);
        // System.out.println();
        // postOrder(a);
        BFS(a);


    }
}
