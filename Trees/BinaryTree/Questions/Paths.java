package Trees.BinaryTree.Questions;

import java.util.ArrayList;
import java.util.List;

import Trees.BinaryTree.Implementation.Node;


// print out all the paths from root to all the leaf nodes
class Paths {

     // helper function to keep track of both the current path, and the result array
    public static void paths_1(Node root, String path, ArrayList<String> result){

        if(root == null) return;

    // if reached the leaf node, simply add the value to the path, add the path to the result
    // and the result array is maintained throughout the recursive calls, as it's passed by reference
        if(root.left==null && root.right==null){
            path += root.val;
            // add to the result
            result.add(path);
        }
        else{       // until a path is not fully covered, keep updating the path
            path += root.val;
            path += "->";
        }

        // recursively call for the child nodes
        paths_1(root.left, path, result);
        paths_1(root.right, path, result);
    }


    static void paths_2(Node root, List<Integer> currPath, List<List<Integer>> ans){
        
        // base case
        if(root.left == null && root.right==null){
            List<Integer> temp = new ArrayList<>(currPath);
            temp.add(root.val);
            ans.add(temp);
            return;
        }

        currPath.add(root.val);
        if(root.left!=null) paths_2(root.left, currPath, ans);
        if(root.right!=null) paths_2(root.right, currPath ,ans);

        // backtrack, clear current branch, before moving to other
        currPath.remove(currPath.size()-1);
    }



    public static void main(String[] args){
        
        // maintain an arraylist 
        // maintain a string for current path
        // recursively traverse each path
        // add to the arraylist
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);
        Node g = new Node(7);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        e.right = g; 
        
        ArrayList<List<Integer>> result = new ArrayList<>();
        ArrayList<String> strAns = new ArrayList<>();

        paths_1(a, "", strAns);
        paths_2(a, new ArrayList<>(), result);
        
        System.out.println(strAns);
        System.out.println(result);
        
    }

}