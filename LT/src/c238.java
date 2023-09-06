public class c238 {
    public int[] productExceptSelf(int[] nums) {

        int length = nums.length;
        int ans[] = new int[length];
        int R = 1;
        ans[0] = 1;
        for(int i = 1; i < length; i++){

                ans[i] = ans[i-1] * nums[i-1];

        }

        R = 1;
        for(int i = length-2; i >= 0; i--){

                R = R * nums[i+1];
                ans[i] *= R;

        }
        return ans;
    }

    public static void main(String[] args) {
        int nums[] = {-1,1,0,-3,3};
        c238 c = new c238();
        int ans[] = c.productExceptSelf(nums);
        for (int i = 0; i < ans.length; i++){
            System.out.println(ans[i]);
        }
    }
}
