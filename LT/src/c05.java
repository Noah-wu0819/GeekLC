public class c05 {
    public String longestPalindrome(String s) {
        int len = 1;
        int maxLen = Integer.MIN_VALUE;
        int maxLeft = 0;

        for (int i = 0; i < s.length(); i++){
            int left = i - 1;
            int right = i + 1;

            while (left >= 0 && s.charAt(left) == s.charAt(i)){
                len++;
                left--;
            }

            while (right < s.length() && s.charAt(right) == s.charAt(i)){
                len++;
                right++;
            }

            while (left >= 0 && right < s.length() && s.charAt(right) == s.charAt(left)){
                len = len + 2;
                left--;
                right++;
            }

            if (len > maxLen){
                maxLen = len;
                maxLeft = left;
            }

            len = 1;
        }
        return s.substring(maxLeft + 1, maxLeft + maxLen + 1);
    }
}
