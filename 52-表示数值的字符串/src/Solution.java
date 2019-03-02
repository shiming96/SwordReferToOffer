/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
public class Solution {

    public boolean isNumeric(char[] str) {
        int index = 0;
        if(str.length == 0)
            return false;
        if(str.length == 1 && (str[0] == '+' || str[0] == '-'))
            return false;
        if(str[0] == '+' || str[0] == '-')
            index++;
        index = judgeDigits(str, index);
        if(index == str.length)
            return true;
        if(str[index] == '.') {
            index++;
            if(index == str.length)
                return false;
            index = judgeDigits(str, index);
            if(index == str.length)
                return true;
            if(str[index] == 'e' || str[index] == 'E') {
                index++;
                return judgeE(str, index);
            }
            return false;
        } else if(str[index] == 'e' || str[index] == 'E') {
            index++;
            return judgeE(str, index);
        }
        return false;
    }

    private boolean judgeE(char[] str, int index) {

        if(index >= str.length)
            return false;
        if(str[index] == '+' || str[index] == '-') {
            index++;
        }
        if(index >= str.length)
            return false;
        index = judgeDigits(str, index);
        if(index == str.length)
            return true;
        return false;

    }

    private int judgeDigits(char[] str, int index) {

        while (index < str.length) {
            int num = str[index] - '0';
            if(num <= 9 && num >= 0)
                index++;
            else
                break;
        }
        return index;
    }
}
