import java.util.Arrays;

public class c31 {
    //字典序思想，两次扫描：找出最右边的左最小和右边的右最大值。
    /*
    * 第一次扫描从右向左，找出最右边的左最小i（i值比i+1值小）,这样i+1-n为下降序列
    * 从下降序列中找出最小的比i值更大的j右值。交换i，j数值，此时i+1-n仍为下降序列，直接反序即可得出最小的比当前数值大的字典序值。
    * 如果第一次扫描到最左端仍没发现i，说明此时为最大值，直接反序整个数组返回最小值。
    * sort可以匹配subset，（数组，左端，右端）左闭右开。
    * */
    public void nextPermutation(int[] nums) {
        int leftMin = 0;
        int rightMax = 0;

        for (int i = nums.length-2; i >= 0; i--){
            if (nums[i] >= nums[i+1]){
                continue;
            }
            leftMin = nums[i];
            for (int j = nums.length-1; j >= 0; j-- ){
                if (nums[j] > leftMin){
                    rightMax = nums[j];
                    nums[i] = rightMax;
                    nums[j] = leftMin;
                    Arrays.sort(nums, i+1, nums.length);//左闭右开
                    return;
                }
            }
        }
        Arrays.sort(nums);
    }

    public static void main(String[] args) {
        c31 c = new c31();
        int[] a ={2,3,1};
        c.nextPermutation(a);
    }
}
