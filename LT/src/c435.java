import java.util.Arrays;

public class c435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        int ans = 1;
        Arrays.sort(intervals, (o1, o2)->o1[1] - o2[1]);
        int right = intervals[0][1];

        for (int i = 1; i < intervals.length; i++){
            if (intervals[i][0] >= right){
                ans++;
                right = intervals[i][1];
            }
        }
        return intervals.length - ans;
    }
}
