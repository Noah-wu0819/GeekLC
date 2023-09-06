public class c338 {
    public int[] countBits(int n) {
        int ans[];
        if (n < 1){
            return null;
        }
        ans = new int[n+1];

        for (int i = 0; i < n+1; i++){
         int num = 0;
         int key = i;
         while (key  != 0){
             key &= (key-1);
             num++;
         }
         ans[i] = num;
        }
        return ans;
    }

    public static void main(String[] args) {
        c338 c = new c338();
        System.out.println(c.countBits(4));
    }
}
