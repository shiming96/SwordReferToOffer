/**
 *请实现两个函数，分别用来序列化和反序列化二叉树
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

    //前序遍历
    String Serialize(TreeNode root) {
        if(root == null)
            return "#_";

        StringBuilder res = new StringBuilder();
        res.append(root.val).append("_");
        res.append(Serialize(root.left));
        res.append(Serialize(root.right));

        return res.toString();
    }

    TreeNode Deserialize(String str) {
        if(str == null || str.length() == 0)
            return null;
        Integer index = 0;
        return deserialize(str.split("_"), new int[]{0});
    }

    //注意此处的index为数组类型（引用类型），如果是基本类型，在递归调用函数传参时，函数内部对参数的修改不会影响原值。
    private TreeNode deserialize(String[] arr, int[] index) {
        if("#".equals(arr[index[0]])) {
            index[0]++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(arr[index[0]]));
        index[0]++;
        root.left = deserialize(arr, index);
        root.right = deserialize(arr, index);
        return root;
    }
}
