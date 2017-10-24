package Utilities;

import java.util.HashSet;

public class MinHopsGrid {

	class Node {
		int val;
		Node next;
		Node below;
	}
	
	public int minHops(Node root, int val)
	{
		if(root != null)
			return minHops(root, val, 0);
		else return 0;
	}

	private int minHops(Node node, int val, int currDist) {
		
		if(node.next != null)
		{
			if(node.next.val < val)
			{
				return minHops(node.next, val, currDist + 1);
			}
			else if(node.next.val == val)
			{
				return currDist + 1;
			}
			else
			{
				if(node.below != null)
					return minHops(node.below, val, currDist + 1);
				else
					return currDist + 1;
			}
		}
		else
		{
			if(node.below != null)
				return minHops(node.below, val, currDist + 1);
			else
				return currDist + 1;
		}
	}
}
