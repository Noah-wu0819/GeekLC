import java.util.List;

public class c206 {
    public static class ListNode{
         int val;
         ListNode next;

        public ListNode(){};
        public ListNode(int val){
            this.val = val;
        }
        public ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
        public ListNode reverseList(ListNode head) {

            if(head == null) return null;
            ListNode pre = null;
            ListNode cur = head;

            while (cur != null){
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }




    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l1.reverseList(l1);


    }
}

}