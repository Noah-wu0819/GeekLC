import java.util.*;

public class c261 {
    public class unionFind{
        private HashMap<Integer, Integer> fatherSet;
        private HashMap<Integer, Integer> sizeOfSet;

        public unionFind(){
            fatherSet = new HashMap<>();
            sizeOfSet = new HashMap<>();
        }
        public void add(int x){
            if (fatherSet.containsKey(x)) return;
            fatherSet.put(x, null);//必须写成null，要不然出不来循环
            sizeOfSet.put(x, 1);
        }
        public int find(int x){
            int root = x;
            while (fatherSet.get(root) != null){//出错，root写错成x
                root = fatherSet.get(root);
            }
            while (x != root){
                int originalRoot = fatherSet.get(x);
                fatherSet.put(x, root);
                x = originalRoot;
            }
            return root;
        }
        public void union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) return;
            fatherSet.put(rootX, rootY);
            sizeOfSet.put(rootY, sizeOfSet.get(rootX)+sizeOfSet.get(rootY));
        }
        public int getMaxSize(){
            int max = Integer.MIN_VALUE;
            for (Integer i: sizeOfSet.keySet()){
                if (max < sizeOfSet.get(i)){
                    max = sizeOfSet.get(i);
                }
            }
            return max;
        }

    }
    public boolean validTree(int n, int[][] edges) {
        unionFind uf = new unionFind();
        if (n != edges.length+1) return false;
        for (int i = 0; i < n; i++){
            uf.add(i);
        }
        for (int i = 0; i < edges.length; i++){
            uf.union(edges[i][0], edges[i][1]);
        }

        return uf.getMaxSize() == n;
    }

    public static void main(String[] args) {
        int[][] ed = {{0,1},{0,2},{0,3},{1,4}};
        c261 a = new c261();
        System.out.println(a.validTree(5, ed));
    }
}
