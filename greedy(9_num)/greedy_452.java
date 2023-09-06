import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class greedy_452 {

    public int findMinArrowShots(int[][] points) {

        int ans = 1;
        int end = 0;
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1]<o2[1])
                    return -1;
                else if (o1[1]==o2[1])
                    return 0;
                else
                    return 1;
            }
        });

        for(int i = 0; i < points.length; i++){
            System.out.println(i+"+"+points[i][0]+"  "+points[i][1]);
        }
        end = points[0][1];
        for (int i = 1; i < points.length; i++){

            if (points[i][0] > end){

                ans++;
                end = points[i][1];
            }
        }
        return ans;
    }

    public static void main(String argv[]){

        greedy_452 a = new greedy_452();
        int[][] aa = {{-2147483646,-2147483645},{2147483646,2147483647}};
       a.findMinArrowShots(aa);

    }
}
