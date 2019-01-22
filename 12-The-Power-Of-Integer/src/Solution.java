/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 */

import org.junit.Test;

/**
 * 就是穷举，把所有可能穷举出来，然后对每一种情况处理。
 */

public class Solution {

    public double Power(double base, int exponent) {

        //指数为0
        if (exponent == 0) {
            //底数为0
            if (equalZero(base))
                return 0;
                //底数不为0 除0之外的任何数的0次方都是1
            else
                return 1;
        } else if (exponent > 0) {
            return complex(base, exponent);
        } else {
            if (equalZero(base)) {
                if (base > 0)   //底数是正0，那么就是正无穷
                    return Double.POSITIVE_INFINITY;
                else {
                    if (exponent % 2 == 0)   //指数是偶数次方
                        return Double.POSITIVE_INFINITY;
                    return Double.NEGATIVE_INFINITY;    //其它结果负无穷
                }
            }
            return 1 / complex(base, exponent);//可以知道除了上述结果，其它都是指数是负数。比如2的-3次方，先计算2的3次方，最后求倒数。
        }
    }

    ////判断一个doule类型的数是不是0，必须这样判断，不能直接与0进行比较，因为浮点数本身不精确
    private boolean equalZero(double base) {
        if (base > 0 && base < 0.00000001)
            return true;
        if (base < 0 && base > -0.00000001)
            return true;
        return false;

    }

    private double complex(double base, int exponent) {
        double result = 1.0;
        if (exponent < 0)//如果指数小于0，比如2的-3次方，先计算2的3次方，然后求倒数
            exponent = 0 - exponent;
        for (int i = 0; i < exponent; i++)
            result *= base;
        return result;
    }

    @Test
    public void test() {
        System.out.println(Power(0.00001, -3));
    }

}
