import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class c15 {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

       if(nums == null || nums.length < 3){
           return result;
       }

       Arrays.sort(nums);
       for (int i = 0; i < nums.length - 2; i++){
           if ( i != 0 && nums[i] == nums[i - 1]){
               continue;
           }
           int left = i + 1;
           int right = nums.length - 1;
           while (left < right) {

               List<Integer> tri = new ArrayList<>();
               if ((nums[i] + nums[left] + nums[right]) == 0) {
                    tri.add(nums[i]);
                    tri.add(nums[left]);
                    tri.add(nums[right]);
                    result.add(tri);
                    while (left < right && nums[left] == nums[left+1]) left++;
                    while (left < right && nums[right] == nums[right-1]) right--;
                    left++;
                    right--;
               }else if ((nums[i] + nums[left] + nums[right]) > 0){
                   right--;
               }else {
                   left++;
               }
           }
       }
       return result;
    }

    public static void main(String[] args) {
        c15 c = new c15();
        int[] a = {-1,0,1,2,-1,-4};
        System.out.println(c.threeSum(a));
    }
}
