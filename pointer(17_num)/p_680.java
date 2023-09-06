public class p_680 {

    int flag = 0;//flag放在里面，迭代的时候自动清零

    //标志要注意是否清零
    public boolean validPalindrome(String s) {

        int right = s.length() - 1;
        int left  = 0;

        char l = s.charAt(left) ,r = s.charAt(right);
        while ( right - left > 0) {

            if (l == r) {
                left++;
                right--;
                l = s.charAt(left);
                r = s.charAt(right);
            } else {
                if (flag == 0) {

                    flag++;
                    return validPalindrome(s.substring(left, right)) || validPalindrome(s.substring(left + 1, right + 1));
                } else
                    return false;
            }
        }



        return true;
    }

    public static void main(String[] args) {
        p_680 p = new p_680();
        String s = "abc";
        p.validPalindrome(s);
    }
}
