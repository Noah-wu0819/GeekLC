public class greedy_665 {

    public boolean checkPossibility(int[] nums) {

        int sign = 0;
        if(nums.length ==1){
            return true;
        }
       int flag = (nums[0] <= nums[1])? 1:0;
        for (int i = 1; i < nums.length-1; i++){
            if( nums[i] > nums[i+1]){
                if(flag==1){
                    if (nums[i+1]>=nums[i-1])
                        nums[i] = nums[i+1];
                    else
                        nums[i+1] = nums[i];
                    flag = 0;
                }
                else
                    return false;
            }
        }

        return true;


    }

    public static void main(String[] args) {
        greedy_665 a = new greedy_665();
        int[]aa ={5,7,1,8};
        System.out.println(a.checkPossibility(aa));
    }
}
