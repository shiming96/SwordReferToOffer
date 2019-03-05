/**
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */

/**
 * 对于一棵二叉树，从根结点开始遍历，
 * 如果左右子结点有一个为NULL，那么肯定不是对称二叉树；
 * 如果左右子结点均不为空，但不相等，那么肯定不是对称二叉树；
 * 如果左右子结点均不为空且相等，那么
 * 遍历左子树，遍历顺序为：当前结点，左子树，右子树；
 * 遍历右子树，遍历顺序为：当前结点，右子树，左子树；
 * 如果遍历左子树的序列和遍历右子树的序列一样，那么该二叉树为对称的二叉树。
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


    boolean isSymmetrical(TreeNode pRoot) {

        return judge(pRoot, pRoot);
    }

    private boolean judge(TreeNode pRoot1, TreeNode pRoot2) {
        if(pRoot1 == null && pRoot2 == null)
            return true;
        if(pRoot1 == null || pRoot2 == null)
            return false;
        if(pRoot1.left != null && pRoot2.right != null && pRoot1.left.val != pRoot2.right.val)
            return false;
        if(pRoot1.right != null && pRoot2.left != null && pRoot1.right.val != pRoot2.left.val)
            return false;
        return judge(pRoot1.left, pRoot2.right);
    }

}
