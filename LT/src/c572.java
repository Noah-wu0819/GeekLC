import java.util.Stack;

public class c572 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            boolean ans = isSameTree(node, subRoot);
            if (ans) return true;

            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return false;
    }

    public boolean isSameTree(TreeNode a, TreeNode b){
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        if (a.val != b.val) return false;

        return isSameTree(a.left, b.left) && isSameTree(a.right, b.right);
    }
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
