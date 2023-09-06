public class greedy_605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        int ans = 0;

        if(flowerbed.length == 1 && flowerbed[0]==0){
            if(n<=1)
                return true;
            else
                return false;
        }else if(flowerbed.length == 1 && flowerbed[0]==1){
            if(n>0)
                return false;
            else
                return true;
        }

        if(flowerbed[0]==0 && flowerbed[1] == 0){
            flowerbed[0] = 1;
            ans++;
        }
        if(flowerbed[flowerbed.length-1]==0 && flowerbed[flowerbed.length-2] == 0){
            flowerbed[flowerbed.length-1] = 1;
            ans++;
        }

        for ( int i = 1; i < flowerbed.length-1; i++){
            if( flowerbed[i] == 0 && flowerbed[i+1] == 0){
                if (flowerbed[i-1]==0) {
                    flowerbed[i] = 1;
                    ans++;
                }
            }
        }

        if (ans >= n)
            return true;
        else
            return false;

    }
}
