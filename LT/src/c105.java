import java.util.HashMap;

public class c105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder == null) return null;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildTreeHelper(preorder, inorder, map, 0, preorder.length, 0, inorder.length);
    }

    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, HashMap<Integer, Integer> map, int pl, int pr, int il, int ir) {
        if (pl == pr) return null;

        int key = map.get(preorder[pl]);
        TreeNode root = new TreeNode(inorder[key]);

        int  leftnum = key - il;
        root.left = buildTreeHelper(preorder, inorder, map, pl + 1, pl + 1 + leftnum, il,  key);
        root.right = buildTreeHelper(preorder, inorder, map, pl + 1 + leftnum, pr,  key + 1, ir);

        return root;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}