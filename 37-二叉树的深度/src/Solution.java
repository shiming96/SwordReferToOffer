/**
 * 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */

/**
 * 递归思路，根的高度等于（左子树的高度和右子树的高度中高度较高的那一个高度）+1
 */
public class Solution {

    private class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }


    public int treeDepth(TreeNode root) {

        return getTreeDepth(root);
    }

    private int getTreeDepth(TreeNode root) {

        if(root == null)
            return 0;

        int leftDepth = getTreeDepth(root.left);
        int rightDepth = getTreeDepth(root.right);

        return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;

    }

}
