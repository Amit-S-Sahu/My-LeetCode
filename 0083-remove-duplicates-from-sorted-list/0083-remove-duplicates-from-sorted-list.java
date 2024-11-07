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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode prev = head, curr = head;
        HashSet<Integer> visited = new HashSet<>();
        while (curr != null) {
            if (!visited.contains(curr.val)) {
                visited.add(curr.val);
                prev = curr;
            }
            else prev.next = curr.next;
            curr = curr.next;
        }
        return head;
    }
}