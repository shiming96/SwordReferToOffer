import java.util.ArrayList;

/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 */

public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {

        int i = 0;
        int j = array.length - 1;

        ArrayList<Integer> res = new ArrayList<>();

        //左右夹逼
        while(i < j) {
            if(array[i] + array[j] == sum) {
                res.add(array[i]);
                res.add(array[j]);
                break;
            } else if(array[i] + array[j] > sum)
                j--;
              else
                i++;
        }
        return res;
    }
}
