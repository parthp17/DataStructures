package LeetCode;

class Node {
	int val;
	Node next;

	public Node(int val) {
		super();
		this.val = val;
	}

}

public class LLRotateRight {

	// 10 -> 20 -> 30 -> 40(t1) -> 50 -> 60(t2)
	// 50 -> 60 -> 10 ->20 -> 30 -> 40

	public Node rotateRight(Node head, int n) {
		Node t1 = head;
		Node t2 = head;
		while (n > 0) {
			t2 = t2.next;
			n--;
		}

		while (t2.next != null) {
			t1 = t1.next;
			t2 = t2.next;
		}
		Node temp = t1.next;
		t2.next = head;
		head = temp;
		t1.next = null;
		return head;

	}

	public static void main(String[] args) {
		Node n1 = new Node(10);
		Node n2 = new Node(20);
		Node n3 = new Node(30);
		Node n4 = new Node(40);
		Node n5 = new Node(50);
		Node n6 = new Node(60);
		Node n7 = new Node(70);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = null;
		Node n = new LLRotateRight().rotateRight(n1, 2);
		while (n != null) {
			System.out.println(n.val + " ");
			n = n.next;
		}
	}
}