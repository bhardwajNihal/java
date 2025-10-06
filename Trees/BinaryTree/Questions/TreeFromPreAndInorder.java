package Trees.BinaryTree.Questions;

import java.util.HashMap;
import java.util.Map;

import Trees.BinaryTree.Implementation.Node;

public class TreeFromPreAndInorder {
    

    // given the pre and inorder travesal, construct the tree

    // TC 
        // best = O(NlogN)
        // avg  = O(N*h)
        // worst = O(N^2)

    // SC = O(2^h)

    static Node build(
                        int[] preorder, int preStart, int preEnd,
                        int [] inorder, int inStart, int inEnd, 
                        Map<Integer, Integer> inIdx
    ){

        if(preStart > preEnd || inStart > inEnd) return null;

        // find root of the tree
        Node currRoot = new Node(preorder[preStart]);

        // find the root index in the inorder arr, through map
        int inRootIdx = inIdx.get(currRoot.val);

        // now we have the root, out of the inorder array
        // left part will be the left subtree, and same for right
        // thus finding the number of ele to the left of inorder
        int numsLeft = inRootIdx - inStart;

        // for the preorder array, next numsleft ele will be the preorder for left subtree
        // and the rest, to the right will be pre for right subtree

        // recursively call to create and left and right subtree, as found respective  pre, and inorder array

        currRoot.left = build(preorder, preStart+1, preStart+numsLeft, inorder, inStart, inRootIdx-1, inIdx);
        currRoot.right = build(preorder, preStart+numsLeft+1, preEnd, inorder, inRootIdx+1, inEnd, inIdx);
    
        return currRoot;

    }

    public Node buildTree(int[] preorder, int[] inorder) {
        
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }

        Node root = build(preorder, 0, preorder.length-1,
                        inorder, 0, inorder.length-1, 
                        map);

        return root;

    }
}
