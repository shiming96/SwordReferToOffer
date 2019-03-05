/**
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），
 * 因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */

public class Solution {

    public int movingCount(int threshold, int rows, int cols) {

        if(threshold < 0 || rows < 0 || cols < 0)
            return 0;

        boolean[] visited = new boolean[rows * cols];

        return walk(threshold, rows, cols, 0, 0, visited);

    }

    private int walk(int threshold, int rows, int cols, int i, int j, boolean[] visited) {

        if(!isLegalPosition(rows, cols, i, j) || visited[i * cols + j] || ((bitSum(i) + bitSum(j)) > threshold))
                return 0;

        int res = 1;
        visited[i * cols + j] = true;
        res += walk(threshold, rows, cols, i + 1, j, visited)
                + walk(threshold, rows, cols, i - 1, j, visited)
                + walk(threshold, rows, cols, i, j + 1, visited)
                + walk(threshold, rows, cols, i, j - 1, visited);

        return res;
    }

    private boolean isLegalPosition(int rows, int cols, int i, int j) {
        return i >= 0 && j >= 0 && i <= rows - 1 && j <= cols - 1;
    }

    private int bitSum(int num) {
        int sum = 0;
        while(num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

}
