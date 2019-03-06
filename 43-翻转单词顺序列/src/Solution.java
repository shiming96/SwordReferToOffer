/**
 * “student. a am I”
 *
 * “I am a student.”
 */

public class Solution {

    public String ReverseSentence(String str) {
        if(str == null || "".equals(str))
            return str;

        char[] strArray = str.toCharArray();

        reverse(strArray, 0, strArray.length - 1);

        int begin = 0;
        for (int i = 0; i < strArray.length; i++) {
            if(strArray[i] == ' ') {
                reverse(strArray, begin, i - 1);
                begin = i + 1;
            }
        }

        if(begin < strArray.length - 1) {
            reverse(strArray, begin, strArray.length - 1);
        }
        return String.valueOf(strArray);
    }

    private void reverse(char[] strArray, int start, int end) {

        int i = start;
        int j = end;

        while(start < end) {
            char temp = strArray[end];
            strArray[end] = strArray[start];
            strArray[start] = temp;
            start++;
            end--;
        }
    }

    //使用了多余空间和String函数，面试不推荐
/*    public String ReverseSentence(String str) {

        if("".equals(str))
            return str;

        if(str.matches("\\s+"))
            return str;

        String[] strings = str.split(" ");

        StringBuilder sb = new StringBuilder();

        for(int i = strings.length - 1; i >= 0; i--) {
            sb.append(strings[i]).append(" ");
        }
        return sb.toString().substring(0, sb.length() - 1);

    }*/

}
