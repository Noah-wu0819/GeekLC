import java.util.*;

public class c133 {
    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {

        if (node == null) return node;
        Queue<Node> queue = new ArrayDeque<>();

        HashMap<Node, Node> map = new HashMap<>();

        queue.offer(node);
        map.put(node, new Node(node.val, new ArrayList<>()));

        while (!queue.isEmpty()){
            Node temp = queue.poll();

            for (Node nb: temp.neighbors){
                if (!map.containsKey(nb)){
                    queue.offer(nb);
                    map.put(nb, new Node(nb.val, new ArrayList<>()));
                }
                map.get(temp).neighbors.add(nb);
            }
        }
        return map.get(node);
    }
}
