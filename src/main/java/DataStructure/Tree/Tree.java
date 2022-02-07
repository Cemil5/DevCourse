package DataStructure.Tree;

import java.util.ArrayList;
import java.util.Stack;

// creating Binary Tree
public class Tree {

    // Nested node class
    public class Node{
        public Node leftChild;
        public Node rightChild;
        public int value;

        public Node(int value){
            this.value = value;
        }
    }

    public Node root;

    // I added on 03.02.2022
    int depth(Node node) {
        if (node == null)
            return -1;
        else {   // compute  depth of each subtree
            int lDepth = depth(node.leftChild) ;
            int rDepth = depth(node.rightChild) ;
            return Math.max(lDepth, rDepth) +1 ;      // use the larger one
        }
    }

    public void insert (int value){
        Node node = new Node(value);
        if (root == null) root = node;
        else {
            Node current = root;
            boolean isAssigned = false;
            while (!isAssigned) {
                if (value <= current.value) {
                    if (current.leftChild == null){
                        current.leftChild = node;
                        isAssigned = true;
                    } else
                        current = current.leftChild;
                } else {
                    if (current.rightChild == null){
                        current.rightChild = node;
                        isAssigned = true;
                    } else
                        current = current.rightChild;
                }
            }
        }
    }

    // I added 01.02.2022
    // deletion in binary search tree
    public boolean delete (int num){
        Node prev = root;
        Node current = root;
        while (current != null) {
            if (current.value == num) {
                // The node to be deleted is a leaf node
                if (current.leftChild == null && current.rightChild == null) {
                    if (prev.value > num)
                        prev.leftChild = null;
                    else
                        prev.rightChild = null;
                    break;
                //   The node to be deleted has only one child. replace it with the NULL and free the allocated space.
                } else if (current.leftChild == null || current.rightChild == null){
                    if (current.leftChild != null) {
                        current.value = current.leftChild.value;
                        current.leftChild = null;
                    } else {
                        current.value = current.rightChild.value;
                        current.rightChild = null;
                    }
       // The node to be deleted has two children. the node which is to be deleted, is replaced with its
       // in-order successor or predecessor recursively until the node value (to be deleted) is placed on the leaf
       // of the tree. After the procedure, replace the node with NULL and free the allocated space.
                    // write the codes here

                }
            } else {
                    if (current.value < num) {
                        prev = current;
                        current = current.rightChild;
                    } else {
                        prev = current;
                        current = current.leftChild;
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
        Node current = root;
        while (current != null){
            if (current.value == num)
                return current.leftChild == null && current.rightChild == null;
            else {
                if (current.value < num)
                    current = current.rightChild;
                else
                    current = current.leftChild;
            }
        }
        return false;
    }

    // I added 01.02.2022
    public int distance (int num){
        Node current = root;
        int distance = 0;
        while (current != null){
            if (current.value == num)
                return distance;
            else {
                if (current.value < num)
                    current = current.rightChild;
                else
                    current = current.leftChild;
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
    private void traversePreOrder(Node node){
        if (node == null) return;
        System.out.print(node.value + ", ");
        list.add(node.value);
        traversePreOrder(node.leftChild);
        traversePreOrder(node.rightChild);
    }

/*
there is tricky part in the middle of the algorithm, where you have to push right sub-tree before the left subtree,
which is different from the recursive algorithm
Read more: https://javarevisited.blogspot.com/2016/07/binary-tree-preorder-traversal-in-java-using-recursion-iteration-example.html#ixzz7JviL2PyB
 */
    public void preOrderWithIteration(Node node) {
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            Node current = stack.pop();
            System.out.printf("%s  ", current.value);
            if (current.rightChild != null)
                stack.push(current.rightChild);
            if (current.leftChild != null)
                stack.push(current.leftChild);
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
    private void traverseInOrder(Node node){
        if (node == null) return;
        traverseInOrder(node.leftChild);
        System.out.print(node.value + ", ");
        traverseInOrder(node.rightChild);
    }
/**
We start with the root and process until current node is not or Stack is not empty.
We start pushing nodes from left subtree until we reach to a leaf node. At that point, we pop() the last element,
print its value and starts exploring right subtree by assigning current = current.right. This continues until our stack
becomes empty, at that point, the tree traversal is finished and all elements of the binary tree is visited.
 */
    public void traverseInOrderWithIteration() {
        Stack<Node> stack = new Stack<>();
        Node current = root;
        while (!stack.isEmpty() || current != null) {
            if (current != null) {
                stack.push(current);
                current = current.leftChild;
            } else {
                current = stack.pop();
                System.out.printf("%s  ", current.value);
                current = current.rightChild;
            }
        }
    }


    // postorder : left - right - root
    public void traversePostOrder(){
        traversePostOrder(root);
    }

    private void traversePostOrder(Node node){
        if (node == null) return;
        traversePostOrder(node.leftChild);
        traversePostOrder(node.rightChild);
        System.out.print(node.value + ", ");
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
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node current = stack.peek();
            if (current.leftChild == null && current.rightChild == null) {
                current = stack.pop();
                System.out.printf("%s  ", current.value);
            } else {
                if (current.rightChild != null) {
                    stack.push(current.rightChild);
                    current.rightChild = null;
                }
                if (current.leftChild != null) {
                    stack.push(current.leftChild);
                    current.leftChild = null;
                }
            }
        }
    }
}
