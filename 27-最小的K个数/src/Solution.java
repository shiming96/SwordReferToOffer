/**
 * 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,
 */

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 使用一个大小为K的最大堆，然后堆里面最大的数是堆顶，
 * 然后每次比较堆顶的数和数组中的数，
 * 如果堆顶的数比数组中的数A大，那么就把堆顶的数弹出来，
 * 把数组中的数A进堆，这样子到最后堆里面的堆顶始终是比外面的数小，
 * 而堆里的其他数是小于堆顶的数（最大堆的性质），所以堆中的数就是最小的k个数。
 */

public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();

        if( k > input.length || k == 0)
            return list;
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2.compareTo(o1));
        
        for(int i = 0; i < input.length; i++) {
            if(i < k) {
                maxHeap.add(input[i]);
            } else {
                if(maxHeap.peek() > input[i]) {
                    maxHeap.poll();
                    maxHeap.add(input[i]);
                }
            }
        }
        while(!maxHeap.isEmpty()) {
            list.add(maxHeap.poll());
        }
        return list;
        
    }
}
