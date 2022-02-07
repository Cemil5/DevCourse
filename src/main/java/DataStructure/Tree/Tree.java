package DataStructure.Tree;

import java.util.ArrayList;
import java.util.Stack;

// creating Binary Tree
public class Tree {

    // Nested node class
    public class TreeNode {
        public TreeNode left;
        public TreeNode right;
        public int val;

        public TreeNode(int value){
            this.val = value;
        }
    }

    public TreeNode root;

    // I added on 03.02.2022
    int depth(TreeNode node) {
        if (node == null)
            return -1;
        else {   // compute  depth of each subtree
            int lDepth = depth(node.left) ;
            int rDepth = depth(node.right) ;
            return Math.max(lDepth, rDepth) +1 ;      // use the larger one
        }
    }

    public void insert (int value){
        TreeNode node = new TreeNode(value);
        if (root == null) root = node;
        else {
            TreeNode current = root;
            boolean isAssigned = false;
            while (!isAssigned) {
                if (value <= current.val) {
                    if (current.left == null){
                        current.left = node;
                        isAssigned = true;
                    } else
                        current = current.left;
                } else {
                    if (current.right == null){
                        current.right = node;
                        isAssigned = true;
                    } else
                        current = current.right;
                }
            }
        }
    }

    // I added on 07.02.2022
    public static int Min(TreeNode root ){
        while(root.left!=null){      // we go left because min value is present in left part of tree
            root = root.left;
        }
        return root.val;//at last return root value
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)      //if root null than simply return null
            return null;
        if(key<root.val)      //if key less than root value than call delete for root  left  part
            root.left = deleteNode(root.left, key);
        else if(key>root.val)   //if key greater than root value than call delete for root  right  part
            root.right=deleteNode(root.right,key);
        else {
            if(root.left==null && root.right==null) //if found than check it left and right part null than simply delete
                return null;
            else
            if(root.left==null)     //if root left only null means right child present
                return root.right;  //Then simply return  root right
            else
            if(root.right==null)    //if root right only null means left child present
                return root.left;   //Then simply return root left
            else {
                root.val=Min(root.right);   //if two child present than find inorder successor and replace the root value by inorder successor value
                root.right=deleteNode(root.right,root.val); //and delete root inorder successor node
            }
        }
        return root;//return root

    }

    // I added 01.02.2022
    // deletion in binary search tree
    public boolean delete (int num){
        TreeNode prev = root;
        TreeNode current = root;
        while (current != null) {
            if (current.val == num) {
                // The node to be deleted is a leaf node
                if (current.left == null && current.right == null) {
                    if (prev.val > num)
                        prev.left = null;
                    else
                        prev.right = null;
                    break;
                //   The node to be deleted has only one child. replace it with the NULL and free the allocated space.
                } else if (current.left == null || current.right == null){
                    if (current.left != null) {
                        current.val = current.left.val;
                        current.left = null;
                    } else {
                        current.val = current.right.val;
                        current.right = null;
                    }
       // The node to be deleted has two children. the node which is to be deleted, is replaced with its
       // in-order successor or predecessor recursively until the node value (to be deleted) is placed on the leaf
       // of the tree. After the procedure, replace the node with NULL and free the allocated space.
                    // write the codes here

                }
            } else {
                    if (current.val < num) {
                        prev = current;
                        current = current.right;
                    } else {
                        prev = current;
                        current = current.left;
                    }
                }
        }
        return false;
    }
    // in-order successor or predecessor
 /*   Node[] findAlternative(){
        return new Node[]{findAlternative(root, )};
    }

    private Node findAlternativeNode(Node root, int valueToDelete){
        if (root.leftChild.value == valueToDelete || root.rightChild.value == valueToDelete) {
            return root;
        }
        findAlternativeNode(root.leftChild, valueToDelete);
        System.out.print(root.value + ", ");
        findAlternativeNode(root.rightChild, valueToDelete);
        return null;
    }*/

    // I added 01.02.2022
    public boolean isLeaf (int num){
        TreeNode current = root;
        while (current != null){
            if (current.val == num)
                return current.left == null && current.right == null;
            else {
                if (current.val < num)
                    current = current.right;
                else
                    current = current.left;
            }
        }
        return false;
    }

    // I added 01.02.2022
    public int distance (int num){
        TreeNode current = root;
        int distance = 0;
        while (current != null){
            if (current.val == num)
                return distance;
            else {
                if (current.val < num)
                    current = current.right;
                else
                    current = current.left;
                distance++;
            }
        }
        return -1;
    }


    // preorder : root - left - right
    public void traversePreOrder(){
        traversePreOrder(root);
    }

    ArrayList<Integer> list = new ArrayList<>();
    private void traversePreOrder(TreeNode node){
        if (node == null) return;
        System.out.print(node.val + ", ");
        list.add(node.val);
        traversePreOrder(node.left);
        traversePreOrder(node.right);
    }

/*
there is tricky part in the middle of the algorithm, where you have to push right sub-tree before the left subtree,
which is different from the recursive algorithm
Read more: https://javarevisited.blogspot.com/2016/07/binary-tree-preorder-traversal-in-java-using-recursion-iteration-example.html#ixzz7JviL2PyB
 */
    public void preOrderWithIteration(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            System.out.printf("%s  ", current.val);
            if (current.right != null)
                stack.push(current.right);
            if (current.left != null)
                stack.push(current.left);
        }
        System.out.println();
    }


    // inorder : left - root- right
    public void traverseInOrder(){
        traverseInOrder(root);
    }
/**
Check if node == null, if yes then return, this is our base case.
Call the inOrder(node.left) to recursively visit left subtree
Print value of the node
Call the inOrder(node.right) to recursively traverse the right subtree.

 you go deep on the left subtree until you find the leaf node. Once you find that, the recursive stack starts to
 unwind, and it prints node data and starts to explore the right subtree.
 */
    private void traverseInOrder(TreeNode node){
        if (node == null) return;
        traverseInOrder(node.left);
        System.out.print(node.val + ", ");
        traverseInOrder(node.right);
    }
/**
We start with the root and process until current node is not or Stack is not empty.
We start pushing nodes from left subtree until we reach to a leaf node. At that point, we pop() the last element,
print its value and starts exploring right subtree by assigning current = current.right. This continues until our stack
becomes empty, at that point, the tree traversal is finished and all elements of the binary tree is visited.
 */
    public void traverseInOrderWithIteration() {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (!stack.isEmpty() || current != null) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                current = stack.pop();
                System.out.printf("%s  ", current.val);
                current = current.right;
            }
        }
    }


    // postorder : left - right - root
    public void traversePostOrder(){
        traversePostOrder(root);
    }

    private void traversePostOrder(TreeNode node){
        if (node == null) return;
        traversePostOrder(node.left);
        traversePostOrder(node.right);
        System.out.print(node.val + ", ");
    }

    /*
    The iterative algorithm of post-order traversal is very different from iterative pre-order and in-order
traversal. It's the most difficult to implement among the three traversal algorithms.
    We are examining leaves before examining roots. We start the post-order traversal from the root
by pushing it into a Stack and then loop until our Stack is empty. At each iteration, we peek() the element
from Stack, I mean, we retrieve it without removing and check if it's a leaf, if yes then we pop()
the element and print its value, which means the node is visited.
    If it's not a leaf then we check whether it has a right node, if yes we store into a tree and set it
to null, similarly, we check if it has left a node, if yes we push into the stack, and then mark it null.
    We first insert the right node because Stack is a LIFO (last in first out) data structure and as per
post-order traversal we need to explore the left subtree before the right subtree.
     */
    public void postOrderWithIteration() {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode current = stack.peek();
            if (current.left == null && current.right == null) {
                current = stack.pop();
                System.out.printf("%s  ", current.val);
            } else {
                if (current.right != null) {
                    stack.push(current.right);
                    current.right = null;
                }
                if (current.left != null) {
                    stack.push(current.left);
                    current.left = null;
                }
            }
        }
    }
}
