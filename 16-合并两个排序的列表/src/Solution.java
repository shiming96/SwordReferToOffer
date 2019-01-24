/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，
 * 当然我们需要合成后的链表满足单调不减规则
 */


public class Solution {

    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode() {
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeList(ListNode list1, ListNode list2) {

        ListNode resultList = new ListNode(0);
        ListNode tempHead = resultList;

        while( list1 != null && list2 != null) {

            if(list1.val < list2.val) {
                tempHead.next = list1;
                list1 = list1.next;
            } else {
                tempHead.next = list2;
                list2 = list2.next;
            }
        }
        tempHead = tempHead.next;

        if(list1 == null)
            tempHead.next = list2;
        else
            tempHead.next = list1;

        return resultList.next;

    }




}
