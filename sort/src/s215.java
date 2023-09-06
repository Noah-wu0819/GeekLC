public class s215 {

    public static void main(String[] args) {
        int[] a = {-1,-1};
        int k = 2;
        start(a, 2, 0, 1);
        System.out.println(a[0]);
//        int heapsize = a.length;
//        heapsort(a);
//        swap(a, 0, --heapsize);
//        for (int i = 1; i <= k-1; i++){
//            heapift(a, 0, heapsize);
//            swap(a, 0, --heapsize);
//        }
//        System.out.println(a[heapsize]);
        //int ss = heapify1(a, 0, 6, 2);
       // System.out.println(t);
        //System.out.println(ss);
    }
    public static void heapsort(int[] a){
        int heapsize = a.length;
        for (int i = heapsize-1; i >= 0; i--){
            heapift(a, i, heapsize);

        }
    }
    public static void swap(int[] a, int i, int j){
        int temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }
    public static void heapift(int[] a, int index, int heapsize){
        int left = 2*index + 1;
        while (left < heapsize){
            int max = left+1 < heapsize && a[left+1] > a[left]? left+1: left;
            max = a[index] > a[max] ? index: max;
            if ( max == index)
                break;
            swap(a, index, max);

            index = max;
            left = 2*index+1;
        }
    }
    public static int heapify1(int[] a, int index, int heapsize, int k){
        for (int i = 1; i<= k; i++){
            int left = index * 2 + 1;
            int max = left+1 < heapsize && a[left+1] > a[left]? left+1: left;
            max = a[index] > a[max]? index: max;
            swap(a, index, max);
            heapsize--;
            index = max;
        }
        return a[heapsize-1];
    }

    public static int start(int[] a, int k,int l, int r){
        if ( a==null ){
            return -1;
        }
        if(a.length < 2){
            return 0;
        }
        return quickSort( a, k,l, r);
    }
    /*
    * 切记找到分界点，要找p[0]而不是p[1]，否则就会漏掉相等的数，确定k不准确·。
    * */
    public static int quickSort(int[] a, int k,int l, int r){

        int left = l;
        int right = r;
        int sign = a.length - k;


        int key = left + (int) (Math.random() * (right - left + 1));
        swap(a, right,key);
        int[] p = new int[2];
        p = partition(a, left, right);
        if (p[0] < sign) {
            return quickSort(a, k, p[0] + 1, right);
        } else if (p[0] > sign) {
            return quickSort(a, k, left, p[0] - 1);
        }else {
            return p[0];
        }

    }


    public static int[] partition(int[] a, int l, int r){
        int[] ans = new int[2];
        int p1 = l-1;
        int pt = l;
        int p2 = r;

        while ( pt < p2){
            if(a[pt] < a[r]){

                swap(a, ++p1, pt++);
            } else if (a[pt] == a[r]) {
                pt++;
            } else {
                swap(a, --p2, pt);
            }
        }
        swap(a, pt, r);
        ans[0] = p1+1;
        ans[1] = p2;
        return ans;
    }
}

