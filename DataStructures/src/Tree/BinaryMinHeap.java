package Tree;
import java.util.ArrayList;

public class BinaryMinHeap<T extends Comparable<T>> {

	private ArrayList<T> list;

	public BinaryMinHeap()
	{
		this.list = new ArrayList<T>();
	}

	public void add(T item)
	{
		this.list.add(item);
		heapifyUp();
	}
	
	public void heapifyUp() {
		int k = list.size() - 1;
		int p = (k-1)/2;
		while(p >= 0)
		{
			if(list.get(k).compareTo(list.get(p)) < 0)
			{
				T item = list.get(k);
				list.set(k, list.get(p));
				list.set(p, item);
				k = p;
				p = (k-1)/2;
			}
			else
			{
				break;
			}
		}
	}

	public T extractMin()
	{
		if(list.size() < 1) return null;
		if(list.size() == 1) return list.remove(0);
		T item = list.get(0);
		list.set(0, list.remove(list.size()-1));
		heapifyDown();
		return item;
	}

	public void heapifyDown() {
		
		int k = 0;
		int max  = 2*k + 1;
		while(max < list.size())
		{
			
			if((max + 1) < list.size() && list.get(max+1).compareTo(list.get(max)) < 0)
			{
				max++;
			}
			
			if(list.get(k).compareTo(list.get(max)) < 0)
			{
				T item = list.get(k);
				list.set(k, list.get(max));
				list.set(max, item);
				k = max;
				max  = 2*k + 1;
			}
			else
			{
				break;
			}
		}
		
	}
}
