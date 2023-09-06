public class s_215 {

    //自己重新做，给出答案很垃圾
    //快排
    void quick_sort(int[] nums, int l, int r){
        int ans = 0;
        int len = nums.length;
        int privot = 0, left = 0, right = len - 1;

        while (left < right){
            privot = nums[left];
            while (left < right && nums[right] >= privot){
                right--;
            }
            if (left < right)
                nums[left] = nums[right];
            while (left < right && nums[left] <= privot){
                left++;
            }
            if (left < right)
                nums[right] = nums[left];
        }
        nums[left] = privot;

        quick_sort(nums, l, left);
        quick_sort(nums, left+1, r);
    }
    //快速选择

    Random random = new Random();
    public int findKthLargest(int[] nums, int k) {
        return  quickSelect(nums, 0, nums.length-1, nums.length -k);
    }

    public int quickSelect( int[] a, int left, int right, int index){
        int q = randomPartition( a, left, right);
        if (q == index){
            return a[q];
        }else {
            return q < index? quickSelect(a, q+1, right, index): quickSelect(a, left, q - 1, index);
        }
    }

    public  int randomPartition( int[] a, int left, int right){
        int i = random.nextInt(right - left + 1) + 1;
        swap(a, i, right);
        return  partition( a, left, right);
    }

    public int partition(int[] a, int l, int r) {
        int x = a[r], i = l - 1;
        for (int j = l; j < r; ++j) {
            if (a[j] <= x) {
                swap(a, ++i, j);
            }
        }
        swap(a, i + 1, r);
        return i + 1;
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
