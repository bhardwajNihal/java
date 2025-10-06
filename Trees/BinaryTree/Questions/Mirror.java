package Trees.BinaryTree.Questions;

import Trees.BinaryTree.Implementation.Node;

public class Mirror {
    
    static boolean isMirror(Node t1, Node t2) {
        if(t1 == null && t2 == null) return true;
        if(t1 == null || t2 == null) return false;
        if(t1.val != t2.val) return false;
        
        return isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }

}
