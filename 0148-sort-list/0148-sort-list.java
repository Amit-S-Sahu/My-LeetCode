/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        return quickSort(head, null);
    }

    private ListNode quickSort(ListNode start , ListNode end){
        if (start == null || start.next == null || start == end) return start;

        ListNode left = start, right = start, curr = start.next;
        boolean isSorted = true;

        while(curr != end){
            ListNode temp = curr.next;

            if (curr.val < start.val) {
                isSorted = false;
                curr.next = left;
                left = curr;
                right.next = temp;
            }
            else {
                if (right.val > curr.val) isSorted = false;
                right = curr;
            }
            curr = temp;
        }
        if(isSorted) return left;

        left = quickSort(left,start);
        start.next = quickSort(start.next,end);
        
        return left;
    }
}