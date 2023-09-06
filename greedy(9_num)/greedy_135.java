import java.util.ArrayList;

public class greedy_135 {
    public int candy(int[] ratings){

        int n = ratings.length;
        int[] cookie = new int[20000];
        int sum = 0;

        for (int i = 0; i < n; i++){
            cookie[i] = 1;
           if (i==0){
               continue;
           } else {

               if (ratings[i] > ratings[i-1])
                   cookie[i] = cookie[i-1] + 1;
           }
        }

        for (int i = n-1; i >= 0; i--){
            if(i == n-1){
                continue;
            } else {
                if (ratings[i] > ratings[i+1] && cookie[i] < cookie[i+1] + 1)
                    cookie[i] = cookie[i+1] + 1;
            }
        }

        for (int i = 0; i < n; i ++){

            sum += cookie[i];
        }
        return sum;
    }

    public static void main(String[] args) {

        for(int x = 10; x >= 0; --x) {
            System.out.print("value of x : " + x );
            System.out.print("\n");
        }
    }
}
