package groupWork;

public class Algo_30_TreeNode {




/*
    public static TreeNode lowestCommonAncestorOfABinaryTree(TreeNode root, TreeNode p, TreeNode q){
        if(root==null){
            return null;
        }
        if(root==p || root==q){ // if root is equal to p or q return root
            return root;
        }
        TreeNode left = lowestCommonAncestorOfABinaryTree(root.leftNode, p, q);
        TreeNode right = lowestCommonAncestorOfABinaryTree(root.rightNode, p, q);

        if(left==null){        // if left is null means p or q does not match with left
            return right;
        }else if(right==null){ // if right is null means p or q does not match with right
            return left;
        }
        return root;  // if both of them has a node then we found ancestor of them
    }

 */
}
