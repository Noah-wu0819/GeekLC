import java.util.*;


public class s_451 {

    public String frequencySort(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();

        for ( int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            int fre = hm.getOrDefault(c, 0) + 1;
            hm.put(c, fre);
        }

        List<Character> list = new ArrayList<Character>( hm.keySet());
        Collections.sort( list, (a, b) -> hm.get(b) - hm.get(a));

        StringBuffer sb = new StringBuffer();
        int size = list.size();
        for (int i = 0; i <size; i++){
            char c = list.get(i);
            int fre = hm.get(c);
            for ( int j = 0; j < fre; j++){
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
