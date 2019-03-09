/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */

import java.util.Stack;

/**
 * 利用一个辅助栈来存放最小值
 * 栈  3，4，2，5，1
 * 辅助栈 3，3，2，2，1
 * 每入栈一次，就与辅助栈顶比较大小，如果小就入栈，如果大就入栈当前的辅助栈顶
 * 当出栈时，辅助栈也要出栈
 * 栈3 辅助栈入3，
 * 栈4，辅助栈栈顶比4小入3，
 * 栈入2，辅助栈栈顶是3比2大所以入2，每次都是把栈顶与入栈的值比较，入那个最小的，这样栈顶一直最小。
 */
public class Solution {
    Stack<Integer> mainStack = new Stack<>();
    Stack<Integer> assistStack = new Stack<>();
    
    public void push(int node) {
        if(assistStack.isEmpty()) {
            assistStack.push(node);
        } else {
            int num = assistStack.peek();
            if(num <= node)
                assistStack.push(num);
            else {
                assistStack.push(node);
            }
        }
        mainStack.push(node);
    }
    
    public void pop() {
        mainStack.pop();
        assistStack.pop();
    }
    
    public int top() {
        return mainStack.peek();
    }
    
    public int min() {
        return assistStack.peek();
    }
}
