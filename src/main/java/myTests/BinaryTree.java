package myTests;

import org.testng.annotations.Test;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

// I added 03.02.2022
public class BinaryTree {
    // Class containing left and right child of current node and key value
    static class Node {
        int value;
        Node left, right;

        public Node(int item) {
            value = item;
        }
    }

    Node root;      // Root of the Binary Tree

    /* Compute the "height" of a tree -- the number of nodes along the longest path from the root node
   down to the farthest leaf node.*/
    /*
    Since the height of the tree is defined as the largest path from the root to a leaf. So we can recursively compute
    the height of the left and right sub-trees, and find the maximum height of the sub-tree. The height of the tree will
    then simply be the height of the sub-tree + 1. height is used instead of depth.
     */

    // I added on 03.02.2022
    int depth(Node node) {
        if (node == null)
            return -1;
        else {   // compute  depth of each subtree
            int lDepth = depth(node.left) ;
            int rDepth = depth(node.right) ;
            return Math.max(lDepth, rDepth) +1 ;      // use the larger one
        }
    }

    void insert(int val){
        Node newNode = new Node(val);
        if(root == null)
            root = newNode;
        else {
            int start = depth(root)-1;
            insert(root, start, newNode);
        }
    }

    void insert (Node root, int level, Node newNode) {
        if (level >= -1)
            if (root.left == null){
                root.left = newNode;
                return;
            } else if (root.right == null){
                root.right = newNode;
                return;
            }
        else if (root.left != null && root.right != null) {
            insert(root.left, level -1, newNode);
            insert(root.right, level -1, newNode);
        }
    }

    void printInLevelOrder() {
        int h = depth(root);
        int i;
        for (i = 0; i <= h; i++)
            printCurrentLevel(root, i);
    }

    // Print nodes at the current level
    void printCurrentLevel(Node root, int level) {
        if (root == null)
            return;
        if (level == 0)
            System.out.print(root.value + " ");
        else if (level > 0) {
            printCurrentLevel(root.left, level - 1);
            printCurrentLevel(root.right, level - 1);
        }
    }

    // I added 03.02.2022
    public void levelOrderQueue(Node node) {
        Queue<Node> q = new LinkedList<>();
        if (node == null)
            return;
        q.add(node);
        while (!q.isEmpty()) {
            Node n = q.poll();
            System.out.print(" " + n.value);
            if (n.left != null)
                q.add(n.left);
            if (n.right != null)
                q.add(n.right);
        }
    }

    // doesn't work
    Node convertToBinaryTree(int[] arr){
        for (int j : arr) {
            insert(j);
        }
        return root;
    }

    // it works
    Node convertToBinaryTreeWithQueue(int[] arr){
        Queue<Node> queue = new ArrayDeque<>();
        for (int val : arr) {
            Node newNode = new Node(val);
            Node temp = queue.size() == 0 ? root : queue.peek();
            boolean isAssigned = false;
            if (root == null) {
                root = newNode;
                queue.add(root);
                isAssigned = true;
            }
            while (!isAssigned) {
                if (temp.left == null) {
                    temp.left = newNode;
                    queue.add(newNode);
                    isAssigned = true;
                } else if (temp.right == null) {
                    temp.right = newNode;
                    queue.add(newNode);
                    queue.poll();
                    isAssigned = true;
                } else {
                    temp = queue.poll();
                }
            }
        }
        return root;
    }

    @Test
    public void test(){
        BinaryTree binaryTree = new BinaryTree();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8 };
   //   binaryTree.convertToBinaryTree(arr);
   //   System.out.println(binaryTree.convertToBinaryTree(arr).value);
   //   binaryTree.printInLevelOrder();
        binaryTree.convertToBinaryTreeWithQueue(arr);
        System.out.println("depth : " + binaryTree.depth(binaryTree.root));
    //    binaryTree.printInLevelOrder();
        binaryTree.levelOrderQueue(binaryTree.root);
   //   binaryTree.printCurrentLevel(binaryTree.root,2);
    }

}
