import java.util.HashMap;


//重点是哈希表降低时间复杂度，数组所有数据遍历到哈希表中要注意：：因为是求两数之和，所以一次遍历即刻（1+3=3+1）
public class c01 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer , Integer > map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if (map.containsKey(target - nums[i])){
                return new int[]{ i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
