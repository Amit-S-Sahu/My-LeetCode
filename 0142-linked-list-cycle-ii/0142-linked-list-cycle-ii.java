/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        HashMap<ListNode, Integer> visited = new HashMap<>();
        int i = 0;
        while (head != null) {
            if (!visited.containsKey(head)) {
                visited.put(head, i);
                i++;
            }
            else return head;
            head = head.next;
        }

        return null;
    }
}