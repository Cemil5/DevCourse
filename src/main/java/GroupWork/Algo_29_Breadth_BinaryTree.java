package GroupWork;

public class Algo_29_Breadth_BinaryTree {



/*
    public ArrayList<Integer> getNodesByLevelOrder(){
        ArrayList<Integer> values = new ArrayList<>();
        Queue<Node> nodes = new ArrayDeque<>();
        nodes.add(root);

        while (!nodes.isEmpty()){
            Node node = nodes.remove();
            values.add(node.value);

            if (node.leftChild != null)
                nodes.add(node.leftChild);
            if (node.rightChild != null)
                nodes.add(node.rightChild);
        }
        return values;
    }

    public static void levelOrderTraversal(Node root) {
        // empty tree
        if (root == null) {
            return;
        }
        // an empty queue and enqueue the root node
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        // need a node to hold the polled/removed data from queue
        Node current;
        // loop till queue is empty
        while (!queue.isEmpty()){

            // node by node traverse left and right children
            current = queue.poll(); // return and remove the element at the queue. No exception. Returns null if empty.
//          current = queue.remove(); // return and removes the element. But throws nosuchelement exception if empty.

            System.out.print(current.data + " ");
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    public void printLevelOrder(Node root) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node tempNode = queue.poll();
            System.out.print(tempNode.value + " ");

            // add left child to the queue
            if (tempNode.leftChild != null) {
                queue.add(tempNode.leftChild);
            }

            // add right right child to the queue */
 /*        if (tempNode.rightChild != null) {
                queue.add(tempNode.rightChild);
            }
        }
    }

    static List<Integer> searchBreadthFirst2(TreeNode node){

        if(node == null) return null;

        List<TreeNode> current = new ArrayList<>();
        current.add(node);

        for(int i=0;i<current.size();i++){
            if(current.get(i).leftChild!=null) current.add(current.get(i).leftChild);
            if(current.get(i).rightChild!=null) current.add(current.get(i).rightChild);
        }

        return current.stream().map(x->x.value).collect(Collectors.toList());
    }
*/
}
