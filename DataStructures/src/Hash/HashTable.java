package Hash;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HashTable<K,V>
{
	class HashElement
	{
		K key;
		V value;	
		HashElement next;
		public HashElement(K key, V value)
		{
			this.key = key;
			this.value = value;
			this.next = null;
		}
	}
	
	public ArrayList<HashElement> row = null;
	int tsize;
	int count;
	static final int LOADFACTOR = 20;
	static final int DEFAULT_SIZE = 100;
	public HashTable()
	{
		this(DEFAULT_SIZE);
	}
	
	public HashTable(int size)
	{
		this.tsize = size/LOADFACTOR;
		row = new ArrayList<HashElement>();
		for(int i = 0; i < tsize; i++)
			row.add(null);
		count = 0;
	}
	
	private int hash(K key)
	{
		return key.hashCode() % this.tsize;
	}
	
	public void put(K key, V value)
	{
		int index = this.hash(key);
		HashElement head = row.get(index);
		while(head != null)
		{
			if(head.key.equals(key))
			{
				head.value = value;
				return;
			}
			head = head.next;
		}
		HashElement newElement = new HashElement(key, value);
		newElement.next = row.get(index);
		row.set(index, newElement);
		count++;
		if((float)count/tsize >= 0.8*LOADFACTOR)
		{
			ArrayList<HashElement> temp = row;
			this.tsize *= 2;
			row = new ArrayList<HashElement>();
			for(int i = 0; i < tsize; i++)
				row.add(null);
			for(HashElement e : temp)
			{
				while(e != null)
				{
					put(e.key,e.value);
					e = e.next;
				}
			}
		}
		return;
	}
	
	public boolean contains(K key)
	{
		int index = this.hash(key);
		HashTable<K, V>.HashElement head = row.get(index);
		while(head != null)
		{
			if(head.key.equals(key))return true;
			head = head.next;
		}
		return false;
	}
	
	public V get(K key)
	{
		if(this.contains(key))
		{
			int index = this.hash(key);
			HashElement head = row.get(index);
			while(head != null)
			{
				if(head.key.equals(key))
				{
					return head.value;
				}
				head = head.next;
			}
			return null;
		}
		else return null;
	}
	public V remove(K key)
	{
		if(this.contains(key))
		{
			int index = this.hash(key);
			HashElement head = row.get(index);
			HashElement prev= null;
			while(head != null)
			{
				if(head.key.equals(key))
				{
					prev.next = head.next;
					head.next = null;
					count--;
					return head.value;
				}
				prev = head;
				head = head.next;
			}
			return null;
		}
		else return null;
	}
	
	public int size() {return count;}
	public boolean isEmpty(){return count == 0;}
	
	public void putAll(HashTable<K,V> t)
	{
		for(HashElement hl : t.row)
		{
			while(hl != null)
			{
				this.put(hl.key,hl.value);
				hl = hl.next;
			}
		}
	}
	
	
	
}