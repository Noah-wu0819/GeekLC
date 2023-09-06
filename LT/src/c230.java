import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class c230 {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        while (root!=null){
            stack.push(root);
            root = root.left;
        }

        while (!stack.isEmpty()){
            TreeNode node = stack.pop();

            list.add(node.val);
            node = node.right;
            while (node != null){
                stack.push(node);
                node = node.left;
            }
        }
        return list.get(k-1);
    }
}
