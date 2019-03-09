import java.util.ArrayList;
import java.util.TreeSet;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 *
 * 输入描述:
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */

public class Solution {

    private ArrayList<String> result = new ArrayList<>();
    private TreeSet<String> set = new TreeSet<>();//使用TreeSet保证有序和无重复

    public ArrayList<String> Permutation(String str) {
        char[] strArray = str.toCharArray();
        Permutation(strArray, 0);
        while(!set.isEmpty())
            result.add(set.pollFirst());
        return result;
    }

    private void Permutation(char[] strArray, int index) {

        if(index == strArray.length - 1)
            //每到最后一个字符的时候, 就添加一个字符串
            set.add(String.valueOf(strArray));
        else {
            //             a|b|c(状态A)
            //               |
            //               |swap(0,0)
            //               |
            //             a|b|c(状态B)
            //             /  \
            //   swap(1,1)/    \swap(1,2)  (状态C1和状态C2)
            //           /      \
            //         a|b|c   a|c|b


            //             a|b|c(状态A)
            //               |
            //               |swap(0,1)
            //               |
            //             b|a|c(状态B)
            //             /  \
            //   swap(1,1)/    \swap(1,2)  (状态C1和状态C2)
            //           /      \
            //         b|a|c   b|c|a


            //             a|b|c(状态A)
            //               |
            //               |swap(0,2)
            //               |
            //             c|b|a(状态B)
            //             /  \
            //   swap(1,1)/    \swap(1,2)  (状态C1和状态C2)
            //           /      \
            //         c|b|a   c|a|b

            //第二个swap用以使得字符数组的顺序回到进入递归前的状态，
            //这样才不会影响外部的遍历顺序。因为在第一次交换后进入递归运算的时候，
            //字符数组的顺序改变了，例如“abc”， i = 0时对应‘a’，j = 1时对应 'b'，
            //进行一次交换，此时的字符数组的顺序为 "bac"，从递归返回时，
            //顺序依然是“bac”，则进行第二次交换使得 “bac” -> “abc”，
            //这样在后续才可以进行'a'与'c'的交换，不会落下某一种情况。

            for (int i = index; i < strArray.length; i++) {
                swap(strArray, index, i);
                Permutation(strArray, index + 1);
                swap(strArray, index, i);
            }
        }


    }

    private void swap(char[] strArray, int i, int j) {
        char temp = strArray[i];
        strArray[i] = strArray[j];
        strArray[j] = temp;
    }
}
