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
        if(head==null) return null;
        
        ListNode intersect = getIntersect(head);
        if(intersect == null) return null;
        
        ListNode ptr1 = head;
        ListNode ptr2 = intersect;
        while(ptr1!=ptr2)
        {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        
        return ptr1;
    }
    
    ListNode getIntersect(ListNode head)
    {
        ListNode tortoise = head;
        ListNode hare = head;
        
        while(hare!=null && hare.next!=null)
        {
            tortoise = tortoise.next;
            hare = hare.next.next;
            if(tortoise == hare)
            {
                return tortoise;
            }
        }
        
        return null;
        
    }
}