/**
 * 输入两个链表，找出它们的第一个公共结点
 */

/**
 *
 */
public class Solution {

    private class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null)
            return null;

        int head1Length = 0;
        int head2Length = 0;

        ListNode p1 = pHead1;
        ListNode p2 = pHead2;

        while(p1 != null) {
            head1Length++;
            p1 = p1.next;
        }

        while(p2 != null) {
            head2Length++;
            p2 = p2.next;
        }

        int length = head1Length - head2Length;


        if(length > 0) {
            for (int i = 0; i < length; i++) {
                pHead1 = pHead1.next;
            }
        } else {
            for (int i = 0; i < -length; i++) {
                pHead2 = pHead2.next;
            }
        }


        while(pHead1 != pHead2) {
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return pHead1;
    }
}
