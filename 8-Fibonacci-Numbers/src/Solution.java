/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，
 * 请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 */

import org.junit.Test;

/**
 * f(n) = f(n-1) + f(n-2)，第一眼看就是递归啊，
 * 简直完美的递归环境，递归肯定很爽，这
 * 样想着关键代码两三行就搞定了，注意这题的n是从0开始的：
 * if(n<=1) return n;
 * else return Fibonacci(n-1)+Fibonacci(n-2);
 * 然而并没有什么用，测试用例里肯定准备着一个超大的n来让Stack Overflow，
 * 递归本质是利用栈，栈深度太深就会溢出；
 *
 *
 * 非递归的方法，就是剑指offer思路，
 * 每次使用两个变量a,b来计算下一个数的值sum,
 * 然后a,b,sum分别是斐波那契数列中的三个数，
 * 那么就令a=b,b=sum,这样a和b就往下移动了一个位置，
 * 再计算sum就是滴4个数了，重复这个过程即可。
 */

/*public class Solution {

    public int findN(int n) {
        return fibonacci(n);

    }

    private int fibonacci(int n) {
        if(n <= 1)
            return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    @Test
    public void test() {
        System.out.println(findN(1));
    }
}*/

public class Solution {

    public long fibonacci(long n) {

        long a = 0;
        long b = 1;
        long sum = a + b;

        if(n == 0)
            return a;
        else if(n == 1)
            return b;
        else if( n == 2)
            return sum;

        while(n >= 3) {
            a = b;
            b = sum;
            sum = a + b;
            n--;
        }
        return sum;
    }

    @Test
    public void test() {
        for (int i = 0; i < 39; i++) {
            System.out.println(fibonacci(i));
        }
    }
}
