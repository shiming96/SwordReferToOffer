/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */

import org.junit.Test;

/**
 * 根据题意说明是一个递增数组的旋转，所以如题所示【3,4,5】，【1,2】还是局部递增的，在这种数组中查找，一般选择二分的方法；基本模型有了，下面试着分析：
 * 1.先取出中间的数值，和最后一个比较5>2 说明mid之前的某些部分旋转到了后面，所以下次寻找 start = mid+1 开始；
 * 2.取出的中间值要是小于end，说明mid-end之间都应为被旋转的部分，所以最小应该在mid的前面，但是也有可能当前的mid 就是最小的值 所以下次需找的应该 从mid开始，也即end = mid 开始
 * 3.当mid == end的时候，说明数组中存在着相等的数值，可能是这样的形式 【2,2,2,2,1,2】所以应该选择的end 应该递减1 或者begin加1作为下次寻找的上界
 */
public class Solution {

    public int minNumberInRotateArray(int[] arr) {

        if(arr.length == 0)
            return 0;

        if(arr[0] < arr[arr.length - 1])
            return arr[0];

        int start = 0;
        int end = arr.length - 1;

        while(start + 1 != end) {
            int mid = (start + end) / 2;
            if(arr[mid] > arr[start])
                start = mid;
            else if(arr[mid] < arr[end])
                end = mid;
            else
                start++;
        }
        return arr[end];
    }

    @Test
    public void test() {
        int[] arr = {3, 4, 5, 1, 2};
        int[] arr1 = {2, 2, 2, 2, 1, 2};
        System.out.println(minNumberInRotateArray(arr));
        System.out.println(minNumberInRotateArray(arr1));
    }
}
