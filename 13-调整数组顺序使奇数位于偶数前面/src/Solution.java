/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目明确说了，不能修改相对位置，
 * 所以只能是新建两个数组，一个奇数数组，一个偶数数组，
 * 然后把奇数和偶数分别保存到对应的数组，然后在赋值到原数组中
 */

public class Solution {

    public int[] reOrderArray(int[] arr) {

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for (int i : arr) {
            if (i % 2 == 0)
                list1.add(i);
            else
                list2.add(i);
        }

        for (int i = 0; i < list2.size(); i++)
            arr[i] = list2.get(i);
        for (int i = 0; i < list1.size(); i++)
            arr[i + list2.size()] = list1.get(i);

        return arr;
    }

    @Test
    public void test() {

        int[] arr = {1, 2, 3, 4, 5, 4, 32, 1, 4, 23, 1, 312};
        int[] newArr = reOrderArray(arr);

        for (int i : newArr) {
            System.out.println(i);
        }
    }
}
