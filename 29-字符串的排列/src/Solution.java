import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 *
 * 输入描述:
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */

public class Solution {

    private List<String> result = new ArrayList<>();
    private TreeSet<String> set = new TreeSet<>();//使用TreeSet保证有序和无重复

    public List<String> Permutation(String str) {
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


    @Test
    public void test() {
        List<String> list = Permutation("abc");
        list.forEach(System.out::println);
    }

}
