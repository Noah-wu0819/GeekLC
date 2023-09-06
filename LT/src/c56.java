import javax.swing.event.TableColumnModelEvent;
import java.util.Arrays;
import java.util.Comparator;

public class c56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (v1,v2)-> v1[0]-v2[0]);
        int[][] ans = new int[intervals.length+1][2];
        int idx = -1;

        for (int[] itvl: intervals){
            if (idx == -1 || ans[idx][1] < itvl[0]){
                ans[++idx] = itvl;//不重叠
            }else {
                //重叠
                ans[idx][1] = Math.max(ans[idx][1], itvl[1]);
            }
        }


        return Arrays.copyOf(ans, idx+1);//idx+1才是数组长度，因为是左边++
    }
}
