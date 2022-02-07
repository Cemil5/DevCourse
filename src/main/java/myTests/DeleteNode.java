package myTests;

public class DeleteNode {
/*
    public static int Min(TreeNode root )
    {
        while(root.left!=null)// we go left beacause min value is present in left part of tree
        {
            root=root.left;
        }
        return root.val;//atlast return root value
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)//if root null than simply return null
            return null;
        if(key<root.val)//if key less than root value than call delete for root  left  part
            root.left=deleteNode(root.left,key);
        else
        if(key>root.val)//if key greater than root value than call delete for root  right  part
            root.right=deleteNode(root.right,key);
        else
        {
            if(root.left==null && root.right==null)//if found than cheq it left and right part null than simply delete
                return null;
            else
            if(root.left==null)//if root left only null means right child present
                return root.right;//than simply return  root right
            else
            if(root.right==null)//if root right only null means left child present
                return root.left;//than simply return root left
            else
            {
                root.val=Min(root.right);//if two child present than find inorder successor and replace the root value by inorder succesor value
                root.right=deleteNode(root.right,root.val);//and delete root inorder succesor node
            }
        }
        return root;//return root

    }


//******************************
    int findMin(TreeNode head, TreeNode root)
    {
        if(root.left == null)
        {
            int temp= root.val;
            deleteNode(head, root.val);
            return temp;
        }

        return findMin(head,root.left);
    }
    public TreeNode deleteNode(TreeNode root, int key)
    {
        if(root == null)
            return null;
        if(root.val == key)
        {
            if(root.left == null && root.right == null)
                return null;
            else if(root.left == null)
                return root.right;
            else if(root.right == null)
                return root.left;
            else
            {
                root.val = findMin(root,root.right);
                return root;
            }
        }
        else
        {
            root.left = deleteNode(root.left, key);
            root.right = deleteNode(root.right, key);
        }

        return root;
    }


    //***********************************

    public TreeNode deleteNode(TreeNode root, int key) {
        // base case
        if (root == null) return root;

        if (root.val == key && root.right == null && root.left == null)
            return null;

        deleteNodeHelper(root, key, null);
        return root;
    }

    private void deleteNodeHelper(TreeNode root, int key, TreeNode parent) {
        if (root == null) return;
        if(key > root.val) {
            deleteNodeHelper(root.right, key, root);
            return;
        }
        if(key < root.val) {
            deleteNodeHelper(root.left, key, root);
            return;
        }
        // A leave
        if (root.left == null && root.right == null) {
            if (parent.right != null && root.val == parent.right.val) {
                parent.right = null;
            }
            if (parent.left != null && root.val == parent.left.val) {
                parent.left = null;
            }
            return;
        }

        //has left
        if (root.left !=null && root.right == null) {
            root.val = root.left.val;
            root.right = root.left.right;
            root.left = root.left.left;
            return;
        }

        //has right
        if (root.right !=null && root.left == null) {
            root.val = root.right.val;
            root.left = root.right.left;
            root.right = root.right.right;
            return;
        }

        //has both
        TreeNode min = findMin(root.right);
        int minV = min.val;
        TreeNode s = deleteNode(root, minV);
        root.val = minV;
    }

    private TreeNode findMin(TreeNode root) {
        if (root.left !=null) return findMin(root.left);
        return root;
    }

 */
}
