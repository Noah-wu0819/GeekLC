import java.util.Stack;

public class c98 {
    public boolean isValidBST(TreeNode root) {
        long min = Long.MIN_VALUE;
        long max = Long.MAX_VALUE;



        return helper(root, min, max);
    }

    private boolean helper(TreeNode root, long min, long max) {
        if(root == null) return true;
        if (root.val >= max || min >= root.val){
            return false;
        }
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        node.left = node1;
        node.right = node3;
        c98 c = new c98();
        c.isValidBST(node);
    }

    public void inorder(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();

        while (root != null){
            stack.push(root);
            root = root.left;
        }

        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            node = node.right;
            while (node != null){
                stack.push(node);
                node = node.left;
            }
        }
    }
}
