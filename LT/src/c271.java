import java.util.ArrayList;
import java.util.List;

public class c271 {
    /*
     * @param strs: a list of strings
     * @return: encodes a list of strings to a single string.
     */
    public String encode(List<String> strs) {
        // write your code here

        StringBuilder sb = new StringBuilder();

        for (String str: strs){
            int n = str.length();
            sb.append(n).append("/").append(str);
        }
        return sb.toString();
    }

    /*
     * @param str: A string
     * @return: decodes a single string to a list of strings
     */
    public List<String> decode(String str) {
        // write your code here
        List<String> ans = new ArrayList<>();
        int i = 0;

        while (i < str.length()){
            int slash = str.indexOf("/", i);

            int size = Integer.valueOf(str.substring(i, slash));
            ans.add(str.substring(slash+1, slash+1+size));
            i = slash+1+size;
        }
        return ans;
    }
}
