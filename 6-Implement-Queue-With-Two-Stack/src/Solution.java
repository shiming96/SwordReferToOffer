/**
 * 用两个栈实现队列
 */

import org.junit.Test;

import java.util.Stack;

/**
 *剑指offer的思路，用两个栈来实现队列，栈1的话用来入队，
 * 队列每进入一个元素就入栈1，栈2的话用来出队，
 * 队列如果要出队，首先判断栈2是不是空，
 * 是空，就把栈1弹出来进入栈2（因为栈是先入后出，两次先入后出就是先入先出了，负负得正嘛~），
 * 然后从栈2开始弹，如果栈2不为空，直接从栈2开始弹
 */
public class Solution {

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void push(int val) {
        stack1.push(val);
    }

    public int pop() {
        if(stack2.isEmpty()) {
            while(!stack1.isEmpty())
                stack2.push(stack1.pop());
        }
        if(stack2.isEmpty())
            return -1;
        return stack2.pop();
    }

    @Test
    public void test() {
        push(1);
        push(2);
        push(3);
        push(4);
        System.out.println(pop());
        System.out.println(pop());
        System.out.println(pop());
        System.out.println(pop());
    }
}
