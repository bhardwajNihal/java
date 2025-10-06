package Trees.BinaryTree.Questions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import Trees.BinaryTree.Implementation.Node;

public class PathSumIII {
    

// leetcode 437 : path sum III, given a tree, give all target sum list of nodes

// approach 1
// brute
    // vague: pass most cases, not all
    // from the processed array till the leaf, pass it to find a sub arrays with target sum
    // only detects duplicate values, not nodes

    // TC = O(n^2)*2^h
    // SC = O(k*x), k being the avg length of subarr, and x such subarr in the ans
    static void pathSumIII(Node root, int target, List<Integer> pArr, Set<List<Integer>> ans){

        if(root==null) return;

        if(root.left == null && root.right==null){
            List<Integer> temp = new ArrayList<>(pArr);
            temp.add(root.val);

            List<List<Integer>> list = subarraySumK(temp, target);

            for(List<Integer> ele : list){
                ans.add(ele);
            }
            return;
        }

        pArr.add(root.val);

        pathSumIII(root.left, target, pArr, ans);
        pathSumIII(root.right, target, pArr, ans);

        pArr.remove(pArr.size()-1);
    }

    // helper
    static List<List<Integer>> subarraySumK(List<Integer> arr, int target){

        List<List<Integer>> ans = new ArrayList<>();
        for(int i =0; i<arr.size(); i++){
            int sum =0; 
            for(int j=i; j<arr.size(); j++){

                sum += arr.get(j);

                if(sum==target){
                    List<Integer> temp = new ArrayList<>();
                    for(int k = i; k<=j; k++){
                        temp.add(arr.get(k));
                    }
                    ans.add(temp);
                }

            }
        }
        return ans;
    }



// correct approach



    public static void main(String[] args) {
        
        List<Integer> arr = new ArrayList<>();
        // {1,6,3,4,2,2,2}
        // arr.add(1);
        // arr.add(6);
        // arr.add(3);
        // arr.add(1);
        // arr.add(4);
        // arr.add(2);
        // arr.add(10);

        Node a = new Node(0);
        Node b = new Node(1);
        Node c = new Node(1);
        // Node d = new Node(3);
        // Node e = new Node(2);
        // Node f = new Node(11);
        // Node g = new Node(3);
        // Node h = new Node(-2);
        // Node i = new Node(1);
        
        // Node h = new Node(-8);
        // connecting the nodes to get the desired tree structure
        a.left = b;
        a.right = c;
        // b.left = d;
        // b.right = e;
        // c.right = f; 
        // d.left = g;
        // d.right = h;
        // e.right = i;
        Set<List<Integer>> ans = new HashSet<>();

        pathSumIII(a, 1, new ArrayList<>(), ans);

        System.out.println(ans);



    }
}
