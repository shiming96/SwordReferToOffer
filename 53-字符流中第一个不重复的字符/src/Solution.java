/**
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，
 * 第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 */
public class Solution {

    int[] charArray = new int[256];
    int index = 1;

    //Insert one char from stringstream
    public void Insert(char ch) {
        if(charArray[(int) ch] == 0) {
            charArray[(int) ch] = index;
            index++;
        } else
            charArray[(int) ch] = -1;
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        char result = '#';
        int min = index;
        for (int i = 0; i < 256; i++) {
            if(charArray[i] > 0) {
                if(charArray[i] <= min) {
                    min = charArray[i];
                    result = (char) i;
                }
            }
        }
        return result;
    }
}
