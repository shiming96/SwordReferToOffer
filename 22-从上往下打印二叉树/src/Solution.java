/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */

import org.junit.Test;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 使用一个队列，实现二叉树的层次遍历 (广度优先遍历)
 */

public class Solution {

    private class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(TreeNode left, TreeNode right, int val) {
            this.left = left;
            this.right = right;
            this.val = val;
        }
    }

    public List<Integer> printTreeFromTopToBottom(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if(root == null)
            return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(queue.size() != 0) {
            TreeNode tempRoot = queue.poll();
            if (tempRoot.left != null) {
                queue.offer(tempRoot.left);
            }
            if (tempRoot.right != null) {
                queue.offer(tempRoot.right);
            }
            list.add(tempRoot.val);
        }
        return list;
    }

    @Test
    public void test() {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;

        List<Integer> list = printTreeFromTopToBottom(treeNode1);

        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
