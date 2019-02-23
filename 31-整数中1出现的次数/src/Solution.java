/**
 * 输入一个整数n，求从1到n这n个整数的十进制表示中1出现的次数。
 * 例如输入12，从1到12这些整数中包含1的数字有1，10，11和12，1一共出现了5次。
 */

/**
 * https://blog.csdn.net/yi_Afly/article/details/52012593
 */
public class Solution {

    public int countOne(int n) {
        if(n < 1)
            return 0;

        int count = 0;
        int base = 1;
        int round = n;

        while(round > 0) {
            int weight = round % 10;
            round = round / 10;
            count += round * base;
            if(weight == 1)
                count += (n % base) + 1;
            else if(weight > 1)
                count += base;
            base *= 10;
        }
        return count;
    }
}
