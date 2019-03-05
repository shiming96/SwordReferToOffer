import java.util.ArrayList;
import java.util.List;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */

public class Solution {

    private class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode Convert(TreeNode pRootOfTree) {

        if(pRootOfTree == null || (pRootOfTree.left == null && pRootOfTree.right == null))
            return pRootOfTree;

        List<TreeNode> nodeList = new ArrayList<>();

        buildArrayList(pRootOfTree, nodeList);

        for (int i = 0; i < nodeList.size(); i++) {
            if( i == 0)
                nodeList.get(0).right = nodeList.get(1);
            else if( i == nodeList.size() - 1)
                nodeList.get(i).left = nodeList.get(i -1);
            else {
                nodeList.get(i).left = nodeList.get(i - 1);
                nodeList.get(i).right = nodeList.get(i + 1);
            }
        }
        return nodeList.get(0);
    }

    //二叉搜索树的中序遍历
    private void buildArrayList(TreeNode root, List<TreeNode> nodeList) {

        if(root == null)
            return;
        if(root.left != null)
            buildArrayList(root.left, nodeList);
        if(root != null)
            nodeList.add(root);
        if(root.right != null)
            buildArrayList(root.right, nodeList);
    }

}
