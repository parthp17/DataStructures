package Graphs;

import java.util.HashMap;

public class DisJointSet {

	/*
	 * using union by Rank and Path Compression
	 * 
	 */
	class Node
	{
		int rank;
		int data;
		Node parent;
	}
	private HashMap<Integer,Node> map = new HashMap<Integer,Node>();
	
	public void makeSet(int data)
	{
		Node n = new Node();
		n.data = data;
		n.rank = 0;
		n.parent = n;
		map.put(n.data,n);
	}
	
	public void union(int data1, int data2)
	{
		Node node1 = map.get(data1);
		Node node2 = map.get(data2);
		
		Node parent1 = findSet(node1);
		Node parent2 = findSet(node2);
		
		if(parent1 == parent2)return;
		else if(parent1.rank == parent2.rank)
		{
			parent1.rank++;
			parent2.parent = parent1;
		}
		else if(parent1.rank > parent2.rank)
		{
			parent2.parent = parent1;
		}
		else
		{
			parent1.parent = parent2;
		}
	}

	private Node findSet(Node node)
	{
		Node n1 = node.parent;
		if(n1 == node) return node;
		node.parent = findSet(node.parent);
		return node.parent;
	}
	public int findSet(int data)
	{
		return findSet(map.get(data)).data;
	}
	 
	 
	 public static void main(String[] args)
	 {
		 DisJointSet ds = new DisJointSet();
	        ds.makeSet(1);
	        ds.makeSet(2);
	        ds.makeSet(3);
	        ds.makeSet(4);
	        ds.makeSet(5);
	        ds.makeSet(6);
	        ds.makeSet(7);

	        ds.union(1, 2);
	        ds.union(2, 3);
	        ds.union(4, 5);
	        ds.union(6, 7);
	        ds.union(5, 6);
	        ds.union(3, 7);

	        System.out.println(ds.findSet(1));
	        System.out.println(ds.findSet(2));
	        System.out.println(ds.findSet(3));
	        System.out.println(ds.findSet(4));
	        System.out.println(ds.findSet(5));
	        System.out.println(ds.findSet(6));
	        System.out.println(ds.findSet(7)); 
	}
}
