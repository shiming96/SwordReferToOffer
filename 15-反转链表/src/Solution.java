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

    public ListNode ReverseList(ListNode head) {
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
}
