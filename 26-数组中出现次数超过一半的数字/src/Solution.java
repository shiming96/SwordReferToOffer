/**
 * 数组中有一个数字出现的次数超过数组长度的一半，
 * 请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
 * 如果不存在则输出0。
 */

/**
 * 使用一个计数count = 1，当前数num,每当数组中数和当前数num相同，
 * 那么count就加1，不相同就减一，因为是找出现的数超过数组的长度的一半，
 * 所以最后如果有出现的数超过数组长度一半的，count肯定是大于0的数
 */
public class Solution {

    public int MoreThanHalfNum(int[] arr) {

        if( arr.length == 0)
            return 0;

        int count = 1;
        int num = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if(arr[i] == num)
                count++;
            else {
                count--;
                if(count == 0) {
                    count = 1;
                    num = arr[i];
                }
            }
        }

        if(count > 0) {
            //如果count大于0说明有可能存在这样的数，是出现次数大于数组的一半的
            //还有一种可能是最后刚好一个数连续出现了2次，导致count>0
            count = 0;
            for (int anArr : arr) {
                if (num == anArr)
                    count++;
            }
            if(count > arr.length / 2)
                return num;
        }
        return 0;
    }
}
