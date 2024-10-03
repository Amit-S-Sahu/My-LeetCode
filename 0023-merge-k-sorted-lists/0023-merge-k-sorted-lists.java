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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>((n1, n2) -> (n1.val - n2.val));
        ListNode head = new ListNode();
        ListNode curr = head;
        for(int i = 0; i < lists.length; ++ i) {
            if(null != lists[i]) {
                heap.add(lists[i]);
            }
        }
        while(! heap.isEmpty()) {
            ListNode minNode = heap.poll();
            curr.next = minNode;
            curr = minNode;
            if(minNode.next != null) {
                heap.add(minNode.next);
            }
        }
        return head.next;
    }
}