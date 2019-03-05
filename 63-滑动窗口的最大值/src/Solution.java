import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
 * 他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */

/**
 * 使用一个单调非增队列，队头保存当前窗口的最大值，
 * 后面保存在窗口移动过程中导致队头失效（出窗口）后的从而晋升为窗口最大值的候选值。
 */
public class Solution {

    public ArrayList<Integer> maxInWindows(int [] num, int size) {

        ArrayList<Integer> res = new ArrayList<>();
        if(num == null || num.length == 0 || size <= 0 || size > num.length) {
            return res;
        }

        LinkedList<Integer> queue = new LinkedList<>();
        int start = 0;
        int end = size - 1;

        for (int i = start; i <= end; i++) {
            addLast(queue, num[i]);
        }
        res.add(queue.getFirst());

        while(end < num.length - 1) {
            addLast(queue, num[++end]);
            //窗口中最大值是否要从queue中移除(出窗口)
            if(queue.getFirst() == num[start]) {
                queue.pollFirst();
            }
            start++;
            res.add(queue.getFirst());
        }
        return res;
    }

    private void addLast(LinkedList<Integer> queue, int num) {
        if(queue == null)
            return;
        //加元素之前要确保该元素小于等于队尾元素
        while(queue.size() != 0 && num > queue.getLast()) {
            queue.pollLast();
        }
        queue.addLast(num);
    }

}
