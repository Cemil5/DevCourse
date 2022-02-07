package myTests;

import java.util.Stack;

public class PrintLeafNodes_Tree {
    /*
     * Java Program to print all leaf nodes of binary tree
     * using recursion
     * input :   a
     *          / \
     *         b   f
     *        / \  / \
     *       c   e g  h
     *      /          \
     *     d            k
     *
     * output: d e g k
     */

    public static void main(String[] args) throws Exception {
        // creating a binary tree
        TreeNode d = new TreeNode("d");
        TreeNode e = new TreeNode("e");
        TreeNode g = new TreeNode("g");
        TreeNode k = new TreeNode("k");

        TreeNode c = new TreeNode("c", d, null);
        TreeNode h = new TreeNode("h", k, null);

        TreeNode b = new TreeNode("b", c, e);
        TreeNode f = new TreeNode("f", g, h);

        TreeNode root = new TreeNode("a", b, f);

        System.out.println("Printing all leaf nodes of binary tree recursively: ");
        printLeavesWithRecursion(root);
        System.out.println("\nPrinting all leaf nodes of binary tree without recursive: ");
        printLeavesIteratively(root);

    }

    /**
     * A class to represent a node in binary tree
     */
    private static class TreeNode {
        String value;
        TreeNode left;
        TreeNode right;

        TreeNode(String value) {
            this.value = value;
        }

        TreeNode(String data, TreeNode left, TreeNode right) {
            this.value = data;
            this.left = left;
            this.right = right;
        }

        boolean isLeaf() {
            return left == null && right == null;
        }
    }

    /**
     * Java method to print leaf nodes using recursion
     * param root
     */
    public static void printLeavesWithRecursion(TreeNode node) {
        if (node == null) // base case
            return;
        if (node.isLeaf())
            System.out.printf("%s ", node.value);
        printLeavesWithRecursion(node.left);
        printLeavesWithRecursion(node.right);
    }

/**
1) Create a Stack and push the root node
2) loop until Stack is not empty
3) Call Stack.pop() to get the last element and store its left and right child if they are not null
4) if both left and right child of the last node is null then it's a leaf node, print its value
 */
    public static void printLeavesIteratively(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.right != null)
                stack.add(node.right);
            if (node.left != null)
                stack.add(node.left);
            if (node.left == null && node.right == null)
                System.out.printf("%s ", node.value);
        }
    }

    //  Read more: https://www.java67.com/2016/09/how-to-print-all-leaf-nodes-of-binary-tree-in-java.html#ixzz7JvmnfFgq
}
