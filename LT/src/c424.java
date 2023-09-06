import java.util.HashSet;

public class c424 {
    public int characterReplacement(String s, int k) {
        if (s == null || s.length() < 1){
            return 0;
        }

        int left = 0;
        int max = 0;
        int[] map = new int[26];
        char[] chars = s.toCharArray();
        for (int right = 0; right < chars.length; right++){
            map[chars[right] - 'A']++;
            max = Math.max(max, map[chars[right] - 'A']);
            if (right - left + 1 > max + k){
                map[chars[left] - 'A']--;
                left++;
            }
        }
        return chars.length - left;
    }

    public static void main(String[] args) {
        c424 c = new c424();
        String s = "AABABBA";
        int a = c.characterReplacement(s, 1);
        System.out.println(a);
    }
}
