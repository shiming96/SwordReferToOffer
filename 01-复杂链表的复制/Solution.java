public class Solution {

    private class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;
    
        RandomListNode(int label) {
            this.label = label;
        }
    }

    /**
    O(n2)的普通解法
　　第一步是复制原始链表上的每一个结点，并用Next节点链接起来；

　　第二步是设置每个结点的Sibling节点指针。

    对于一个含有n个结点的链表，由于定位每个结点的Sibling都需要从链表头结点开始经过O(n)步才能找到，因此这种方法的总时间复杂度是O(n2)。
     */
    public RandomListNode Clone(RandomListNode pHead) {
        if(pHead == null)
            return null;
        RandomListNode head = new RandomListNode(pHead.label);
        RandomListNode twoHead = head;
        RandomListNode retHead = head;
        RandomListNode twoPhead = pHead;
        pHead = pHead.next;
        while(pHead != null) {
            RandomListNode node = new RandomListNode(pHead.label);
            head.next = node;
            head = head.next;
            pHead = pHead.next;
        }
        int data = 0;
        while(twoPhead != null) {
            if(twoPhead.random != null) {
                data = twoPhead.random.label;
                RandomListNode mid = retHead;
                while(mid != null && mid.label != data) {
                    mid = mid.next;
                }
                twoHead.random = mid;
            }
            twoHead = twoHead.next;
            twoPhead = twoPhead.next;
        }
        return retHead;
    }

    /**
    借助辅助空间的O(n)解法
　　第一步仍然是复制原始链表上的每个结点N创建N'，然后把这些创建出来的结点用Next链接起来。同时我们把<N,N'>的配对信息放到一个哈希表中。

　　第二步还是设置复制链表上每个结点的m_pSibling。由于有了哈希表，我们可以用O(1)的时间根据S找到S'。

    此方法使用空间换时间。对于有n个结点的链表我们需要一个大小为O(n)的哈希表，也就是说我们以O(n)的空间消耗把时间复杂度由O(n2)降低到O(n)。
     */
    public RandomListNode Clone2(RandomListNode pHead) {
        return null;
    }
    /**
     * 不借助辅助空间的O(n)解法
     * 借助原链表
     * 
     * https://www.cnblogs.com/edisonchou/p/4790090.html 
     */
    public RandomListNode Clone3(RandomListNode pHead) {
        if(pHead == null)
            return null;
        
        RandomListNode currentNode = pHead;
        //1、复制每个结点，如复制结点A得到A1，将结点A1插到结点A后面
        while(currentNode != null) {
            RandomListNode cloneNode = new RandomListNode(currentNode.label);
            RandomListNode nextNode = currentNode.next;
            currentNode.next = cloneNode;
            cloneNode.next = nextNode;
            currentNode = nextNode;
        }
        
        currentNode = pHead;
        //2、重新遍历链表，复制老结点的随机指针给新结点，如A1.random = A.random.next;
        while(currentNode != null) {
            currentNode.next.random = currentNode.random == null ? null : currentNode.random.next;
            currentNode = currentNode.next.next;
        }

        //3、拆分链表，将链表拆分为原链表和复制后的链表
        currentNode = pHead;
        RandomListNode pCloneHead = pHead.next;
        while(currentNode != null) {
            RandomListNode cloneNode = currentNode.next;
            currentNode.next = cloneNode.next;
            cloneNode.next = cloneNode.next == null ? null : cloneNode.next.next;
            currentNode = currentNode.next;
        }

        return pCloneHead;
    }
}