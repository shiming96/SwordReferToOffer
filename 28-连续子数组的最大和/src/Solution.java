/**
 * 在古老的一维模式识别中,常常需要计算连续子向量的最大和,
 * 当向量全为正数的时候,问题很好解决。
 * 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
 */

/**
 * 大体思路就是用一个tempmax代表前面的连续数字的最大和，
 * 如果这个最大和是正的，那么加上数组的当前数字，
 * 那么这个连续的和是变大的，这个就是有可能的潜在的最大和。
 */
public class Solution {

    public int findGreatestSumOfSubArray(int[] array) {

        if(array.length <= 0)
            return -1;
        int realMax = arr[0];
        int currentMax = 0; //当前最大值
        for (int i = 0; i < array.length; i++) {
            if(currentMax + array[i] >= array[i])
                //当前最大值加上当前数组的数如果比数组当前这个数大，那么就累加
                //这里得好好体会，因为前面连续和大于0，所以加上当前数连续和肯定变大！所以是可能的最大连续和
                currentMax += array[i];
            else
                //如果当前连续最大和小于0，那么就把currentMax赋值为当前这个数组中的数，重新开始
                currentMax = array[i];
            if(currentMax > realMax)//每计算出一个当前最大连续和就和最后的要返回结果进行比较
                realMax = currentMax;
        }
        return realMax;
    }

}
