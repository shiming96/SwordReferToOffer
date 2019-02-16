import java.util.ArrayList;
import java.util.List;

/**
 * 输入一颗二叉树的根节点和一个整数，
 * 打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 */

public class Solution {

    private class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    List<ArrayList<Integer>> resultList = new ArrayList<>();

    public void findPath(TreeNode root, int target) {

        ArrayList<Integer> list = new ArrayList<>();
        findPath(root, target, 0, list);

    }

    private void findPath(TreeNode root, int target, int sum, ArrayList<Integer> list) {

        if(root == null)
            return;
        sum += root.val;
        list.add(root.val);
        if( sum == target && root.left == null && root.right == null) {
            resultList.add(new ArrayList<>(list));
            list.remove(list.size() - 1);//找到以后还要接着找, 所以先把当前最后的叶子节点删除
            return;
        }
        findPath(root.left, target, sum, list);
        findPath(root.right, target, sum, list);
        list.remove(list.size() - 1 );//这里左右子树都找完了，回到了找完的左右子树的父节点
        //由于父节点的左右子树找完了，所以父节点这里也没有用了，把父节点删除
    }


}
