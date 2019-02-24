import java.util.HashMap;
import java.util.Map;

/**
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
 * 并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 */
public class Solution {

/*    public int firstNotRepeatingChar(String str) {

        if("".equals(str) || str == null)
            return -1;


        int[] arr = new int[256];

        int index = 1;

        char[] strArray = str.toCharArray();

        for (int i = 0; i < strArray.length; i++) {
            if(arr[strArray[i]] == 0) {
                arr[strArray[i]] = index;
                index++;
            } else {
                arr[strArray[i]] = -1;
            }
        }

        int minIndex = Integer.MAX_VALUE;
        char ch = '1';
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] > 0) {
                if(arr[i] < minIndex) {
                    minIndex = arr[i];
                    ch = (char)i;
                }
            }
        }

        for (int i = 0; i < strArray.length; i++) {
            if(strArray[i] == ch)
                return i;
        }
        return -1;
    }*/

/**
 * 为了解决这个问题，我们可以定义一个哈希表（外部空间），其键值（Key）是字符，而值（Value）是该字符出现的次数。
 *
 * 　　同时我们还需要从头开始扫描字符串两次：
 *
 * 　　（1）第一次扫描字符串时，每扫描到一个字符就在哈希表的对应项中把次数加1。（时间效率O(n)）
 *
 * 　　（2）第二次扫描时，每扫描到一个字符就能从哈希表中得到该字符出现的次数。这样第一个只出现一次的字符就是符合要求的输出。（时间效率O(n)）
 */
/*    public int firstNotRepeatingChar(String str) {
        if("".equals(str) || str == null)
            return -1;

        char[] strArr = str.toCharArray();

        Map<Character, Integer> map = new HashMap<>();

        for (char c : strArr) {
            if(map.containsKey(c))
                map.put(c, map.get(c) + 1);
            else
                map.put(c, 1);
        }

        for (int i = 0; i < strArr.length; i++) {
            if(map.get(strArr[i]) == 1)
                return i;
        }
        return -1;
    }*/

    public int firstNotRepeatingChar(String str) {
        if("".equals(str) || str == null)
            return -1;

        char[] strArr = str.toCharArray();

        int[] hashTable = new int[256];

        for (int i = 0; i < strArr.length; i++) {
            hashTable[strArr[i]]++;
        }

        for (int i = 0; i < strArr.length; i++) {
            if(hashTable[strArr[i]] == 1)
                return i;
        }
        return -1;
    }

}
