


  class ListNode {
      int val;
     ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

public class p_142 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast, slow;
        fast = head;
        slow = head;

        while (true){
            if(fast == null || fast.next ==null)
                return null;
            fast = fast.next.next;
            slow = slow.next;
            if( fast == slow)
                break;
        }

        fast =head;
        while (fast != slow){
            fast = fast.next;
            slow = slow.next;

        }
        return fast;
    }


}
