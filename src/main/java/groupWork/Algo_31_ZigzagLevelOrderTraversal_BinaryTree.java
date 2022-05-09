package groupWork;
/*
Question #31 (leetcode #103)
Binary Tree Zigzag Level Order Traversal
Difficulty :Medium Category :Tree
Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e.,
from left to right, then right to left for the next level and alternate between).
-------------------------------------------------
Example 1:
            3
           /   \
         9      20
                /  \
              15    7
Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]
-----------------------------------------------
Example 2:
Input: root = [1]
Output: [[1]]
--------------------------------------------------
Example 3:
Input: root = []
Output: []
--------------------------------------------------
Constraints:
• The number of nodes in the tree is in the range [0, 2000].
• -100 <= Node.val <= 100
Solution Format:
class Solution {
public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
}
}
 */

import dataStructure.Tree.Tree;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class Algo_31_ZigzagLevelOrderTraversal_BinaryTree {

@DataProvider
    public Object[][] data(){
    return new Object[][]{
            {new int[]{3,9,20,15,7}, new int[][]{new int[]{3}, new int[]{20,9},new int[]{15,7}}},
    };
}

@Test(dataProvider = "data")
    public void test(int[] input, int[][] expected){
    Tree myTree = new Tree();

    for (int num : input) {
        myTree.insert(num);
    }

    System.out.println("\n\tInOrder traversal tree : ");
    myTree.traverseInOrder();
}

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();

    return list;
    }

}
