package LinkedLists;

public class LinkedListNode {

	public int data;
	public LinkedListNode next;
	
	public LinkedListNode(int data)
	{
		this.data = data;
		this.next = null;
	}
	
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public LinkedListNode getNext() {
		return next;
	}
	public void setNext(LinkedListNode next) {
		this.next = next;
	}
	
	
	
}
