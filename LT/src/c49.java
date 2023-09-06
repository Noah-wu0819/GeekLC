import java.util.*;

public class c49 {

    /*
    * 注意char[]和string转换用法，tochararray 必须新建char[]数组才能排序成功，string新建对象的时候去转换，
    * 注意map的循环方式foreach匿名内部类((key,value)->{})
    * */
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String str: strs){
            char[] characters = str.toCharArray();
            Arrays.sort(characters);
            String key = new String(characters);
            List<String> value = map.getOrDefault(key, new ArrayList<>());
            value.add(str);
            map.put(key, value);
        }

        List<List<String>> ans = new ArrayList<>();

        map.forEach((key, value)->{
            ans.add(value);
        });

        return ans;
    }

    public static void main(String[] args) {
        c49 c = new c49();
        String[] s = {"eat","tea","tan","ate","nat","bat"};
        ;
        System.out.println(c.groupAnagrams(s));
    }
}
