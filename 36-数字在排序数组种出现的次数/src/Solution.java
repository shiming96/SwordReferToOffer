/**
 * 统计一个数字在排序数组中出现的次数。
 */

public class Solution {
    public int getNumberOfK(int[] array , int k) {

        int leftIndex = -1;
        int rightIndex = -1;
        int start = 0;
        int end = array.length - 1;

        while( start <= end) {
            int mid = start + (end - start) / 2;
            if(array[mid] > k)
                end = mid - 1;
            else if(array[mid] < k)
                start = mid + 1;
            else {
                leftIndex = mid;
                end = mid - 1;
            }
        }

        start = 0;
        end = array.length - 1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(array[mid] > k)
                end = mid - 1;
            else if(array[mid] < k)
                start = mid + 1;
            else {
                rightIndex = mid;
                start = mid + 1;
            }
        }

        if(rightIndex == -1)
            return 0;
        else
            return rightIndex - leftIndex + 1;
    }
}
