/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。
 * （ps：我们约定空树不是任意一个树的子结构）
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


    public boolean HasSubtree(TreeNode root1, TreeNode root2) {

        boolean result = false;

        //当Tree1和Tree2都不为零的时候，才进行比较。否则直接返回false
        if(root1 != null && root2 != null) {
            //如果找到了对应Tree2的根节点的点
            if(root1.val == root2.val) {
                //以这个节点为起点判断是否包含Tree2
                result = doHasSubtree(root1, root2);
            }
            //如果找不到，那么就再去root的左儿子当作起点，去判断是否包含Tree2
            if(!result) {
                result = HasSubtree(root1.left, root2);
            }
            //如果还找不到，那么就再去root的右儿子当作起点，去判断是否包含Tree2
            if(!result) {
                result = HasSubtree(root2.right, root2);
            }
        }
        return result;
    }

    private boolean doHasSubtree(TreeNode root1, TreeNode root2) {

        if(root2 == null)
            return true;
        if(root1 == null)
            return false;
        if( root1.val != root2.val)
            return false;
        return doHasSubtree(root1.left, root2.left) && doHasSubtree(root1.right, root2.right);
    }
}
