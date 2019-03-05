/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
 * 例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，
 * 但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，
 * 路径不能再次进入该格子。
 */

public class Solution {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {

        if(matrix == null || matrix.length != rows * cols || str == null)
            return false;

        boolean[] visited = new boolean[matrix.length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(hasPathCore(matrix, rows, cols, i, j, str, 0, visited))
                    return true;
            }
        }
        return false;
    }

    private boolean hasPathCore(char[] matrix, int rows, int cols, int i, int j, char[] str, int index, boolean[] visited) {

        if(index == str.length)
            return true;

        //越界或字符不匹配或该位置已在路径上
        if(!match(matrix, rows, cols, i, j, str[index]) || visited[i * cols + j]) {
            return false;
        }
        visited[i * cols + j] = true;
        boolean res = hasPathCore(matrix, rows, cols, i + 1, j, str, index + 1, visited)
                    || hasPathCore(matrix, rows, cols, i - 1, j, str, index + 1, visited)
                    || hasPathCore(matrix, rows, cols, i, j + 1, str, index + 1, visited)
                    || hasPathCore(matrix, rows, cols, i, j - 1, str, index + 1, visited);
        visited[i * cols + j] = false;
        return res;
    }

    private boolean match(char[] matrix, int rows, int cols, int i, int j, char c) {
        if( i < 0 || i > rows - 1 || j < 0 || j > cols - 1)
            return false;

        return matrix[i * cols + j] == c;
    }
}
