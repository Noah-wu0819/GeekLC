import java.util.ArrayList;
import java.util.List;


public class greedy_763 {
    public List<Integer> partitionLabels(String s) {

        int[] chr = new int[26];
        for (int i = 0; i < s.length(); i++){
            chr[s.charAt(i) - 'a'] = i;
            //精华！！！！！！！！！！！！charAt(i)-'a'得到每个字母索引，=i直接给出end值
        }

        int start = 0;
        int end = 0;
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i <s.length(); i++){

            end = Math.max(end, chr[s.charAt(i) - 'a']);
            if(chr[s.charAt(i) - 'a'] == end){
                start = end+1;
                ans.add(end - start +1);
            }
        }
        return ans;
    }

}
