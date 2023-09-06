import java.util.Arrays;

public class c253 {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length < 1){
            return 0;
        }
        int[] a = new int[intervals.length];
        int[] b = new int[intervals.length];
        for (int i = 0 ;i<intervals.length; i++){
            a[i] = intervals[i][0];
            b[i] = intervals[i][1];
        }
        Arrays.sort(a);
        Arrays.sort(b);
        int ax = 0, bx = 0;
        int ans = 0;
        while (ax < intervals.length && bx < intervals.length){
            if (a[ax] >= b[bx]){
                bx++;
            }
            ans = Math.max(ax - bx + 1, ans);
            ax++;
        }
        return ans;
    }
}
