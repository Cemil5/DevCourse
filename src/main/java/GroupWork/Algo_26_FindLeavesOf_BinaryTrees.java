package GroupWork;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;

public class Algo_26_FindLeavesOf_BinaryTrees {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
        TreeNode(int x, TreeNode left, TreeNode right) {
            val = x;
            this.left = left;
            this.right = right;
        }
    }

    @DataProvider
    public Object[][] input (){
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n2 = new TreeNode(2, n4, n5);
        TreeNode n3 = new TreeNode(3);
        TreeNode root = new TreeNode(1, n2, n3);
        int[] a1 = {5,4,3};
        List<Integer> l1 = Arrays.asList(5,4,3);
        List<Integer> l2 = Arrays.asList(2);
        List<Integer> l3 = Arrays.asList(1);
        List<List<Integer>> list = new ArrayList<>();
        list.add(l1);
        list.add(l2);
        list.add(l3);
        return new Object[][]{
            {root, list},
        };
    }

    @Test(dataProvider = "input")
    public void test(TreeNode root, List<List<Integer>> expected){

        System.out.println(findLeaves(root));
        System.out.println(findLeaves2(root));
        Assert.assertEquals(findLeaves(root), expected);

    }


    @Test
    public void test2(){
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n2 = new TreeNode(2, n4, n5);
        TreeNode n3 = new TreeNode(3);
        TreeNode root = new TreeNode(1, n2, n3);

        traversePreOrder(root);
        System.out.println();
        System.out.println(findLeaves(root));
     //   System.out.println(findLeaves2(root));
     //   findLeavesWithQueue(root);
     //   postOrderWithIteration(root);
        findLeavesWithIteration(root);
    }

    public void findLeavesWithIteration(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        Map<TreeNode, Boolean> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            TreeNode current = stack.peek();
            TreeNode currentLeft = current.left;
            TreeNode currentRight = current.right;

            if (currentLeft.left == null && currentLeft.right == null) {
                if (!map.containsKey(currentLeft)) {
                    temp.add(currentLeft.val);
                    current.left = null;
                }
            } else if (currentRight.left == null && currentRight.right == null) {
                    if (!map.containsKey(currentRight)) {
                        temp.add(currentRight.val);
                        current.right = null;
                    }
                current = stack.pop();
                System.out.printf("%s  ", current.val);
            } else {
                if (current.right != null) {
                    stack.push(current.right);
                    map.put(current, true);
                  //  current.right = null;
                }
                if (current.left != null) {
                    stack.push(current.left);
                    map.put(current, true);
                  //  current.left = null;
                }
            }
        }
        System.out.println("temp = " + temp);
    }

    public void postOrderWithIteration(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            TreeNode current = stack.peek();
            if (current.left == null && current.right == null) {
                current = stack.pop();
                System.out.printf("%s  ", current.val);
            } else {
                if (current.right != null) {
                    stack.push(current.right);
                    current.right = null;
                }
                if (current.left != null) {
                    stack.push(current.left);
                    current.left = null;
                }
            }
        }
        System.out.println();
    }

    // I added 03.02.2022 not working
    public List<List<Integer>> findLeavesWithQueue(TreeNode node) {
        if (node == null)
            return null;
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        queue.add(node);
        ArrayList<Integer> subList = new ArrayList<>();
        TreeNode current = node;
        while (!queue.isEmpty()) {
            TreeNode prev = current;
            current = queue.poll();
            int ist = 0;
            if(current.left != null || current.right != null){
                stack.push(current);
                if (current.left != null){
                    queue.add(current.left);
                    ist = 1;
                    }
                if (current.right != null) {
                    queue.add(current.right);
                    ist = 2;
                }
            } else if (current.left == null && current.right == null){
                subList.add(current.val);
                if (ist == 1)
                    prev.left = null;
                else
                    prev.right = null;
            }
        }
        list.add(subList);
        System.out.println("list :" + list);
        System.out.println("subList : "+ subList);
        System.out.println("stack : " + stack);
        System.out.println("queue = " + queue);
        while (!stack.isEmpty()){
            TreeNode prev = current;
            current = stack.pop();
            int ist = 0;
            if(current.left != null || current.right != null){
                queue.add(current);
                if (current.left != null){
                    queue.add(current.left);
                    ist = 1;
                }
                if (current.right != null) {
                    queue.add(current.right);
                    ist = 2;
                }
            } else if (current.left == null && current.right == null){
                subList.add(current.val);
                if (ist == 1)
                    prev.left = null;
                else
                    prev.right = null;
            }
        }
        return list;
    }

    public static List<List<Integer>> findLeaves(TreeNode root) {   // from discord
        if (root==null){
            return new ArrayList<>();
        }
        List<List<Integer>> left = findLeaves(root.left);   //  finding left node
        List<List<Integer>> right = findLeaves(root.right); // finding right node

        List<Integer> tempList = new ArrayList<>();
        tempList.add(root.val);                             // adding value to the temp list

        for(int i=0; i< right.size(); i++){
            left.get(i).addAll(right.get(i));               // merging right list to the left list
        }
        left.add(tempList);                                 // adding list to the result list
        return left;
    }

    public List<List<Integer>> findLeaves2(TreeNode root) {     // from internet
        if (root == null) return new ArrayList<List<Integer>>();

        List<List<Integer>> l = findLeaves2(root.left);
        List<List<Integer>> r = findLeaves2(root.right);

        List<Integer> list = new ArrayList<>();
        list.add(root.val);

        if (l == null && r == null) {
            List<List<Integer>> res = new ArrayList<>();
            res.add(list);
            return res;
        } else if (l == null || r == null) {
            List<List<Integer>> res = l == null ? r : l;
            res.add(list);
            return res;
        } else {
            List<List<Integer>> lli = l.size() > r.size() ? merge(l, r) : merge(r, l);
            lli.add(list);
            return lli;
        }
    }
    private List<List<Integer>> merge(List<List<Integer>> large, List<List<Integer>> small){
        for(int i=0; i< small.size(); i++){
            large.get(i).addAll(small.get(i));
        }
        return large;
    }


    // preorder : root - left - right
    private void traversePreOrder(TreeNode root){
        if (root == null) return;
        System.out.print(root.val + ", ");
        traversePreOrder(root.left);
        traversePreOrder(root.right);
    }

}



/*
    public class Trunk {
        Trunk prev;
        String str;

        Trunk(Trunk prev, String str) {
            this.prev = prev;
            this.str = str;
        }

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

            printTree(root.leftChild, trunk, false);
        }

    }

    //**************************************
    /*
    public static List<List<Integer>> findLeaves(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        List<List<Integer>> left = findLeaves(root.leftNode);       //  finding left node
        List<List<Integer>> right = findLeaves(root.rightNode);     // finding right node

        List<Integer> tempList = new ArrayList<>();
        tempList.add(root.value);                                       // adding value to the temp list

        for(int i=0; i< right.size(); i++){
            left.get(i).addAll(right.get(i));                       // merging right list to the left list
        }
        List<List<Integer>> resultList = left;                      // assigning left list to the result list
        resultList.add(tempList);                                       // adding list to the result list
        return resultList;
    }


}*/
