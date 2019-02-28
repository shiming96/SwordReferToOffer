import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        if(sum <= 1)
            return res;

        LinkedList<Integer> queue = new LinkedList<>();

        int n = 1;
        int halfSum = (sum >> 1) + 1;   // (2 / sum) + 1    注意优先级
        int queueSum = 0;

        while(n <= halfSum) {
            queue.addLast(n);
            queueSum += n;
             if(queueSum > sum) {
                while(queueSum > sum)
                    queueSum -= queue.pollFirst();
             }
            if(queueSum == sum) {
                res.add(new ArrayList<>(queue));
                queueSum -= queue.pollFirst();
            }
            n++;
        }
        return res;
    }
}
