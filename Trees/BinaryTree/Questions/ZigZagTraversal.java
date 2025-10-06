package Trees.BinaryTree.Questions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Trees.BinaryTree.Implementation.Node;

public class ZigZagTraversal {

    static List<List<Integer>> bfsTree2(Node root) {

       List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans; // at this point ans is empty

        Queue<Node> que = new LinkedList<>();
        // add the root to the queue
        que.add(root);

        // flag to level reversal
            boolean leftToRight = true;     // global, to avoid reset on each iteration
        while (!que.isEmpty()) {

            int levelSize = que.size(); 
            List<Integer> levelNodes = new ArrayList<>(); // temp list to store current level node values

            // looping through each level
            for (int i = 0; i < levelSize; i++) {
 
                Node temp = que.poll();         // returns and remove
                // adding top nodes child to the queue
                if (temp.left != null)
                    que.add(temp.left);
                if (temp.right != null)
                    que.add(temp.right);

                // now adding current level node to temp ans list
                if(leftToRight) levelNodes.add(temp.val);
                else levelNodes.add(0, temp.val);   // always add to the 0th index, thus maintaining reverse order

            }

            // reversing the flag after each level traversal
            leftToRight = !leftToRight;
            ans.add(levelNodes);
        }

        // finally return ans
        return ans;

    }
}
