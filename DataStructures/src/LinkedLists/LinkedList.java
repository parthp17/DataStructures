package LinkedLists;
import java.util.*;

public class LinkedList {

	private LinkedListNode head;
	private int length;
	
	public LinkedList()
	{
		this.head = null;
		this.length = 0;
	}
	
	public LinkedList(LinkedListNode head)
	{
		this.head = head;
		this.length = 1;
	}

	public LinkedListNode getHead() {
		return head;
	}

	public void setHead(LinkedListNode head) {
		this.head = head;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
		
	//addfront
	public synchronized void insertAtFront(LinkedListNode node)
	{
		//LinkedListNode node = new LinkedListNode(data);
		node.setNext(this.head);
		this.head = node;
		this.length++;
	}
	
	//addrear
	public synchronized void insertAtRear(LinkedListNode node)
	{
		LinkedListNode temp = head;
		if(temp!=null)
		{
			while(temp.getNext() != null)
				temp = temp.getNext();
		}
		else
		{
			this.head = node;
		}
		this.length++;
	}

	//addposition
	public synchronized void insertAtPosition(LinkedListNode node, int position)
	{
		LinkedListNode temp = this.head;
		if(position < 0) return;
		if(position > this.length) position = this.length;
		if(temp == null) 
		{
			this.head = node;
		}
		else
		{
			for(int i = 0; i < position; i++,temp = temp.getNext());
			
			node.setNext(temp.getNext());
			temp.setNext(node);
		}
		this.length++;
	}
	
	
	//remove
	public synchronized LinkedListNode removeFromBegining()
	{
		LinkedListNode node = this.head;
		this.head = node.getNext();
		node.setNext(null);
		this.length--;
		return node;
	}
	
	public synchronized LinkedListNode removeFromEnd()
	{
		LinkedListNode temp = head;
		if(temp != null)
		{
			LinkedListNode prev = temp;
			temp = temp.getNext();
			while(temp.getNext() != null)
			{
				prev = temp;
				temp = temp.getNext();
			}
			prev.setNext(null);
			this.length--;
			return temp;
		}
		else
		{
			return null;
		}
	}
	
	public synchronized LinkedListNode removeAtPosition(int position)
	{
		if(position < 0) position = 0;
		if(position >= this.length) position = length - 1;
		LinkedListNode temp = this.head;
		if(temp == null)return null;
		else
		{
			if(position == 0) 
			{
				this.head = temp.getNext();
				temp.setNext(null);
			}
			else
			{
				for(int i = 1; i < position; i++)
				{
					temp = temp.getNext();
				}
				LinkedListNode node = temp.getNext();
				temp.setNext(node.getNext());
				node.setNext(null);
				temp = node;
			}
			this.length--;
			return temp;
		}
	}
	//search
	public synchronized int search(int data)
	{
		int count = 0;
		if(data == this.head.getData()) return 0;
		LinkedListNode temp = this.head;
		while(temp != null && data != temp.getData() )
		{
			count++;
			temp = temp.getNext();
		}
		if(temp != null)
		return count;
		else return -1;
	}
	
	//nthNodeFromEnd
	
	public LinkedListNode nthNodeFromEnd(int n)
	{
		
		if(this.head == null) return null;
		if(n >= this.length) return this.head;
		
		LinkedListNode node1 = this.head;
		LinkedListNode node2 = node1;
		
		for(int i = 0 ; i < n; i++)
			node2 = node2.getNext();
		
		while(node2 != null )
		{
			node2 = node2.getNext();
			node1 = node1.getNext();
		}
		
		return node1;
	}
	
	public LinkedListNode nthNodeFromEndRecursive(int p)
	{
		return nthNodeFromEndRecursive(this.head, new int[]{p});
	}
	
	
	
	private LinkedListNode nthNodeFromEndRecursive(LinkedListNode node, int[] arr) {
		if(node == null)
		{
			return null;
		}
		LinkedListNode temp = nthNodeFromEndRecursive(node.getNext(), arr);
		if(temp == null)
		{
			arr[0]--;
			if(arr[0] == 0) return node;
			else
				return null;
		}
		else
		{
			return temp;
		}
	}

	public void printLL()
	{
		LinkedListNode node= this.head;
		
		do{
			System.out.println(node.getData());
			node = node.getNext();
		}while(node != null);
		
	}
	
	public void deleteNode(LinkedListNode node)
	{
		if(node == null) return;
		while(node.getNext() != null)
		{
			node.setData(node.getNext().getData());
			node = node.getNext();
		}
		node = null;
		this.length--;
	}
	
	public LinkedListNode findMiddle()
	{
		LinkedListNode slow = this.head;
		LinkedListNode fast = this.head;
		if(this.head == null) return null;
		
		while(fast != null && fast.getNext() != null)
		{
			fast= fast.getNext().getNext();
			slow = slow.getNext();
		}
		
		return slow;
	}
	
	public void deleteLinkedList()
	{
		if(this.length > 0 && this.head != null)
		{
			LinkedListNode node  = this.head;
			LinkedListNode temp = null;
			while(node != null)
			{
				temp = node;
				node = node.getNext();
				temp.setNext(null);
			}
			this.head = null;
			this.length = 0;
		}
	}
	
	public int findLoop()
	{
		if(this.head == null) return -1;
		
		LinkedListNode fast = this.head;
		LinkedListNode slow = this.head;
		
		while(fast != null && fast.getNext() != null )
		{
			fast = fast.getNext().getNext();
			slow = slow.getNext();
			if(fast == slow) break;
		}
		if(fast == null || fast.getNext() == null) return -1;
		else
		{
			fast = this.head;
			int count = 0;
			while(fast != slow)
			{
				fast = fast.getNext();
				slow= slow.getNext();
				count++;
			}
			return count;
		}
	}
	
	public boolean isPalindrome()
	{
		LinkedListNode node = this.head;
		boolean isPalindrome = true;
		for(int i = 0 ; i < this.length/2;i++)
		{
			node = node.getNext();
		}
		LinkedListNode prev = null;
		LinkedListNode next = null;
		LinkedListNode current = node.getNext();
		
		while(current != null)
		{
			next = current.getNext();
			current.setNext(prev);
			prev = current;
			current = next;
		}
		node.setNext(prev);
		node = this.head;
		
		for(int i = 0 ; i < this.length/2;i++)
		{
			if(node.getData() != prev.getData())
			{
				isPalindrome = false; break;
			}
			node = node.getNext();
			prev = prev.getNext();
		}
		if(!isPalindrome)
		{
			for(int i = 0 ; i < this.length/2;i++)
			{
				node = node.getNext();
			}
		}
		
		prev = null;
		next = null;
		current  = node.getNext();
		while(current != null)
		{
			next = current.getNext();
			current.setNext(prev);
			prev = current;
			current = next;
		}
		node.setNext(prev);
		
		return isPalindrome;
	}
	
	public void reverse()
	{
		LinkedListNode prev = null;
		LinkedListNode next = null;
		LinkedListNode current = this.head;
		
		while(current != null)
		{
			next = current.getNext();
			current.setNext(prev);
			prev = current;
			current = next;
		}
		this.head = prev;
	}
	
	public void reverseInPair()
	{
		LinkedListNode prev = null;
		LinkedListNode current = this.head;
		LinkedListNode next = null;
		this.head = current.getNext();
		while(current != null && current.getNext() != null)
		{
			next = current.getNext();
			LinkedListNode temp = next.getNext();
			next.setNext(current);
			if(prev != null) prev.setNext(next);
			current.setNext(temp);
			prev = current;
			current = temp;
		}		
	}
	
	public static LinkedListNode recursiveReverse(LinkedListNode node)
	{
		// null(0) -> head(1) -> second(2) -> third(3) ------(9)-> tenth(10)
		if(node == null || node.getNext() == null) return node;
		LinkedListNode next = node.getNext(); //next =2
		node.setNext(null); // head.next - > null0
		LinkedListNode rest = recursiveReverse(next); //recure(2)
		next.setNext(node); // 2.next = 1
		return rest; // tenth(10)
	}
	
	public void removeDuplicates()
	{
		LinkedListNode node = this.head;
		HashMap<Integer, LinkedListNode> map = new HashMap<Integer, LinkedListNode>();
		LinkedListNode prev = null;
		while(node != null)
		{
			if(!map.containsKey(node.getData()))
			{
				map.put(node.getData(), node);
				prev = node;
			}
			else
			{
				prev.setNext(node.getNext());
				this.length--;
			}
			node = node.getNext();
		}
	}
	
	public LinkedList splitCircular()
	{
		LinkedListNode fast = this.head;
		LinkedListNode slow = this.head;
		while(fast.getNext()!=this.head && fast.getNext().getNext() != this.head)
		{
			fast = fast.getNext().getNext();
			slow = slow.getNext();
		}
		if(fast.getNext().getNext() == head) fast = fast.getNext();
		LinkedListNode first = fast.getNext();//head
		LinkedListNode mid = slow.getNext();//mid
		fast.setNext(mid);//2nd half
		slow.setNext(first);//1st half
		LinkedList ll = new LinkedList();
		ll.setHead(mid);
		return ll;
	}
	
	public static LinkedListNode mergeSortedLinkedList(LinkedListNode node1, LinkedListNode node2)
	{
		if(node1 == null) return node2;
		if(node2 == null) return node1;
		
		LinkedListNode result = null;
		if(node1.getData() <= node2.getData())
		{
			result = node1;
			result.setNext(mergeSortedLinkedList(node1.getNext(),node2));
		}
		else
		{
			result = node2;
			result.setNext(mergeSortedLinkedList(node2.getNext(),node2));
		}
		return result;
	}
	
	public void reverseKNodesInGroup(int k)
	{
		LinkedListNode current = this.head;
		LinkedListNode prevCurrent = current;
		LinkedListNode prevTail = null;
		while(current != null)
		{
			int count  = k;
			LinkedListNode tail = null;
			LinkedListNode next = null;
			while(current != null && count > 0 )
			{
				next= current.getNext();
				current.setNext(tail);
				tail = current;
				current = next;
				count--;
			}
			if(prevTail != null)
			{
				prevTail.setNext(tail);
			}
			else
			{
				this.head = tail;
			}
			prevTail = prevCurrent;
			prevCurrent = current;
		}
	}

	public LinkedListNode reverseKGroup(LinkedListNode head, int k) {
		if(head == null || k < 2) return head;

		LinkedListNode current = head;
		LinkedListNode prevTail = null;
		LinkedListNode prevStart = head;
		LinkedListNode runner = head;
		while(runner != null){
			int count = 0;
			for(; runner != null && count < k ; runner = runner.getNext(), count++);
			if (count == k){

				LinkedListNode next = null;
				LinkedListNode prev = null;
				while(count > 0){
					next = current.getNext();
					current.setNext(prev);
					prev = current;
					current = next;
					count--;
				}
				if(prevTail != null)
					prevTail.setNext(prev);
				else
					head = prev;
				prevTail = prevStart;
				prevStart = current;
			}
			else {
				if(prevTail != null)
					prevTail.setNext(current);
			}

		}
		return head;
	}
	
	public LinkedListNode reverseKNodesInGroupRecursively(LinkedListNode node, int k)
	{
		LinkedListNode current = node;
		LinkedListNode prev = null;
		LinkedListNode next = null;
		int count = k;
		for(int i = 0 ; i < k ;i++)
			if(current == null) return node;
			else
				current = current.getNext();
		
		current  = node;
		while(current != null && count > 0)
		{
			next = current.getNext();
			current.setNext(prev);
			prev = current;
			current = next;
			count--;
		}
		if(next!=null)
		{
			node.setNext(reverseKNodesInGroupRecursively(next, k));
		}
		return prev;
	}
	
	public LinkedListNode reverseKAlternateNodes(LinkedListNode n, int k)
	{
		
		LinkedListNode current = n;
		LinkedListNode prev = null;
		LinkedListNode next = null;
		int count = k;
		while(current != null && count > 0)
		{
			next = current.getNext();
			current.setNext(prev);
			prev = current;
			current = next;
			count--;
		}
		if(n != null)
			n.setNext(current);
		for(;count<k;count++)
		{
			if(current!=null)
				current= current.getNext();
			else
				return current;
		}
		
		if(current != null && current.getNext() !=null)
		{
			current.setNext(reverseKAlternateNodes(current.getNext(), k));
		}
		return prev;
	}
	
	public LinkedListNode getSum(LinkedListNode n1, LinkedListNode n2)
	{
		LinkedListNode head = new LinkedListNode(0);
		int carry = 0;
		LinkedListNode curr=head;
		while(n1 != null && n2 != null)
		{
			curr.setNext(new LinkedListNode((n1.getData() + n2.getData() + carry)%10));
			curr = curr.getNext();
			carry = (n1.getData() + n2.getData() + carry)/10;
			n1=n1.getNext();
			n2=n2.getNext();
		}
		
		while( n1 != null)
		{
			curr.setNext(new LinkedListNode((n1.getData() + carry)%10));
			carry = (carry + n1.getData())/10;
			curr = curr.getNext();
			n1 = n1.getNext();
		}
		
		while( n2 != null)
		{
			curr.setNext(new LinkedListNode((n2.getData() + carry)%10));
			carry = (carry + n2.getData())/10;
			curr = curr.getNext();
			n2 = n2.getNext();
		}
		return head.getNext();
	}
	/*private LinkedListNode getSum(LinkedListNode n1, LinkedListNode n2, int carry)
	{
		if(n1==null && n2==null && carry == 0) return null;
		int result = carry;
		LinkedListNode n11 = null, n21 = null;
		if(n1 != null)
		{
			result += n1.getData();
			n11 = n1.getNext();
		}
		
		if(n2 != null)
		{
			result += n2.getData();
			n21 = n2.getNext();
		}
		
		LinkedListNode node = new LinkedListNode(result%10);
		node.setNext(getSum(n11,n21,result/10));
		
		return node;
	}*/
	
	public LinkedListNode getModuloNode(int k)
	{
		LinkedListNode node = this.head;
		LinkedListNode moduloNode = null;
		for(int i = 1; node != null;node = node.getNext(), i++)
			if(i%k==0) moduloNode = node;
		return moduloNode;
	}
	
	public LinkedListNode rotateRight(int k)
	{
		LinkedListNode node1 = this.head;
		LinkedListNode node2 = this.head;
		
		for(int i = 1; i <= k; i++) node2 = node2.getNext();
		
		while(node2.getNext() != null)
		{
			node2 = node2.getNext();
			node1 = node1.getNext();
		}
		node2.setNext(this.head);
		this.head = node1.getNext();
		node1.setNext(null);
		return this.head;
	}

	public LinkedListNode reorderByK(int x)
	{
		if(head == null) return head;

		LinkedListNode n = head;
		LinkedListNode n1 = null;
		LinkedListNode n2 = null;
		LinkedListNode temp = null;
		while( n != null ) {
			if(n.getData() < x)
			{
				if (n1 == null) {
					n1 = n;
					head = n;
				}
				else {
					n1.setNext(n);
					n1 = n1.getNext();
				}
			} else {
				if (n2 == null) {
					n2 = n;
					temp = n;
				}
				else {
					n2.setNext(n);
					n2 = n2.getNext();
				}
			}
			n = n.getNext();
		}
		if(n1 != null) n1.setNext(temp);
		if(n2 != null) n2.setNext(null);
		return head;
	}

	public LinkedListNode reverseBetween(LinkedListNode head, int m, int n) {
		if(m == n) return head;
		LinkedListNode current = head;
		LinkedListNode tail = null;
		LinkedListNode next = null;
		int p = 1;
		LinkedListNode prev = null;
		while(p < m) {
			if(tail != null)
				tail = tail.next;
			else
				tail = head;
			prev = current;
			current = current.next;
			p++;
		}
		while( p <= n) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			p++;
		}
		if(tail != null)
			tail.next.next = current;
		else
			head.next = current;

		if(tail != null)
			tail.next = prev;
		if (m == 1)
			return prev;
		else
			return head;

	}

	public LinkedListNode addTwoNumbers(LinkedListNode l1, LinkedListNode l2) {
		Stack<Integer> s1 = new Stack<Integer>();
		Stack<Integer> s2 = new Stack<Integer>();

		while(l1 != null) {
			s1.push(l1.data);
			l1 = l1.next;
		};
		while(l2 != null) {
			s2.push(l2.data);
			l2 = l2.next;
		}

		int sum = 0;
		LinkedListNode list = new LinkedListNode(0);
		while (!s1.empty() || !s2.empty()) {
			if (!s1.empty()) sum += s1.pop();
			if (!s2.empty()) sum += s2.pop();
			list.data = sum % 10;
			LinkedListNode head = new LinkedListNode(sum / 10);
			head.next = list;
			list = head;
			sum /= 10;
		}

		return list.data == 0 ? list.next : list;
	}


}