public class c190 {
    public int reverseBits(int n) {
        int ans = 0;

        for (int i = 0; i < 32 && n != 0; i++){
            ans = ans | ( n & 1 ) << (31 - i);
            n >>>= 1;
        }
        return ans;
    }
}
