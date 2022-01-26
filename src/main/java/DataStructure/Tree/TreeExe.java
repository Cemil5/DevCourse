package DataStructure.Tree;

public class TreeExe {

    public static void main(String[] args) {

        Tree myTree = new Tree();

        int[] nums = {10,6,8,20,4,9,5,17,42,47,29};
     //   int[] nums = {20,10,6,14,3,8,30,24,36};
        for (int num : nums) {
            myTree.insert(num);
        }
        System.out.println("PreOrder traversal tree : ");
        myTree.traversePreOrder();

        System.out.println("\n\tInOrder traversal tree : ");
        myTree.traverseInOrder();

        System.out.println("\n\tPostOrder traversal tree : ");
        myTree.traversePostOrder();
    }

}
