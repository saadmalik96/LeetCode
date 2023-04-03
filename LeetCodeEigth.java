import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCodeEigth {
     /*
    https://leetcode.com/problems/add-one-row-to-tree/
    Diff: Medium
    Problem: Add One Row to Tree
    Input: node representing tree, int val, int depth
    Ouptut: node representing tree
    Description: Given the root of a binary tree and two integers val and depth,
                 add a row of nodes with value val at the given depth.
    */

    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(root == null) {
            return null;
        }
        if(depth == 1) {
            return new TreeNode(val, root, null);
        }
        if(depth == 2){
            root.left = new TreeNode(val, root.left, null);
            root.right = new TreeNode(val, null, root.right);
        } else{
            addOneRow(root.left, val, depth-1);
            addOneRow(root.right, val, depth-1);
        }
        return root;
    }

     /*
    https://leetcode.com/problems/binary-tree-level-order-traversal
    Diff: Medium
    Problem: Binary Tree Level Order Traversal
    Input: node representing tree
    Ouptut: list containing traversal
    Description: Given the root of a binary tree, return the level order traversal
                 of its nodes' values. (i.e., from left to right, level by level).


    */

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> ret = new ArrayList<>();
        while (!queue.isEmpty()) {
            int l = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < l; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    level.add(node.val);
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
            if (!level.isEmpty()) {
                ret.add(level);
            }
        }
        return ret;
    }
}
