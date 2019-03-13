/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */

/**
 * 剑指offer的思路.就是一个空格变成了%20，也就是说每有一个空格，长度要增加2，
 * 所以首先先计算有多少个空格，这样长度就能增加多少，得到增加后的长度Length。
 * 然后new一个Length长度的字符数组，从尾到头开始复制原来的数组，
 * 如果复制过程中，如果字符不是空格，直接复制，
 * 如果字符是空格，那么需要把这个空格变成%20（
 * 这个复制过程就是把新建的数组比如现在到了 K这个位置，
 * 然后就是K，K-1，K-2这三个位置依次变成0,2，%这三个字符，
 * 因为是从后往前复制的所以是倒序），重复这个过程就行。
 * 如果相等，返回true;
 */
public class Solution {

    /*public String replaceSpace(StringBuffer str) {
        String str1 = str.toString();
        if(str1.equals(""))
            return str1;

        char[] strArray = str1.toCharArray();
        int lengthSpace = 0;

        for (char c : strArray) {
            if( c == ' ')
                lengthSpace++;
        }

        int newStrLength = strArray.length + lengthSpace * 2;
        char[] newStr = new char[newStrLength];

        int j = newStrLength - 1;
        int i = strArray.length - 1;

        //正过来遍历也可以
        while( i >= 0) {
            if(strArray[i] != ' ')
                newStr[j--] = strArray[i--];
            else {
                newStr[j--] = '0';
                newStr[j--] = '2';
                newStr[j--] = '%';
                i--;
            }
        }
        return new String(newStr);
    }*/

    public String replaceSpace(StringBuffer str) {

        String s = str.toString();
        if("".equals(s))
            return s;

        char[] chars = s.toCharArray();

        StringBuilder res = new StringBuilder();
        for (char aChar : chars) {
            if(aChar == ' ')
                res.append("%20");
            else
                res.append(aChar);
        }

        return res.toString();
    }

}
