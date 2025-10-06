package Trees.BinaryTree.Questions;

import java.util.HashMap;
import java.util.Map;

import Trees.BinaryTree.Implementation.Node;

public class TreeFromPostAndInorder {


    static Node build(
                        int[] postorder, int postStart, int postEnd,
                        int [] inorder, int inStart, int inEnd, 
                        Map<Integer, Integer> inIdx
    ){

        if(postStart > postEnd || inStart > inEnd) return null;

    // now the root will be the last ele of postorder traversal
        Node currRoot = new Node(postorder[postEnd]);

        int inRootIdx = inIdx.get(currRoot.val);

        int numsLeft = inRootIdx - inStart;

    // same as the pre and inorder, 
    // just the span of start and end of postorder of subtree is different
        currRoot.left = build(postorder, postStart, postStart+numsLeft-1, inorder, inStart, inRootIdx-1, inIdx);
        currRoot.right = build(postorder, postStart+numsLeft, postEnd-1, inorder, inRootIdx+1, inEnd, inIdx);
    
        return currRoot;

    }
    public Node buildTree(int[] inorder, int[] postorder) {
        
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }

        Node root = build(postorder, 0, postorder.length-1,
                        inorder, 0, inorder.length-1, 
                        map);

        return root;

    }
    
}
