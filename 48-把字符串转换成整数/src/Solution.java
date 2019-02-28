
/**
 * 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0。
 */
public class Solution {
    public int StrToInt(String str) {
        if("".equals(str) || str.length() == 0)
            return 0;
        char[] chars = str.toCharArray();
        int symbol = 0;
        int sum = 0;
        if(chars[0] == '-')
            symbol = 1;

        for (int i = symbol; i < chars.length; i++) {
            if(chars[i] == '+')
                continue;
            if(chars[i] > '9' || chars[i] < '0')
                return 0;
            sum = sum * 10 + (chars[i] - '0');
        }
        return symbol == 0 ? sum : -sum;
    }

}
