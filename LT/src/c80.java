import java.util.*;
/*
* 重点是删除，增加删除和查询实现O(1)复杂度必须采用动态数组+哈希表的方法
* 增和随机取值比较简单，重点是删除
* list和hashmap都需要注意，将要删除值和最后一位交换，设置好index再删除，先交换再删除
* 命名一定要直接易懂，要不然绕晕了，最后解不出来答案
* */
class RandomizedSet {

    private HashMap<Integer,Integer> set ;
    private List<Integer> list;
    private int length;
    public RandomizedSet() {
        set = new HashMap<>();
        length = 0;
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (!set.containsKey(val)){
            list.add(val);
            set.put(val,length++);
            return true;
        }else{
            return false;
        }
    }


    public boolean remove(int val) {
        if (set.containsKey(val)){
            //set.get()表示对应index，list.get()表示对应值
            int v_end = list.get(length-1);
            int index_val = set.get(val);
            int index_end = length - 1;
            list.set(index_val, v_end);
            list.set(index_end, val);

            set.put(val, index_end);
            set.put(v_end, index_val);

            list.remove(--length);
            set.remove(val);
            //length--;
            return true;
        }else{

            return false;
        }
    }

    public int getRandom() {
        Random r = new Random();
        int loc = r.nextInt(length);
        return list.get(loc);
    }
}

public class c80 {

    public static void main(String[] args) {
        RandomizedSet r = new RandomizedSet();
        System.out.println(r.insert(0));
        System.out.println(r.insert(1));
        System.out.println(r.remove(0));
        System.out.println(r.insert(2));
        System.out.println(r.remove(1));
        System.out.println(r.getRandom());

    }
}
