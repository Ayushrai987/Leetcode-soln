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
    private int getLength(ListNode head){
        int count  = 0;
        while(head != null){
            count++;
            head = head.next;
        }
        return count;
    }
    public ListNode[] splitListToParts(ListNode head, int k) {

        int n = getLength(head);

        int base = n / k;
        int extra = n % k;

        ListNode[] ans  = new ListNode[k];
       ListNode curr = head;

        for(int i =0; i<k; i++){
           int size = base;
           if(i < extra) size++;

           if(size == 0){
            ans[i] = null;
            continue;
           }
           ans[i] = curr;

           for(int j=1; j<size; j++){
            curr = curr.next;
           }
           ListNode nextPart = curr.next;
           curr.next =  null;
           curr = nextPart;
            
        }
        return ans;

        
    }
}