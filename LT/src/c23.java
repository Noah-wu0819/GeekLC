import java.util.ArrayList;
import java.util.List;

public class c23 {
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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = new ListNode();
        ListNode head = res;

        for (ListNode l: lists){
            res = merge2Lists2(res, l);
        }

        return res;
    }

    public ListNode merge2Lists(ListNode l1, ListNode l2){
        ListNode head = new ListNode(0);
        ListNode ans = head;

        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                ans.next = l1;
                l1 = l1.next;
            }else {
                ans.next = l2;
                l2 = l2.next;
            }
            ans = ans.next;
        }

        ans.next = l1 == null? l2: l1;
        return head.next;
        //迭代
    }

    public ListNode merge2Lists2(ListNode l1, ListNode l2){
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val < l2.val){
            l1.next = merge2Lists2(l1.next, l2);
            return l1;
        }else {
            l2.next = merge2Lists2(l2.next, l1);
            return l2;
        }
    }

}
