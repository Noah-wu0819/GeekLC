import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class c57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int index = 0;
        int res[][] = new int[intervals.length + 1][2];
        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            res[index++] = intervals[i++];
        }

        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        res[index++] = newInterval;
        while (i < intervals.length && intervals[i][0] > newInterval[1]) {
            res[index++] = intervals[i++];
        }

        return Arrays.copyOf(res, index);//这里index++在后面，所以不用像56一样+1
    }
}
