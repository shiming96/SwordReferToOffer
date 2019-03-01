/**
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
 * 而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class Solution {

    public boolean match(char[] str, char[] pattern) {

        if(str == null || pattern == null)
            return false;

        if(str.length == 0 && pattern.length == 0) {
            return true;
        }
        return matchCore(str, 0, pattern, 0);


    }

    private boolean matchCore(char[] str, int p1, char[] pattern, int p2) {

        if(p2 >= pattern.length)
            return p1 >= str.length;
        if(p1 >= str.length) {
            if(p2 + 1 < pattern.length && pattern[p2 + 1] == '*') {
                return matchCore(str, p1, pattern, p2 + 2);
            } else {
                return false;
            }
        }
        if(p2 + 1 < pattern.length && pattern[p2 + 1] == '*') {
            if(pattern[p2] == '.' || pattern[p2] == str[p1]) {
                return matchCore(str, p1 + 1, pattern, p2) || matchCore(str, p1, pattern, p2 + 2);
            } else {
                return matchCore(str, p1, pattern, p2 + 2);
            }
        } else {
            if(pattern[p2] == '.' || pattern[p2] == str[p1]) {
                return matchCore(str, p1 + 1, pattern, p2 + 1);
            } else {
                return false;
            }
        }


    }
}
