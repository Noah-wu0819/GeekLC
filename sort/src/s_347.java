import java.util.*;

public class s_347 {
    public int[] topKFrequent(int[] nums, int k) {

        List<Integer> res = new ArrayList<>();

        HashMap<Integer, Integer> map = new HashMap<>();

        for ( int num: nums){
            if ( map.containsKey(num)){
                map.put(num, map.get(num) + 1);
            }else {
                map.put(num, 1);
            }
        }

        List<Integer>[] list = new List[nums.length + 1];
        for ( int key: map.keySet()){
            int i = map.get(key);
            if (list[i] == null){
                list[i] = new ArrayList();
            }
            list[i].add(key);
        }

        for(int i = list.length - 1; i >= 0 && res.size() < k; i--){
            if( list[i] == null) continue;
            res.addAll(list[i]);
        }
         int[] ans = res.stream().mapToInt(Integer::intValue).toArray();
        return ans;
    }
}
