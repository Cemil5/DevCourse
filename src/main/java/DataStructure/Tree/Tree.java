package DataStructure.Tree;

public class Tree {

    // Nested node class

    private class Node{

        private Node leftChild;
        private Node rightChild;
        private int value;

        public Node(int value){
            this.value = value;
        }
    }

    private Node root;

    public void insert (int value){
        Node node = new Node(value);
        if (root == null) root = node;
        else {
            Node current = root;
            while (true) {
                if (value <= current.value) {
                    if (current.leftChild == null){
                        current.leftChild = node;
                        break;
                    }
                    current = current.leftChild;
                } else {
                    if (current.rightChild == null){
                        current.rightChild = node;
                        break;
                    }
                    current = current.rightChild;
                }
            }
        }
    }

    // preorder : root - left - right
    public void traversePreOrder(){
        traversePreOrder(root);
    }

    private void traversePreOrder(Node root){
        if (root == null) return;
        System.out.print(root.value + ", ");
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }

    // inorder : left - root- right
    public void traverseInOrder(){
        traverseInOrder(root);
    }

    private void traverseInOrder(Node root){
        if (root == null) return;
        traverseInOrder(root.leftChild);
        System.out.print(root.value + ", ");
        traverseInOrder(root.rightChild);
    }

    // postorder : left - right - root
    public void traversePostOrder(){
        traversePostOrder(root);
    }

    private void traversePostOrder(Node root){
        if (root == null) return;
        traversePostOrder(root.leftChild);
        traversePostOrder(root.rightChild);
        System.out.print(root.value + ", ");
    }


}
