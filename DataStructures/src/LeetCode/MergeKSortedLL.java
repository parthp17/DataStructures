package LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLL {

	 public ListNode mergeKLists(ListNode[] lists) {
		 if(lists == null || lists.length == 0)return null;
		 return partition(lists,0,lists.length-1);
	  }
	 
	 private ListNode partition(ListNode[] lists, int start, int end)
	 {
		if (start == end)
			return lists[start];
		else if (start < end) {
			int mid = (start + end) >> 1;
			ListNode l1 = partition(lists, start, mid);
			ListNode l2 = partition(lists, mid + 1, end);
			return mergeTwoLists(l1, l2);
		}
		else
			return null;
	 }
	 
	 private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
			if(l1 == null) return l2;
			if(l2 == null) return l1;
			
			if(l1.val <= l2.val)
			{
				l1.next = mergeTwoLists(l1.next, l2);
				return l1;
			}
			else
			{
				l2.next = mergeTwoLists(l1, l2.next);
				return l2;
			}
		}
	 public static void main(String[] args) {
		
		 MergeKSortedLL mkll = new MergeKSortedLL();
		 ListNode[] arr = new ListNode[1];
		 mkll.mergeKLists(arr);
	}
	 
	public ListNode mergeKSortedWithPQ(ListNode[] lists)
	{
		PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((l1,l2) -> {
			if(l1.val < l2.val)return -1;
			else if(l1.val == l2.val) return 0;
			else
				return 0;
		});
		
		for(ListNode ln: lists)
			if(ln != null)
				pq.offer(ln);
		
		ListNode head = new ListNode(0);
		ListNode p = head;
		
		while(!pq.isEmpty())
		{
			p.next = pq.poll();
			if(p.next.next != null)
				pq.offer(p.next.next);
			p = p.next;
		}
		return head.next;
	}
}
