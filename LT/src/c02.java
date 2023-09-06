//循环简化：把null转化为0，利用三目运算符，这样链表下一节点就可以被定义为0，循环缩减为一个，十分简单。while循环+||
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1==null||l2==null)
            return null;
        int carry = 0;

        ListNode ans = null;
        ListNode aaa = new ListNode();
        while (l1 != null && l2 != null){

            if (ans == null){
                ans = new ListNode((l1.val+l2.val+carry)%10);
                aaa = ans;
            }
            else {
                ans.next = new ListNode((l1.val + l2.val+ carry) % 10 );
                ans = ans.next;
            }
            if (l1.val + l2.val + carry>= 10){
                carry = 1;
            }else{
                carry = 0;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 ==null && l2 != null) {
            ans.next = new ListNode((l2.val+carry)%10);
            ans = ans.next;
            if (l2.val + carry >= 10) carry = 1;
            else carry = 0;
            l2 = l2.next;
        }

        while (l2 ==null && l1 != null) {
            ans.next = new ListNode((l1.val+carry)%10);
            ans = ans.next;
            if (l1.val + carry >= 10) carry = 1;
            else carry = 0;
            l1 = l1.next;
        }

        if (carry != 0){
            ans.next = new ListNode(1);
        }

        return aaa;
    }
    ListNode head = null;
    ListNode tail = null;
    int carry = 0;
    public ListNode add2(ListNode l1, ListNode l2){
        while (l1 != null || l2 != null){
            int n1 = l1 != null? l1.val: 0;
            int n2 = l2 != null? l2.val: 0;
            int sum = n1 + n2 + carry;
            if (head == null){
                tail = new ListNode(sum%10);
                head = tail;
            }else{
                tail.next = new ListNode(sum%10);
                tail = tail.next;
            }
            carry = sum/10;
            if (l1 != null){
                l1 = l1.next;
            }
            if (l2 != null){
                l2 = l2.next;
            }
        }
        if (carry != 0){
            tail.next = new ListNode(1);
        }
        return head;
    }





    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        l1.next = new ListNode(7);

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(2);


        Solution s = new Solution();
        ListNode ll = s.add2(l1, l2);

        while (ll != null){
            System.out.println(ll.val);
            ll = ll.next;
        }
    }

}
