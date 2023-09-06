import java.util.Arrays;
import java.util.Comparator;

public class greedy_435 {
    public int eraseOverlapIntervals(int[][] intervals) {

        int[] temp = {0, 0};
        int[] temp1 = {0, 0};

        int delete = 0;
        int end = 0;
//        //冒泡排序
//        for(int i = 0; i< intervals.length-1; i++){
//            for (int j = 0; j < intervals.length-1; j ++){
//                if (intervals[j][0] > intervals[j+1][0]){
//                    temp = intervals[j];
//                    intervals[j] =intervals[j+1];
//                    intervals[j+1] = temp;
//                }
//            }
//        }


        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                if (o1[1] == o2[1])
                    return o1[0] - o2[0];
                else
                    return o1[1] - o2[1];
            }

        });
        for(int i = 0; i < intervals.length; i++){
            System.out.println(intervals[i][0]+"  "+intervals[i][1]);
        }

        end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end){
                delete++;
            System.out.println("删除:"+ intervals[i][0]+","+ intervals[i][1]);}
            else
                end = intervals[i][1];
        }

        System.out.printf("%5d",delete);
        return delete;
    }
    public static void main(String[] argv) {

        int[][] a = {{-52,31},{-73,-26},{82,97},{-65,-11},{-62,-49},{95,99},{58,95},{-31,49},{66,98},{-63,2},{30,47},{-40,-26}};
        greedy_435 g = new greedy_435();
        g.eraseOverlapIntervals(a);

    }


}
