public class c647 {
    public int countSubstrings(String s) {

        if (s.length() < 1 ) return 0;
        int ans = 0;
        int n = s.length();

        for (int i = 0; i < 2 * n - 1; i++ ){
            int left = i/2;
            int right = left + i%2;

            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                ans++;
                left--;
                right++;
            }
        }
        return ans;
    }
}
