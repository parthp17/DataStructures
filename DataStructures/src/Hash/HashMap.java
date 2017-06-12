package Hash;

class Node{
	
	private int nKey;
	private String sData;
	private Node next;
	
	public void setKey(int key)
	{
		this.nKey = key;
	}
	public void setData(String data)
	{
		this.sData = data;
	}
	public void setNext(Node next)
	{
		this.next = next;
	}
	
	public int getKey()
	{
		return this.nKey;
	}
	
	public String getData()
	{
		return this.sData;
	}
	
	public Node getNext()
	{
		return this.next;
	}
}

class Row{
	
	private int nRowCount;
	private Node startNode;
	
	public void setRowCount(int count)
	{
		this.nRowCount = count;
	}
	public void setStartNode(Node node)
	{
		this.startNode = node;
	}
	
	public Node getStartNode()
	{
		return this.startNode;
	}
	
	public int getRowCount()
	{
		return this.nRowCount;
	}
}


public class HashMap {
	
	private int nCount;
	private int nTableSize;
	private Row[] rows;
	private static final int LOAD_FACTOR = 20;
	
	public void setCount(int count)
	{
		this.nCount = count;
	}
	public void setTableSize(int size)
	{
		this.nTableSize = size;
	}
	public void setRows(Row[] rows)
	{
		this.rows = rows;
	}
	
	public int getCount()
	{
		return this.nCount;
	}
	
	public int getTableSize()
	{
		return this.nTableSize;
	}
	
	public Row[] getRows()
	{
		return this.rows;
	}
	
	private static int hashCode(String data, int size)
	{
		return (data.length() % size);
	}
	
	public static HashMap createHashTable(int size)
	{
		HashMap objHashTable = new HashMap();
		objHashTable.nTableSize = size/LOAD_FACTOR;
		objHashTable.nCount = 0;
		objHashTable.rows = new Row[objHashTable.nTableSize];
		for(int i = 0; i < objHashTable.nTableSize ; i++)
		{
			objHashTable.rows[i].setRowCount(0);
			objHashTable.rows[i].setStartNode(null);
		}
		return objHashTable;
	}
	
	public static int hashSearch(String data, HashMap hashTable)
	{
		Node temp;
		int hash = hashCode(data, hashTable.nTableSize);
	
		if((temp = hashTable.getRows()[hash].getStartNode()) != null)
		{
			return 0;
		}
		else
		{
			while(temp != null)
			{
				if(temp.getData() == data)
				{
					return 1;
				}
				temp = temp.getNext();
			}
			return 0;
		}
	}
	
	public static boolean hashInsert(String data, HashMap hashTable)
	{
		Node temp, newNode;
		
		if(hashSearch(data, hashTable) == 1)
		{
			return false;
		}
		int hash = hashCode(data, hashTable.nTableSize);
		
		temp = hashTable.getRows()[hash].getStartNode();
		newNode = new Node();
		newNode.setData(data);
		newNode.setKey(hash);
		newNode.setNext(temp);
		hashTable.getRows()[hash].setStartNode(newNode);
		hashTable.getRows()[hash].setRowCount(hashTable.getRows()[hash].getRowCount() + 1);
		hashTable.setCount(hashTable.getCount() + 1);
		return true;
	}
	
	public static boolean hashRemove(String data, HashMap hashTable)
	{
		Node temp, prev = null;
		
		if(hashSearch(data, hashTable) == 0)
		{
			return false;
		}
		else
		{
			int hash = hashCode(data, hashTable.nTableSize);
			temp = hashTable.getRows()[hash].getStartNode();
			while(temp != null)
			{
				if(temp.getData() == data)
				{
					if(prev != null)
					{
						prev.setNext(temp.getNext());
					}
					else
					{
						hashTable.getRows()[hash].setStartNode(temp.getNext());
					}
					break;
				}
				else
				{
					prev = temp;
					temp = temp.getNext();
				}
			}
			return true;
		}
	}
}