public class c152 {
    public int maxProduct(int[] nums) {

        int max = nums[0];
        int min = nums[0];
        int ansMax = nums[0];
        for (int i = 1; i < nums.length; i++){
           int tempMax = max;
           max = Math.max(nums[i], Math.max(nums[i] * max, nums[i] * min));
           min = Math.min(nums[i], Math.min(nums[i] * tempMax, nums[i] * min));
           ansMax = Math.max(ansMax, max);
        }
        return ansMax;
    }

    public static void main(String[] args) {
        int nums[] ={2,3,-2,4};
        c152 c = new c152();
        int max = c.maxProduct(nums);
        System.out.println(max);
    }
}
