public class d_69 {

    public int mySqrt(int x) {

        int l = 0, r = x;
        int ans = 0;
        int a = 0;

        if( x ==0) return 0;
        if( x == 1) return 1;
        while( l <= r){

            ans = l + (r-l)/2;
            if( ans  <=  x/ans ){
                a = ans;
                l = ans +1;

            } else
                r = ans -1;

        }
//注意ans是中点值，并不代表答案，要分开取值
        return a;

    }
}
