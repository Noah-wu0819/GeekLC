
//Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
//
//        If target is not found in the array, return [-1, -1].
//
//        You must write an algorithm with O(log n) runtime complexity.
//
//
//
//        Example 1:
//
//        Input: nums = [5,7,7,8,8,10], target = 8
//        Output: [3,4]
//        Example 2:
//
//        Input: nums = [5,7,7,8,8,10], target = 6
//        Output: [-1,-1]
//        Example 3:
//
//        Input: nums = [], target = 0
//        Output: [-1,-1]

public class d_34_not_finished {

    public int search_lr(int[] nums, int target, boolean s){

        int left = 0, right = nums.length-1, ans = nums.length;

        while (left <= right){
            int mid = (left + right) / 2;

            if ( nums[mid] > target || (s == true && nums[mid] >= target)) {
                //把{1}1的情况考虑进去
                right = mid - 1;
                ans = mid;
            }
            else{
                left = mid + 1;

            }

        }
        return ans;
    }



    public int[] searchRange(int[] nums, int target) {

        int l = search_lr(nums, target, true);
        int r = search_lr(nums, target, false) - 1;

        if ( l<=r && r< nums.length && nums[l] == target && nums[r] == target)
            return new int[]{l, r};
        else
            return new int[]{-1,-1};
    }
}
