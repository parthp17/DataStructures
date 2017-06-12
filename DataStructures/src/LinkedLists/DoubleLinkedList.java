package LinkedLists;

public class DoubleLinkedList {

	private DLLNode head;
	
	
	public DoubleLinkedList cloneLinkedList()
	{
		//add duplicate node after the original
		//original -> next -> arbitary == original ->arbitary ->next
		//original -> next == original -> next ->next
		//duplicate -> next = duplicate -> next
		DLLNode node = this.head;
		DLLNode duplicate = null;
		while(node != null)
		{
			 duplicate = new DLLNode();
			duplicate.setValue(node.getValue());
			duplicate.setNext(node.getNext());
			node.setNext(duplicate);
			node = duplicate.getNext();
		}
		node = this.head;
		duplicate = node.getNext();
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.head = duplicate;
		while(node != null)
		{
			duplicate.setPrevious(node.getPrevious().getNext());
			duplicate = duplicate.getNext().getNext();
			node = node.getNext().getNext();
		}
		node = this.head;
		duplicate = dll.head;
		
		while(node != null)
		{
			node.setNext(node.getNext().getNext());
			duplicate.setNext(duplicate.getNext().getNext());
		}
		return dll;
	}
	
	public void reverseDLL()
	{
		DLLNode node = this.head;
		DLLNode temp = null;
		
		while(node != null)
		{
			temp = node.getNext();
			
			node.setNext(node.getPrevious());
			node.setPrevious(temp);
			if(temp == null)
			{
				this.head = node;
			}
			
			node = temp;
		}
	}
}
