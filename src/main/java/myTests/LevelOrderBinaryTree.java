package myTests;
// I added 01.02.2022 / found from internet and modified it

// Recursive Java program for level order traversal of Binary Tree

import java.util.LinkedList;
import java.util.Queue;

/**
Function to print level order traversal of tree
printLevelorder(tree)
        for d = 1 to height(tree)
            printCurrentLevel(tree, d);

 Function to print all nodes at a current level
        printCurrentLevel(tree, level)
        if tree is NULL then return;
        if level is 1, then
            print(tree->data);
        else if level greater than 1, then
            printCurrentLevel(tree->left, level-1);
            printCurrentLevel(tree->right, level-1);
 */
public class LevelOrderBinaryTree {

    // Class containing left and right child of current node and key value
    static class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
        }
    }

    Node root;      // Root of the Binary Tree

    /* function to print level order traversal of tree*/
    void printLevelOrder() {
        int h = depth(root);
        int i;
        for (i = 0; i <= h; i++)
            printCurrentLevel(root, i);
    }

    /* Compute the "height" of a tree -- the number of nodes along the longest path from the root node
    down to the farthest leaf node.*/
    /*
    Since the height of the tree is defined as the largest path from the root to a leaf. So we can recursively compute
    the height of the left and right sub-trees, and find the maximum height of the sub-tree. The height of the tree will
    then simply be the height of the sub-tree + 1. height is used instead of depth.
     */
    int depth(Node root) {
        if (root == null)
            return -1;
        else {  /* compute  height of each subtree */
            int lheight = depth(root.left) + 1;
            int rheight = depth(root.right) + 1;
            return Math.max(lheight, rheight);      /* use the larger one */
        }
    }

    // Print nodes at the current level
    void printCurrentLevel(Node root, int level) {
        if (root == null)
            return;
        if (level == 0)
            System.out.print(root.data + " ");
        else if (level > 0) {
            printCurrentLevel(root.left, level - 1);
            printCurrentLevel(root.right, level - 1);
        }
    }

    // I added 03.02.2022
    public void levelOrderQueue(Node root) {
        Queue<Node> q = new LinkedList<>();
        if (root == null)
            return;
        q.add(root);
        while (!q.isEmpty()) {
            Node n = q.poll();
            System.out.print(" " + n.data);
            if (n.left != null)
                q.add(n.left);
            if (n.right != null)
                q.add(n.right);
        }
    }

    // Driver program to test above functions
    public static void main(String[] args) {
        LevelOrderBinaryTree tree = new LevelOrderBinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

     //   System.out.println(tree.root.left.left.data);
        System.out.println("depth of 4: "+ tree.depth(tree.root.left.left));
        System.out.println("depth of 1: "+ tree.depth(tree.root));
        System.out.print("level 1 of root 1 : " );tree.printCurrentLevel(tree.root, 1);
        System.out.println();
        System.out.println("Level order traversal of binary tree is : ");
        tree.printLevelOrder();
    }


}
