/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */

/**
 * 1、重复遍历结点
 *
 * 参考上一题求二叉树的深度，先求出根结点的左右子树的深度，然后判断它们的深度相差不超过1，如果否，则不是一棵二叉树；如果是，再用同样的方法分别判断左子树和右子树是否为平衡二叉树，如果都是，则这就是一棵平衡二叉树。
 *
 * 但上面的方法在判断子树是否为平衡二叉树时，会重复遍历树的结点，不断地求子树的深度，所以效率不高。
 *
 * 2、遍历一遍结点
 *
 * 我们在遍历结点的同时记录下该结点的深度，这样就可以避免了重复访问。
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

    private boolean flag = true;

    public boolean IsBalanced_Solution(TreeNode root) {

        treeLength(root);

        return flag;

    }

    private int treeLength(TreeNode root) {

        if(root == null)
            return 0;

        int left = treeLength(root.left);
        int right = treeLength(root.right);

        if(left - right > 1 || right - left > 1)
            flag = false;

        return left > right ? ++left : ++right;

    }

}
