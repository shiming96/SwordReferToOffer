/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */

public class Solution {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }


/*    public ListNode deleteDuplication(ListNode pHead) {

        if(pHead == null)
            return null;

        ListNode node = new ListNode(Integer.MIN_VALUE);
        node.next = pHead;
        ListNode pre = node;
        ListNode p = pHead;
        boolean deleteMode = false;
        while(p != null) {
            if(p.next != null && p.next.val == p.val) {
                p.next = p.next.next;
                deleteMode = true;
            } else if(deleteMode) {
                pre.next = p.next;
                p = pre.next;
                deleteMode = false;
            } else {
                pre = p;
                p = p.next;
            }
        }
        return node.next;
    }*/

    public ListNode deleteDuplication(ListNode pHead) {
        if(pHead == null || pHead.next == null)// 只有0个或1个结点，则返回
            return pHead;

        if(pHead.val == pHead.next.val) {// 当前结点是重复结点
            ListNode pNode = pHead.next;
            while(pNode != null && pNode.val == pHead.val) {
                // 跳过值与当前结点相同的全部结点,找到第一个与当前结点不同的结点
                pNode = pNode.next;
            }
            return deleteDuplication(pNode);// 从第一个与当前结点不同的结点开始递归
        } else { // 当前结点不是重复结点
            pHead.next = deleteDuplication(pHead.next);// 保留当前结点，从下一个结点开始递归
            return pHead;
        }
    }

}
