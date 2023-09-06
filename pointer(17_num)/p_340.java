import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

//
//340. Longest Substring with At Most K Distinct Characters
//        Given a string s and an integer k, return the length of the longest substring of s that contains at most k distinct characters.
//
//
//
//        Example 1:
//
//        Input: s = "eceba", k = 2
//        Output: 3
//        Explanation: The substring is "ece" with length 3.
//        Example 2:
//
//        Input: s = "aa", k = 1
//        Output: 2
//        Explanation: The substring is "aa" with length 2.
public class p_340 {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {

        HashMap< Character, Integer> s_map = new HashMap<>();
        int ans = 0;
        int l = 0;

        for (int r=0; r < s.length(); r++){
            s_map.put( s.charAt(r), r);

            if( s_map.size() > k){
                int low = Collections.min( s_map.values());
                s_map.remove(s.charAt(low));
                l = low + 1;//有的重复项最右侧下标用++则失败
            }

            ans = Math.max( ans, r-l+1);
            //math方法需要调用 =号赋值。。。
        }

        return ans;
    }
}
