import static java.util.Arrays.sort;

class Solution {
    public int findContentChildren(int[] g, int[] s) {

        sort(g);
        sort(s);
        int a = 0;
        int b = 0;

        while (a< g.length && b< s.length){
            if(s[b] >= g[a])
                a+=1;
            b+=1;

        }

        return a;
    };

    public static void main(String[] args){

        int[] g = {1,2};
        int[] s = {1, 2,3};

        Solution ss = new Solution();
        System.out.println(ss.findContentChildren(g,s));
    }
}