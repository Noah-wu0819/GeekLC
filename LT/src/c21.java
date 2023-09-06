public class c21 {
    public class ListNode{
        public ListNode next;
        public int value;
        public ListNode(){};
        public ListNode(int v){
            value = v;
        }
        public ListNode(int v, ListNode n){
            value = v;
            next = n;
        }
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode head = new ListNode(-1);
        ListNode ans = head;
        while (list1 != null && list2 != null){
            if (list1.value < list2.value){
                ans.next = list1;
                list1 = list1.next;
            }else {
                ans.next = list2;
                list2 = list2.next;
            }
            ans = ans.next;
        }

        ans.next = list1 == null? list2: list1;
        return head.next;
    }
}
