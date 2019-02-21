import org.junit.Test;

import java.util.TreeSet;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */

public class Solution {

    public String printMinNumber(int[] numbers) {
        if(numbers.length == 0)
            return "";
        TreeSet<String> set = new TreeSet<>();
        printMinNumber(numbers, 0, set);

        return set.pollFirst();
    }

    private void printMinNumber(int[] numbers, int index, TreeSet<String> set) {
        if(index == numbers.length - 1) {
            StringBuilder tempStr = new StringBuilder();
            for (int number : numbers)
                tempStr.append(String.valueOf(number));
            set.add(tempStr.toString());
        } else {
            for (int i = index; i < numbers.length; i++) {
                swap(numbers, index, i);
                printMinNumber(numbers, index + 1, set);
                swap(numbers, index, i);
            }
        }
    }

    private void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    @Test
    public void test() {
       int[] numbers = {114, 1, 33};

        String s = printMinNumber(numbers);
        System.out.println(s);
    }
}
