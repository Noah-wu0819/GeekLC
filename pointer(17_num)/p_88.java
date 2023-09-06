import java.sql.Array;
import java.util.Arrays;

public class p_88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

//        int[] tran = new int[m];
//
//        int a=0, b=0;
//        int num = 0;
//
//        System.arraycopy(nums1, 0, tran, 0, m);
//
//        while ((a<m) && (b<n)){
//            nums1[num++] = ( tran[a] < nums2[b])? tran[a++]: nums2[b++];
//        }
//
//        if(a<m) System.arraycopy( tran, a, nums1, a+b, m+n-a-b );
//        if(b<n) System.arraycopy( nums2, b, nums1, a+b, m+n-a-b);
//
        int a = m-1, b = n-1, num = m+n-1;

        while ((a>=0) && (b >=0))
            nums1[num--] = ( nums1[a] < nums2[b])? nums2[b--]: nums1[a--];
        System.arraycopy(nums2, 0, nums1,0, b+1);
    }
}
