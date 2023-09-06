public class c912 {
    public void quick_sort(int[] a,int l, int r){
        if (l ==r )return;

        swap(a, r, l+ (int)Math.random()*(l-r+1));
        int sign[] = core(a, l, r);
        quick_sort(a,l, sign[0]-1);
        quick_sort(a, sign[1]+1, r);
        //用数组保证中间重复的不再排序,所以使用含有两个元素的数组
    }

    public void easy(int[] a, int l, int r){
        int right = r;
        int left = l;
        int mid = left + (right - left)/2;
        int pivot = a[mid];
        while (left <= right){
            while (a[left] < pivot)
                left++;
            while (a[right] > pivot)
                right--;
            if (left <= right){
                swap(a, left, right);
                left++;
                right--;
            }
        }
    }
    public int[] core(int[] a, int l, int r){
        int left = l-1;
        int sign = l;
        int right = r;

        //swap(a, sign, right);
        while (sign < right){
            if (a[sign] < a[r]){
                swap(a, ++left, sign++);
            }else if (a[sign] == a[r]){
                sign++;
            }else {
                swap(a, --right,sign);
            }

        }
        swap(a, sign, r);
        int[] ans = new int[2];
        ans[0] = left+1;
        ans[1] = sign;
        return ans;
    }
    public void swap(int[] a, int l, int r){
        int temp = a[l];
        a[l] = a[r];
        a[r] = temp;
    }

    public int[] sortArray(int[] nums){
        if (nums ==null || nums.length <2){
            return null;
        }
        merge_sort(nums, 0, nums.length-1);
        return nums;
    }

    public void merge_sort(int[] a, int l, int r){
        if (l == r) return;
        int mid = l+(r-l)/2;
        merge_sort(a, l, mid);
        merge_sort(a, mid+1, r);
        process(a,l,mid,r);
    }

    public void process(int[] a, int l, int m, int r){
        int[] ans = new int[r - l + 1];
        int pointer1 = l;
        int i = 0;
        int pointer2 = m+1;
        while (pointer1<=m&&pointer2<=r){

            ans[i++] = a[pointer1]<=a[pointer2]? a[pointer1++]: a[pointer2++];
            
        }
        while (pointer1<=m){
            ans[i++] = a[pointer1++];
        }
        while (pointer2<=r){
            ans[i++] = a[pointer2++];
        }
        for (int j = 0; j < ans.length; j++){
            a[l++] = ans[j];
        }
    }
    public static void main(String[] args) {
        int[] p = {2,3,1,1,4,4,56,1};
        c912 c = new c912();
        p = c.sortArray(p);

        for (int i = 0; i < p.length; i++){
            System.out.println(p[i]);
        }
    }
}
