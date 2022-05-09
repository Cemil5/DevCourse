package dataStructure.Tree;

public class TreeExe {

    public static void main(String[] args) {

        Tree myTree = new Tree();

        int[] nums = {7, 4, 9, 6, 1, 8, 10};
     //   int[] nums = {10,6,8,20,4,9,5,17,42,47,29};
     //   int[] nums = {20,10,6,14,3,8,30,24,36};
        for (int num : nums) {
            myTree.insert(num);
        }

        System.out.println("pre order traversal without recursion");
        myTree.preOrderWithIteration(myTree.root);

        System.out.println("PreOrder traversal tree before DELETION : ");
        myTree.traversePreOrder();


        System.out.println(myTree.deleteNode(myTree.root, 4));
        System.out.println("PreOrder traversal tree after DELETION : ");
        myTree.traversePreOrder();

        System.out.println();
        System.out.println("isLeaf : " + myTree.isLeaf(9));
        System.out.println("distance : " + myTree.distance(9));
        /*
        System.out.println("PreOrder traversal tree : ");
        myTree.traversePreOrder();
*/

        System.out.println("\n\nInOrder traversal tree with recursion : ");
        myTree.traverseInOrder();
        System.out.println("\nInOrder traversal tree with iteration : ");
        myTree.traverseInOrderWithIteration();

        System.out.println("\n\nPostOrder traversal tree : ");
        myTree.traversePostOrder();
        System.out.println("\nPostOrder traversal tree with iteration: ");
        myTree.postOrderWithIteration();


    }

}
