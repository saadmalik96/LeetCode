public class LeetCodeSeven {
     /*
    https://leetcode.com/problems/convert-bst-to-greater-tree
    Diff: Medium
    Problem: Convert BST to Greater Tree
    Input: node representing tree
    Ouptut: node representing tree
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

    public TreeNode convertBST(TreeNode root) {
        dfs(root, 0);
        return root;
    }

    public int dfs(TreeNode root, int val) {
        if(root == null) {
            return val;
        }
        int right = dfs(root.right, val);
        int left = dfs(root.left, root.val + right);
        root.val = root.val + right;
        return left;
    }

     /*
    https://leetcode.com/problems/count-complete-tree-nodes/
    Diff: Medium
    Problem: Count Complete Tree Nodes
    Input: node representing tree
    Ouptut: integer representing number of complete nodes
    */

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
