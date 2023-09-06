import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class c297 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "X,";
        String left = serialize(root.left);
        String right = serialize(root.right);

        return root.val + "," + left + right;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) return null;
        String[] nodes = data.split(",");
        Queue<String> queue = new ArrayDeque<>(Arrays.asList(nodes));
        return buildTree(queue);
    }

    private TreeNode buildTree(Queue<String> data) {

        String value = data.poll();
        if (value.equals("X")) return null;
        TreeNode treeNode = new TreeNode(Integer.parseInt(value));

        treeNode.left = buildTree(data);
        treeNode.right = buildTree(data);
        return treeNode;

    }

    public static void main(String[] args) {
        c297 c = new c297();
        TreeNode node = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        node.left = node1;
        node.right = node2;
        String cc = c.serialize(node);
        System.out.println(cc);

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
