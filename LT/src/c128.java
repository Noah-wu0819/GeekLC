import java.util.HashMap;

public class c128 {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length < 1){
            return 0;
        }
        UnionFind uf = new UnionFind();

        for (int i = 0; i < nums.length; i++){
            uf.add(i);
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            if (map.containsKey(nums[i])) continue;
            if (map.containsKey(nums[i] - 1)){
                uf.union(map.get(nums[i]-1), i);
            }
            if (map.containsKey(nums[i] + 1)){
                uf.union(i, map.get(nums[i] + 1));
            }
            map.put(nums[i], i);
        }
        return uf.getMaxSize();
    }

    public class UnionFind{
        private HashMap<Integer, Integer> fatherSet;
        private HashMap<Integer, Integer> sizeOfSet;

        public UnionFind(){
            fatherSet = new HashMap<>();
            sizeOfSet = new HashMap<>();
        }

        public void add(int x){

            //注意判定条件
            if (fatherSet.containsKey(x)) return;
            fatherSet.put(x, null);
            sizeOfSet.put(x, 1);
        }

        public int find(int x){
            int root = x;
            while (fatherSet.get(root) != null){
                root = fatherSet.get(root);
            }

            while (x != root){
                int oldF = fatherSet.get(x);
                fatherSet.put(x, root);
                x = oldF;
            }

            return root;
        }

        public void union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);

            //加入判定条件，确保两个root不一致
            if (rootX != rootY){
                fatherSet.put(rootX, rootY);
                sizeOfSet.put(rootY, sizeOfSet.get(rootX) + sizeOfSet.get(rootY));
            }
        }

        public int getMaxSize(){
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < sizeOfSet.size(); i++){
                if ( max < sizeOfSet.get(i)){
                    max = sizeOfSet.get(i);
                }
            }
            return max;
        }
    }

    public static void main(String[] args) {
        int nu[] = {100,4,200,1,3,2};

        c128 c = new c128();
        System.out.println(c.longestConsecutive(nu));
    }
}
