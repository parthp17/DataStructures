package LeetCode.LinkedList;

public class Reorder {

//    Given a singly linked list L: L0→L1→…→Ln-1→Ln,
//    reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

    private class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }


    public void reorderList(ListNode head) {

        if(head == null || head.next == null || head.next.next == null) return;
        ListNode fast = head;
        int len = 0;
        while(fast != null) {
            fast = fast.next;
            len++;
        }
        int m = len >> 1;
        fast = head;
        for (;m > 1 ; m--, fast = fast.next);
        ListNode mid = fast.next;
        fast.next = null;
        ListNode next = null;
        ListNode prev = null;
        while(mid != null){
            next = mid.next;
            mid.next = prev;
            prev =mid;
            mid = next;
        }
        ListNode start = null;

        while(head != null) {

            if(start == null) start = head;
            else {
                start.next = head;
                start = start.next;
            }
            head = head.next;
            start.next = prev;
            prev = prev.next;
            start = start.next;
        }
        if(prev != null) start.next = prev;
    }
}
