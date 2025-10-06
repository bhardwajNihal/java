package Trees.BinaryTree.Questions;

import Trees.BinaryTree.Implementation.Node;

public class SameTree {
    public boolean isSameTree(Node p, Node q) {
        
        if(p==null && q==null) return true;
        if(p==null && q!=null) return false;
        if(p!=null && q==null) return false;
        // check root
        if(p.val != q.val) return false;
        
        return true && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
