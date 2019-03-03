/**
 *给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */

/**
 * 使用快慢指针，快指针每次走两步，慢指针每次走一步，如果快慢指针相遇说明有环；
 * 有环以后，需要寻找环入口节点，已经找到了一个环的中的节点，
 * 利用这个节点，去往下遍历，由于是环，所以这个节点肯定会和自身相遇，
 * 相遇以后，记录相遇过程中走的步数，就是环的长度
 * 知道环的长度以后，然后再利用快慢指针的思想，
 * 快指针先走环长度，然后快慢指针再一起走，
 * 这样因为快指针先走了环的长度，
 * 当两者相遇肯定是环的入口节点相遇
 * （为啥呢，因为快慢指针肯定会进入环里面，而由于快指针先走了环的长度，所以也就是一个周期，
 * 所以只要进入环，那么这两个指针必然相遇）
 */
public class Solution {

    private class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    private boolean flag = true;

    public ListNode EntryNodeOfLoop(ListNode pHead) {

        if(pHead == null || pHead.next == null)
            return null;
        ListNode pNode = judgeHasChain(pHead);
        if(pNode != null) {
            int lengthChain = 1;
            ListNode pNodeCopy = pNode.next;
            while(pNodeCopy != pNode) {
                lengthChain++;
                pNodeCopy = pNodeCopy.next;
            }
            ListNode fast = pHead;
            ListNode slow = pHead;
            int temp = 0;
            while(temp < lengthChain) {
                fast = fast.next;
                temp++;
            }
            while(fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }
            return fast;
        }
        return null;
    }

    private ListNode judgeHasChain(ListNode pHead) {
        ListNode fast = pHead.next;
        ListNode slow = pHead;

        while(fast != slow) {
            if(fast != null && fast.next != null) {
                fast = fast.next.next;
            } else {
                flag = false;
                break;
            }
            if(slow != null) {
                slow = slow.next;
            } else {
                flag = false;
                break;
            }
        }
        if(flag)
            return fast;
        return null;
    }
}
