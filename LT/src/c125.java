public class c125 {
    public boolean isPalindrome(String s) {
        if (s.equals(" ")) return true;
        StringBuilder ans = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++){
            if (Character.isLetterOrDigit(chars[i])){
                ans.append(Character.toLowerCase(chars[i]));
            }
        }

        int left = 0;
        int right = ans.length() - 1;
        if (ans.isEmpty()) return true;
        while (left < right){
            if (ans.charAt(left) != ans.charAt(right)) return false;
            left++;
            right--;
        }

        return true;
    } 

    public static void main(String[] args) {
        c125 c = new c125();
        c.isPalindrome("aa");
    }
}
