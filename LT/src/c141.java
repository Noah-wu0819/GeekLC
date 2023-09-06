public class c141 {
    class ListNode {
      int val;
      ListNode next;
       ListNode(int x) {
         val = x;
          next = null;
      }
  }
    public boolean hasCycle(ListNode head) {

        if (head == null||head.next == null) return false;
        ListNode fast = head.next;
        ListNode slow = head;

        while (fast != slow){
            if (fast == null || fast.next == null){
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;

        }
        return true;
    }


}
