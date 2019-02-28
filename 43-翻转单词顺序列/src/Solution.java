
/**
 * “student. a am I”
 *
 * “I am a student.”
 */

public class Solution {
    public String ReverseSentence(String str) {

        if(str.matches("\\s+"))
            return str;

        String[] strings = str.split("\\s+");

        StringBuilder sb = new StringBuilder();

        for(int i = strings.length - 1; i >= 0; i--) {
            sb.append(strings[i]).append(" ");
        }
        sb.replace(sb.length() - 1, sb.length(), "");
        return sb.toString();

    }

}
