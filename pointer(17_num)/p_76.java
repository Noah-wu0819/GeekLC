import java.util.HashMap;

public class p_76 {
    public String minWindow(String s, String t) {

        String ans = "";
        int len = Integer.MAX_VALUE;

        HashMap<Character, Integer> work = new HashMap< Character, Integer>();
        HashMap<Character, Integer> exp  = new HashMap< Character, Integer>();

        for ( int i = 0; i < t.length(); i++){
            //through the t, and calculate the nums of each char of t
            //getOrDefault(Object key, V defaultValue)
            //意思就是当Map集合中有这个key时，就使用这个key对应的value值，如果没有就使用默认值defaultValue
            exp.put(t.charAt(i), exp.getOrDefault( t.charAt(i),0)+1);
        }

        int right = 0, left = 0;
        int dis = 0;


        for ( int r = 0, l = 0; r < s.length(); r++){

            //这里滑动窗口右半边也要对应string s，不是对应t，这样才能判断s是否带有t的字母。
             //必须判断是否存在，要不然比较就出现越界
             work.put(s.charAt(r), work.getOrDefault( s.charAt(r), 0) + 1);
             if (exp.containsKey(s.charAt(r))&& work.get(s.charAt(r)) <= exp.get( s.charAt(r))){
                 dis++;
             }

             // || 只要满足第一个条件，后面的条件就不再判断,比较的那一步如果exp那边没有就会出错
             while( l<r && ( !exp.containsKey(s.charAt(l))||work.get(s.charAt(l)) > exp.get( s.charAt(l)) )){
                 work.put(s.charAt(l), work.getOrDefault( s.charAt(l),0) - 1);
                 l++;
             }
            //这里dis只是表示满足包含t字符串内字符，还需要判断s中这段滑动窗口长度，所以需要r-l+1
             if( dis == t.length() && r-l+1 < len){
                 len = r-l+1;
                 ans = s.substring(l, r+1);
             }

        }

        return ans;
    }
}
