import java.util.LinkedList;

/**
 *Java实现的话，可以使用LinkedList，考虑删除节点的效率。模拟游戏过程即可：
 * 其实这是个约瑟夫环问题，但是绝对没必要去死记硬背数学公式，直接用链表模拟游戏过程即可。
 */
public class Solution {
    public int LastRemaining_Solution(int n, int m) {
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int a = 0;  //a为起始小朋友的位置
        while(list.size() > 1) {
            a = (a + m - 1) % list.size();
            list.remove(a);
        }
        if(list.size() == 1)
            return list.get(0);
        return -1;

    }
}
