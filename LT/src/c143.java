public class c143 {
    public void reorderList(ListNode head) {
        if (head == null) return;
        ListNode slow = head;
        ListNode fast = head.next;//这一步记住

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode cur = slow.next;
        ListNode right = null;

        while (cur != null){
            ListNode next = cur.next;
            cur.next = right;
            right = cur;
            cur = next;
        }
        slow.next = null;
        ListNode l1 = head;

        mergeList(l1, right);

    }

    public void mergeList(ListNode l1, ListNode l2){
        while (l1!=null && l2 != null){
            ListNode l1_next = l1.next;
            ListNode l2_next = l2.next;
            l1.next = l2;
            l2.next = l1_next;
            l1 = l1_next;
            l2 = l2_next;
        }
    }
    public static class ListNode{
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

    public static void main(String[] args) {
        c143 c = new c143();
        ListNode l = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        c.reorderList(l);

    }
}
