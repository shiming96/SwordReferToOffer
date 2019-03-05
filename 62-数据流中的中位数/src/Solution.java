import java.util.PriorityQueue;

/**
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，
 * 那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，
 * 那么中位数就是所有数值排序之后中间两个数的平均值。我们使用Insert()方法读取数据流，
 * 使用GetMedian()方法获取当前读取数据的中位数。
 */

public class Solution {

    //O(nlogn)

/*    private List<Integer> list = new ArrayList<>();

    public void Insert(Integer num) {
        list.add(num);
    }

    public Double GetMedian() {
        if(list == null)
            return 0.0;

        list.sort(Integer::compareTo);

        int len = list.size();

        if(len % 2 != 0) {
            return Double.valueOf(list.get(len / 2));
        } else {
            return (Double.valueOf(list.get(len / 2)) + Double.valueOf(list.get(len / 2 - 1))) / 2;
        }
    }*/

    private PriorityQueue<Integer> minHeap = new PriorityQueue<>((o1, o2) -> o1 - o2);

    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);

    int count = 0;

    //O(logn)
    public void Insert(Integer num) {
        count++;
        //编号是奇数就放入小根堆（右半边），否则放入大根堆
        if(count % 2 != 0) {
            //如果要放入右半边的数比左半边的最大值要小则需调整左半边的最大值放入右半边并将当前这个数放入左半边，
            // 这样才能保证右半边的数都比左半边的大
            if(maxHeap.size() > 0 && num < maxHeap.peek()) {
                maxHeap.add(num);
                num = maxHeap.poll();
            }
            minHeap.add(num);
        } else {
            if(minHeap.size() > 0 && num > minHeap.peek()) {
                minHeap.add(num);
                num = minHeap.poll();
            }
            maxHeap.add(num);
        }
    }

    public Double GetMedian() {

        if(count == 0)
            return 0.0;
        if(count % 2 != 0)
            return minHeap.peek().doubleValue();
        else
            return (minHeap.peek().doubleValue() + maxHeap.peek().doubleValue()) / 2;

    }

}
