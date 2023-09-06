public class d_81_shabicompiler {

    class Solution {
        public boolean search(int[] nums, int target) {
            int n = nums.length;
            if (n == 0) {
                return false;
            }
            if (n == 1) {
                return nums[0] == target ? true : false;
            }
            int l = 0, r = n - 1;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (nums[mid] == target) {
                    return true;
                }
                if (nums[0] <= nums[mid]) {
                    if (nums[0] <= target && target < nums[mid]) {
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                } else {
                    if (nums[mid] < target && target <= nums[n - 1]) {
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
            }
            return false;
        }}

    public static void main(String[] args) {
        d_81_shabicompiler d = new d_81_shabicompiler();
        int[] t = {2,3,5,1,1,1};
    }
}



