public class p_167 {
    public int[] twoSum(int[] numbers, int target) {

        int[] ans = new int[2];
        int end = numbers.length - 1;
        int start = 0;
        int a = numbers[start], b = numbers[end];
        while ( a <= b){
            a = numbers[start];
            b = numbers[end];
            if( a + b == target){
                ans[0] = start + 1;
                ans[1] = end + 1;
                return ans;
            }else if ( a +b > target){
                end--;
            }else {
                start++;
            }
        }

        return  ans;
    }

    public static void main(String[] args) {
        p_167 p = new p_167();
        int[] ss = {1,2,3,4};
        p.twoSum(ss,6);
    }
}
