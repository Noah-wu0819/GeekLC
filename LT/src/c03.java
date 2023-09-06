import java.util.HashSet;

public class c03 {
    public int lengthOfLongestSubstring(String s) {


        int left = 0;
        int right = -1;
        int ans = 0;

        char c[] =  s.toCharArray();
        HashSet<Character> set = new HashSet<Character>();
        while (left < c.length){

            if (left != 0){
                set.remove(c[left-1]);
            }

            int temp = 0;

            while (right+1 < c.length && !set.contains(c[right+1])){
                    set.add(c[right+1]);
                    right++;
            }
            ans = Math.max(ans, right - left+1 );
            left++;
        }
        //------------------------
        int l = 0;
        int r = -1;
        int a = 0;

        char[] ch = s.toCharArray();
        HashSet<Character> sss = new HashSet<>();

        while (l < s.length()){
            if (l != 0){
                sss.remove(ch[l - 1]);
            }

            while (r + 1 < ch.length && !sss.contains(ch[r+1])){
                sss.add(ch[r+1]);
                r++;
            }
            a = Math.max(a, r - l + 1);
            l++;
        }

        return ans;


    }

    public static void main(String[] args) {
        String s = "pwwkew";
        c03 c = new c03();
        System.out.println(c.lengthOfLongestSubstring(s));
    }
}
