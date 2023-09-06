import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class greedy_406 {

    public int[][] reconstructQueue(int[][] people) {


        int lon = 0;
        lon = people.length;
        LinkedList<int[]> tran = new LinkedList<>();

        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if(a[0] == b[0]){
                    return a[1] - b[1];
                }else {
                    return b[0] - a[0];
                }
            }
        });

        for (int[] p: people){
            tran.add(p[1], p);
        }
        return tran.toArray(new int[lon][]);
    }



    public static void main(String[] args) {

        int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        greedy_406 g = new greedy_406();
        int[][] newp = g.reconstructQueue(people);

        for (int[] a: newp){
            System.out.println("输出："+a[0]+","+a[1]);
        }
    }
}
