/**
 * 一只青蛙一次可以跳1, 2, 3, ... n级
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */

/**
 * 思路见图片
 */
public class Solution2 {

    public int JunFloorII(int target) {
        return (int) Math.pow(2, target - 1);
    }
}
