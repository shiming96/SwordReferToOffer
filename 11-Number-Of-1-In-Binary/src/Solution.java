/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示
 */

import org.junit.Test;

/**
 * 如果一个整数不为0,那么这个整数至少有一个1。如果我们把这个整数减1，
 * 那么原来处在整数最右边的1就会变成0, 原来在1后边的所有的0都会变成1，其余位不变。
 *
 * 1100 - 1 = 1011
 * 1100 & 1011 = 1000
 *
 * 把一个整数减去1，再和原数做运算， 会把该整数最右边一个1变成0
 *
 * 一个整数的二进制有多少个1， 就可以做多少次这样的运算
 */
public class Solution {

/*    public int NumberOf1(int n) {

        int count = 0;

        while(n != 0) {
            n = (n - 1) & n;
            count++;
        }

        return count;
    }*/

    //无符号右移处理负数问题
    public int NumberOf1(int n) {
        int count = 0;

        while( n != 0) {
            count += n & 1;
            n >>>= 1;
        }

        return count;
    }


}
