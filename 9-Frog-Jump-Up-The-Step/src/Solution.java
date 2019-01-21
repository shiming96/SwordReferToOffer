/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */

import org.junit.Test;

/**
 * 剑指offer思路，每次使用两个变量a,b来计算下一个数的值sum,
 * 然后a,b,sum分别是斐波那契数列中的三个数，
 * 那么就令a=b,b=sum,这样a和b就往下移动了一个位置，
 * 再计算sum就是滴4个数了，重复这个过程即可。
 */
public class Solution {

    public int JumpFloor(int target) {
        if(target <= 0)
            return -1;
        if(target == 1)
            return 1;
        if(target == 2)
            return 2;
        int a = 1;
        int b = 2;
        int sum = a + b;

        for (int i = 3; i <= target; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return sum;
    }

    @Test
    public void test() {
        int i = JumpFloor(4);
        System.out.println(i);
    }

    /**
     * 一级台阶,有f(1)种跳法
     * 二级台阶,有f(2)种跳法
     * 假设n级台阶,有f(n)种跳法
     *
     * 显然, f(1) = 1, f(2) = 2
     * 当n级台阶时
     * 1. 第一次跳一步,   还有 n - 1 步, 有f(n-1)种跳法
     * 2. 第一次跳两步,   还有 n - 2 步, 有f(n-2)种跳法
     *
     * 则 f(n) = f(n-1) + f(n - 2)
     *
     * 斐波那契数列
     *
     *
     * @param target    目标阶数
     * @return          跳法
     */
    public int JumpFloor2(int target) {
        if(target <= 0)
            return -1;
        else if(target == 1 || target == 2)
            return target;
        else
            return JumpFloor2(target - 1) + JumpFloor2( target - 2);
    }

    @Test
    public void test1() {
        int i = JumpFloor2(4);
        System.out.println(i);
    }
}
