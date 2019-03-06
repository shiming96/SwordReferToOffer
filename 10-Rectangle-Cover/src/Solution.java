/**
 * 我们可以用2 1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2 1的小矩形无重叠地覆盖一个2*n的大矩形，
 * 总共有多少种方法？
 */

/**
 * 斐波那契数列
 */
public class Solution {

    public int RectCover(int target) {
        if(target == 1)
            return 1;
        if(target == 2)
            return 2;

        int a = 1;
        int b = 2;
        int sum = 0;
        for(int i = 3; i <= target; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }

        return sum;
    }

    /**
     * 递归性能差
     */
    /*public int RectCover(int target) {
        if(target <= 0)
            return 0;
        else if(target == 1 || target == 2)
            return target;
        else
            return RectCover(target -1) + RectCover( target - 2);
    }*/

}
