package Trees.BinaryTree.Questions;

import java.util.ArrayList;

import Trees.BinaryTree.Implementation.Node;

public class LowestCommonAncester {
    

    // 1st approach
    // using dfs, get the path for each of the given nodes
    // now we have the path
    // then the last last node, before 1st mismatch is the answer

    // helper to find the path for the given node
    public static boolean getPath(Node root, int target, ArrayList<Node> path){

        if(root==null) return false;

        // add current node value to the path
        path.add(root);

        // check if the current node is the desired one
        if(root.val == target) return true;

        // if not, check for the child nodes
        boolean getLeft = getPath(root.left, target, path);
        boolean getRight = getPath(root.right, target, path);

        //if any of the child paths has the target, means we are on the correct parent node
        // return true for further search
        if(getLeft || getRight) return true;

        //finally neither the parent, nor any of its child has the target, 
        // means we are  on the wrong path
        // so backtrack

        path.remove(path.size()-1);     // remove last index
        return false;

    }

    public static Node findPath(Node root, Node node1, Node node2){

        ArrayList<Node> node1Path = new ArrayList<>();
        ArrayList<Node> node2Path = new ArrayList<>();

        getPath(root, node1.val, node1Path);
        getPath(root, node2.val, node2Path);

        // now we have path to both the nodes
        // start to traverse through the list
        // 1 uncommon ele found, the previous index is the answer

        Node ans = null;
        int i = 0;
        while((i<node1Path.size()) && i<node2Path.size()){
            if(node1Path.get(i) != node2Path.get(i)) break;     // break as soon as 1st mismathch found
            ans = node1Path.get(i);     // have the ans from previous iteration
            i++;
        }
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
        // b.right = e;
        c.left = f;
        c.right = g; 
        f.left = e;

        ArrayList<Node> ans = new ArrayList<>();

        getPath(a, 5, ans);
        System.out.println(ans);
    }
    
}
