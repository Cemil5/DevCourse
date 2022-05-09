package dataStructure.Tree;

public class Trunk {
    Trunk prev;
    String str;

    Trunk(Trunk prev, String str) {
        this.prev = prev;
        this.str = str;
    }
/*
    public class Node{
        public Tree.Node leftChild;
        public Tree.Node rightChild;
        public int value;

        public Node(int value){
            this.value = value;
        }
    }

    public Node root;

    public ArrayList<Integer> CalculateBranchSums() {
        ArrayList<Integer> sums = new ArrayList();
        if (getRoot() == null) return sums;
        BranchSums(getRoot(), 0, sums);
        return sums;
    }

    public void BranchSums(Node node, int tempSum, ArrayList<Integer> sums) {
        if (node == null) return;
        tempSum = tempSum + node.value;
        if (node.leftChild == null && node.rightChild == null) sums.add(tempSum);
        BranchSums(node.leftChild, tempSum, sums);
        BranchSums(node.rightChild, tempSum, sums);
    }

    public List<List<Integer>> findLeaves() {
        List<List<Integer>> resultList = new ArrayList<>();

        while (getRoot() != null) {
            printTree(root, null, false);
            ArrayList<Integer> leavesList = new ArrayList();

            resultList.add(getLeafNodes(getRoot(), leavesList));
            System.out.println(resultList);
        }

        return resultList;
    }

    public ArrayList<Integer> getLeafNodes(Node node, ArrayList<Integer> leavesList) {

        // If node is null, return
        if (node == null)
            return leavesList;
        if (node == root) {
            if (root.leftChild == null && root.rightChild == null) {
                leavesList.add(root.value);
                root = null;
                return leavesList;
            }
        }

        // If node's left is leaf node, put it in the List
        if (node.leftChild != null) {

            if (node.leftChild.leftChild == null && node.leftChild.rightChild == null) { // this is a leaf
                leavesList.add(node.leftChild.value);
                node.leftChild = null;
            }
        }
// If node's right is leaf node, put it in the List
        if (node.rightChild != null) {
            if (node.rightChild.leftChild == null && node.rightChild.rightChild == null) { // this is a leaf
                leavesList.add(node.rightChild.value);
                node.rightChild = null;
            }
        }

        // If left child exists, check for leaf
        // recursively
        if (node.leftChild != null)
            getLeafNodes(node.leftChild, leavesList);

        // If right child exists, check for leaf
        // recursively
        if (node.rightChild != null)
            getLeafNodes(node.rightChild, leavesList);
        return leavesList;
    }

    public static void showTrunks(Trunk p) {
        if (p == null) {
            return;
        }

        showTrunks(p.prev);
        System.out.print(p.str);
    }

    public void printTree(Node root, Trunk prev, boolean isLeft) {
        if (root == null) {
            return;
        }

        String prev_str = "    ";
        Trunk trunk = new Trunk(prev, prev_str);

        printTree(root.rightChild, trunk, true);

        if (prev == null) {
            trunk.str = "———";
        } else if (isLeft) {
            trunk.str = ".———";
            prev_str = "   |";
        } else {
            trunk.str = "`———";
            prev.str = prev_str;
        }

        showTrunks(trunk);
        System.out.println(" " + root.value);

        if (prev != null) {
            prev.str = prev_str;
        }
        trunk.str = "   |";

        printTree(root.left, trunk, false);
    }


*/
}
