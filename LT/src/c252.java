import java.util.Arrays;

public class c252 {
    public boolean canAttendMeetings(int[][] intervals) {

        if(intervals.length < 1 || intervals == null) return true;
        Arrays.sort(intervals, (o1, o2)->o1[1]-o2[1]);
        int right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++){
            if (intervals[i][0] < right){
                return false;
            }else {
                right = intervals[i][1];
            }
        }
        return true;
    }


}
