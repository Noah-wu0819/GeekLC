public class c124 {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dp(root);
        return max;
    }

    public int dp(TreeNode root){
        if (root == null) return 0;
        int l = dp(root.left);
        int r = dp(root.right);

        int t = l + r + root.val;
        if ( max < t) max = t;

        return Math.max(root.val + Math.max(l, r), 0);
    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
