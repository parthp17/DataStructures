package Graphs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/**
 * Date 03/08/2017
 * @author Parth Pandya
 *
 * Data structure to support following operations
 * extracMin - O(logn)
 * addToHeap - O(logn)
 * containsKey - O(1)
 * decreaseKey - O(logn)
 * getKeyWeight - O(1)
 *
 * It is a combination of binary heap and hash map
 *
 */
public class PrimsBMH {

	public class Node{
		int weight;
		VertexInt key;
	}
	
	private ArrayList<Node> list;
	private Map<VertexInt, Integer> map;
	
	public PrimsBMH()
	{
		this.list = new ArrayList<Node>();
		this.map = new HashMap<VertexInt,Integer>();
	}
	
	public boolean contains(VertexInt key)
	{
		return map.containsKey(key);
	}
	
	public VertexInt min()
	{
		return this.list.get(0).key;
	}
	
	public void add(VertexInt key, int weight)
	{
		Node n = new Node();
		n.weight = weight;
		n.key = key;
		list.add(n);
		int k = list.size() - 1;
		map.put(key, k);
		int l = (k-1)/2;
		
		while(l >= 0)
		{
			
			Node n1 = list.get(k);
			Node n2 = list.get(l);
			
			if(n1.weight < n2.weight)
			{
				list.set(l, n1);
				map.remove(n1.key);
				map.put(n1.key, l);
				list.set(k, n2);
				map.remove(n2.key);
				map.put(n2.key, k);
				k = l;
				l = (k-1)/2;
			}
			else
			{
				break;
			}
		}
		
	}
	
	public Node extractMin()
	{
		Node n = list.get(0);
		map.remove(n.key);
		Node last = list.remove(list.size()-1);
		if(list.size() > 0)
		{
			list.set(0,last);
			map.remove(last.key);
			map.put(last.key, 0);
			int k = 0;
			int max= 2*k + 1;
			while(max < list.size())
			{
				if((max+1) < list.size() && list.get(max+1).weight < list.get(max).weight) max++;
				
				if(list.get(k).weight > list.get(max).weight)
				{
					Node temp = list.get(k);
					Node temp1 = list.get(max);
					map.remove(temp1.key);
					list.set(k, list.get(max));
					map.put(temp1.key, k);
					map.remove(temp.key);
					list.set(max, temp);
					map.put(temp.key, max);
					k = max;
					max= 2*k + 1; 
				}
				else
				{
					break;
				}
			}	
		}
		return n;
	}
	
	public void decrease(VertexInt key, int weight)
	{
		int k  = map.get(key);
		list.get(k).weight = weight;
		int l = (k - 1) /2;
		while(l >= 0)
		{
			Node n1 = list.get(k);
			Node n2 = list.get(l);
			if(n1.weight < n2.weight)
			{
				list.set(l, n1);
				map.remove(n1.key);
				map.put(n1.key, l);
				list.set(k, n2);
				map.remove(n2.key);
				map.put(n2.key, k);
				k = l;
				l = (k-1)/2;
			}
			else
			{
				break;
			}
		}
	}
	
	public int getWeight(VertexInt v)
	{
		Integer position = map.get(v);
		if(position != null) return list.get(position).weight;
		else return -1;
	}

	public boolean isEmpty() {
		return list.size() == 0;
	}
}
