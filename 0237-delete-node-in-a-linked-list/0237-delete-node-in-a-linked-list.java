/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode temp = node;
        temp = temp.next;
        while (temp.next != null) {
            node.val = temp.val;
            node = node.next;
            temp = temp.next;
        }
        node.val = temp.val;
        node.next = null;
    }
}