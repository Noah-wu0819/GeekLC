public class c19 {
    public class ListNode{
        public ListNode next;
        public int val;
        public ListNode(){};
        public ListNode(int v){
            val = v;
        }
        public ListNode(int v, ListNode n){
            val = v;
            next = n;
        }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ans = new ListNode(0);
        ans.next = head;
        ListNode slow = ans;
        ListNode fast = head;

        if (head == null) return null;

        for (int i = 0; i < n; i++){
            fast = fast.next;
        }
        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return ans.next;

    }
}
