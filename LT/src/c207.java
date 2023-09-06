import java.util.*;

public class c207 {


    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Queue<Integer> queue = new ArrayDeque<>();
        List<List<Integer>> lists = new ArrayList<>();
        int[] indegrees = new int[numCourses];

        for (int i = 0; i < numCourses; i++){
            lists.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++){
            lists.get(prerequisites[i][1]).add(prerequisites[i][0]);//1为先修课程，0为后修课程，这样方便后续深入
            indegrees[prerequisites[i][0]]++;//这代表后续课程节点入度加1,0为后修课程，注意
        }
        int ans = 0;
        for (int i = 0; i < numCourses; i++){
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()){
            ans++;
            int first = queue.poll();
            for(Integer second: lists.get(first)){
                indegrees[second]--;
                if (indegrees[second] == 0) {
                    queue.offer(second);

                }
            }
        }


        return ans == numCourses;
    }

    public static void main(String[] args) {
        c207 c = new c207();
    }
}
