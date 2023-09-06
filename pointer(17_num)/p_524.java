import java.util.List;

public class p_524 {

    public String findLongestWord(String s, List<String> dictionary) {


        String ans = "";

        for( String t : dictionary){

            int sn = 0;
            int tn = 0;//必须放在循环里，这是遍历的index，每次都需要清零

            while (tn < t.length() && sn < s.length()) {

                if (t.charAt(tn) == s.charAt(sn)) {
                    tn++;
                }
                sn++;
            }

            if ( tn == t.length() ){
                //注意第二种情况，ans和t长度相同确认之后才去比较两者在ascii中的排序
                if ( t.length() > ans.length() ||( t.length() == ans.length() && t.compareTo(ans) < 0)){
                    ans = t;
                }
            }
        }

        return  ans;
    }
}
