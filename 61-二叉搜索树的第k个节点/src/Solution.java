/**
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如， （5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4。
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

    int count = 0;
    TreeNode resultNode = null;

    TreeNode KthNode(TreeNode pRoot, int k) {

        if(pRoot == null)
            return null;
        kthNode(pRoot, k);

        return resultNode;
    }

    private void kthNode(TreeNode root, int k) {

        if(root == null)
            return;
        if(root.left != null)
            kthNode(root.left, k);
        if(root != null) {
            count++;
            if(count == k)
                resultNode = root;
        }
        if(root.right != null)
            kthNode(root.right, k);

    }

}
