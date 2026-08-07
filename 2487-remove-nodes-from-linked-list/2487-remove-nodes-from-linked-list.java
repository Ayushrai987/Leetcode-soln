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
    private ListNode reverse(ListNode head){
        ListNode prev = null, curr = head;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public ListNode removeNodes(ListNode head) {
        head = reverse(head);
         ListNode dummy = new ListNode(0);
         ListNode curr = dummy;
        int max =Integer.MIN_VALUE;

        while(head != null){
            if(head.val >= max){
                curr.next = new ListNode(head.val);
                curr = curr.next;
                max = head.val;
            }
            head= head.next;
        }
        return reverse(dummy.next);
        
        
    }
}