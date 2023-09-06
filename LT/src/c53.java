public class c53 {

//    public int[] find(int[] nums, int i, int[] dp){
//        dp[0] = nums[0];
//        if (i == nums.length)
//            return dp;
//        dp[i] = dp[i-1] <= 0? nums[i]: dp[i-1] + nums[i];
//        System.out.println("第"+i+"位置结尾的大和："+dp[i]);
//        return find(nums, ++i, dp);
//    }

    public int maxSubArray(int[] nums) {

        int length = nums.length;
        int ans[] = new int[length];
        int max = nums[0];
        ans[0] = nums[0];
        for (int i = 1; i < length; i++){
            if (ans[i-1] > 0){
                ans[i] = nums[i] + ans[i-1];
            }else {
                ans[i] = nums[i];
            }
            if (max < ans[i])
                max = ans[i];
        }
        return max;

//        if( nums.length < 2){
//            return nums[0];
//        }
//        int[] ans = new int[nums.length];
//        int[] dp = new int[nums.length];
//        ans = find(nums, 1, dp);
//        int max = Integer.MIN_VALUE;
//        for (int i = 0; i < ans.length; i++){
//            max = dp[i] > max? dp[i] : max;
//            System.out.println("dp[]"+i+":::"+dp[i]);
//            System.out.println(max);
//        }
//        return max;
    }

    public static void main(String[] args) {
        int t[] = {-2,-1};
        c53 c = new c53();
        ;
        System.out.println(c.maxSubArray(t));
    }
}
