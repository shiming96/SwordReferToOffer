/**
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 剑指offer的思路，递归的思路，
 * 只要链表不为空，一直往后进行遍历，然后直到到达链表的末尾，就开始用数组保存下来结果。
 */

/*
public class Solution {

    private class ListNode {
        int val;
        ListNode next = null;

        private ListNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        if(listNode == null)
            return arrayList;
        printListFromTailToHead(listNode, arrayList);
        return arrayList;
    }

    private void printListFromTailToHead(ListNode listNode, ArrayList<Integer> arrayList) {

        if(listNode.next != null)
            printListFromTailToHead(listNode.next, arrayList);
        arrayList.add(listNode.val);

    }

    @Test
    public void test() {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(3);
        listNode.next.next = new ListNode(22);
        listNode.next.next.next = new ListNode(9);
        System.out.println(printListFromTailToHead(listNode));
    }
}
*/

/**
 * 利用栈的先进后出特性
 */

public class Solution {

    private class ListNode {
        int val;
        ListNode next = null;

        private ListNode(int val) {
            this.val = val;
        }
    }

    private Stack<Integer> stack = new Stack<>();

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        while(listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }

        while(!stack.isEmpty())
            arrayList.add(stack.pop());

        return arrayList;
    }

    @Test
    public void test() {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(3);
        listNode.next.next = new ListNode(22);
        listNode.next.next.next = new ListNode(9);
        System.out.println(printListFromTailToHead(listNode));
    }

}
