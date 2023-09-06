public class c153 {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;


        int mid = 0;
        while (left < right){
            mid = left + (right - left)/2;
            System.out.println("LEFT:"+left+",RIGHT"+right+",MID"+mid);
            if (nums[mid] < nums[right]){
                right = mid;
            }else {
                left = mid+1;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        int nums[] = {6,7,1,2,3,4,5};
        c153 c = new c153();

        //System.out.println((3-2)/2);
        System.out.println(c.findMin(nums));
    }
}
