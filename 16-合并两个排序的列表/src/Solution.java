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

    //非递归
    /*public ListNode Merge(ListNode list1, ListNode list2) {

        ListNode resultList = new ListNode(0);
        ListNode dummy = resultList;

        while( list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                dummy.next = list1;
                list1 = list1.next;
            } else {
                dummy.next = list2;
                list2 = list2.next;
            }
            dummy = dummy.next;
        }

        if(list1 == null)
            dummy.next = list2;
        else
            dummy.next = list1;

        return resultList.next;

    }*/


    public ListNode Merge(ListNode list1, ListNode list2) {

        if(list1 == null)
            return list2;

        if(list2 == null)
            return list1;

        if(list1.val <= list2.val) {
            list1.next = Merge(list1.next, list2);
            return list1;
        }
        else {
            list2.next = Merge(list1, list2.next);
            return list2;
        }

    }

}
