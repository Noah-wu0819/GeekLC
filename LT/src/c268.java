public class c268 {
    public int missingNumber(int[] nums) {
        int sum = nums.length;

        for (int j = 0; j < nums.length; j++){
            sum ^=j ^nums[j];
        }

        return sum;
    }
}
