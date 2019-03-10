
import java.util.ArrayList;
import java.util.TreeSet;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */

public class Solution {

    // public String printMinNumber(int[] numbers) {
    //     if(numbers.length == 0)
    //         return "";
    //     TreeSet<String> set = new TreeSet<>();
    //     printMinNumber(numbers, 0, set);

    //     return set.pollFirst();
    // }

    // private void printMinNumber(int[] numbers, int index, TreeSet<String> set) {
    //     if(index == numbers.length - 1) {
    //         StringBuilder tempStr = new StringBuilder();
    //         for (int number : numbers)
    //             tempStr.append(String.valueOf(number));
    //         set.add(tempStr.toString());
    //     } else {
    //         for (int i = index; i < numbers.length; i++) {
    //             swap(numbers, index, i);
    //             printMinNumber(numbers, index + 1, set);
    //             swap(numbers, index, i);
    //         }
    //     }
    // }

    // private void swap(int[] numbers, int i, int j) {
    //     int temp = numbers[i];
    //     numbers[i] = numbers[j];
    //     numbers[j] = temp;
    // }
    public String PrintMinNumber(int[] numbers) {
        String s = "";
        if(numbers.length <= 0)
            return s;
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < numbers.length; i++) {
            list.add(numbers[i]);
        }

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer str1, Integer str2) {
                String s1 = str1 + "" + str2;
                String s2 = str2 + "" + str1;
                return s1.compareTo(s2);
            }
        });

        StringBuilder sb = new StringBuilder();

        for(int num : list) {
            sb.append(num);
        }

        return sb.toString();
    }
}
