/**
 * 我们可以用2 1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2 1的小矩形无重叠地覆盖一个2*n的大矩形，
 * 总共有多少种方法？
 */

import org.junit.Test;

/**
 * 斐波那契数列
 */
public class Solution {

    public int rectangleCover(int target) {
        if(target <= 0)
            return 1;
        else if(target == 1 || target == 2)
            return target;
        else
            return rectangleCover(target -1) + rectangleCover( target - 2);
    }

    @Test
    public void test() {
        int i = rectangleCover(4);
        System.out.println(i);
    }
}
