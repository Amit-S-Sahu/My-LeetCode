class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode temp = head;
        int len = 0;
        while (temp != null) {
            len++;
            temp = temp.next;
        }

        int reqd = len - n;
        temp = dummy;  

        while (reqd > 0) {
            temp = temp.next;
            reqd--;
        }

        temp.next = temp.next.next;

        return dummy.next;
    }
}
