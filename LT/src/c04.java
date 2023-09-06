public class c04 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int ans[] = new int[nums1.length+nums2.length];
        for (int i = 0 ; i < nums1.length; i++)
            ans[i] = nums1[i];
        int n = nums1.length;
        System.out.println("++++"+n);
        for (int i = 0; n < nums1.length + nums2.length; n++,i++)
            ans[n] = nums2[i];

        for (int i = 0 ; i < ans.length; i++)
            System.out.println(ans[i]);
        process(ans);
        if (ans.length%2 == 1){
            return ans[ans.length/2];
        }else {
            double a = ans[ans.length/2];
            double b = ans[ans.length/2-1];

            return (a+b)/2;
        }

    }
    public void process(int[] a){
        if (a == null || a.length < 2){
            return;
        }
        slice(a,0, a.length-1);
    }
    public void slice(int[] a, int l, int r){
        if (l==r) return;
        int mid = l+((r-l)>>1);
        slice(a,l,mid);
        slice(a,mid+1,r);
        merge(a,l,r);
    }
    public void merge(int []a, int l, int r){
        int mid = l + ((r-l)>>1);
        int temp[] = new int[r-l+1];
        int l1 = l;
        int ori = 0;
        int l2 = mid+1;
        while(l1<=mid && l2 <= r){
            temp[ori++] = a[l1] < a[l2]? a[l1++]: a[l2++];
        }

        while (l1<=mid){
            temp[ori++] = a[l1++];
        }

        while (l2 <= r){
            temp[ori++] = a[l2++];
        }

        for (int i = 0; i < temp.length; i++ ){
            a[l+i] = temp[i];
        }
    }

    public static void main(String[] args) {
        c04 c = new c04();


        int aa[] = {1,2};
        int ab[] = {3,4};
        System.out.println(c.findMedianSortedArrays(aa,ab));
    }
}
