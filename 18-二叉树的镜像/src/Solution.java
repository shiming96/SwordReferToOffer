/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 */

/**
 * 题目描述
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 输入描述:
 * 二叉树的镜像定义：源二叉树
 *     	    8
 *     	   /  \
 *     	  6   10
 *     	 / \  / \
 *     	5  7 9 11
 *     	镜像二叉树
 *     	    8
 *     	   /  \
 *     	  10   6
 *     	 / \  / \
 *     	11 9 7 5
 */
public class Solution {

    private class TreeNode {
        int val;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public void Mirror(TreeNode root) {

        if(root == null)
            return;

        if(root.left == null && root.right == null)
            return;

        TreeNode tempNode = root.right;
        root.right = root.left;
        root.left = tempNode;

        Mirror(root.left);//对于左子树 递归调用  就是说对于左子树也进行交换

        Mirror(root.right);//对于右子树 递归调用  就是说对于右子树也进行交换

    }

}
