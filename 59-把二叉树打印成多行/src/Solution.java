import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
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
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();

        if(pRoot == null)
            return ret;
        ArrayList<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(null);
        queue.addLast(pRoot);

        while(queue.size() != 1) {
            TreeNode node = queue.removeFirst();
            if(node == null) {
                final Iterator<TreeNode> it = queue.iterator();
                while(it.hasNext()) {
                    final TreeNode temp = it.next();
                    list.add(temp.val);
                }
                ret.add(new ArrayList<>(list));
                list.clear();
                queue.addLast(null);
                continue;
            }
            if(node.left != null)
                queue.addLast(node.left);
            if(node.right != null)
                queue.addLast(node.right);
        }
        return ret;
    }
}
