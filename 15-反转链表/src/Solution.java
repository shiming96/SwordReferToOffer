/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 */

import org.junit.Test;

/**
 * 先反转第一个节点；
 * 然后后面的依次反转；
 */
public class Solution {

    private class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return this.val + "->";
        }
    }

    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode p = head.next;
        ListNode pre = head;
        pre.next = null;
        ListNode next = p.next;

        while( p != null) {
            p.next = pre;
            pre = p;
            p = next;
            if(p != null)
                next = p.next;
        }
        head = pre;
        return head;
    }

    @Test
    public void test() {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        one.next = two;
        ListNode three = new ListNode(3);
        two.next = three;
        ListNode four = new ListNode(4);
        three.next = four;
        ListNode five = new ListNode(5);
        four.next = five;

        ListNode head = reverseList(one);
        System.out.print(head);
        System.out.print(head.next);
        System.out.print(head.next.next);
        System.out.print(head.next.next.next);
        System.out.print(head.next.next.next.next);
    }
}
