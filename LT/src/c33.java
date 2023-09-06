public class c33 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right){
            mid = left + (right - left)/2;

            if (nums[mid] == target) return mid;
             if (nums[mid] >= nums[left]){
                if (target >= nums[left] && target < nums[mid]){
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
             }else {
                if (target > nums[mid] && target <= nums[right]){
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
             }
        }
        return -1;
    }

    public static void main(String[] args) {
        int n[] = {4,5,6,7,0,1,2};
        c33 c = new c33();
        System.out.println(c.search(n,0));


    }
}
