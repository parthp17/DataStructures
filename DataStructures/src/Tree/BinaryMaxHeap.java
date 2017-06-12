package Tree;
import java.util.ArrayList;

public class BinaryMaxHeap<T extends Comparable<T>> {

	private ArrayList<T> list;

	public BinaryMaxHeap()
	{
		this.list = new ArrayList<T>();
	}
	public void add(T value)
	{
		 this.list.add(value);
		 heapifyUp();
	}

	private void heapifyUp() {
		// TODO Auto-generated method stub
		int k = this.list.size() - 1;
		int p = (k-1)/2;
		while(p >= 0)
		{
			T item = this.list.get(k);
			T parent  = this.list.get(p);
			
			if(item.compareTo(parent) > 0)
			{
				this.list.set(k, parent);
				this.list.set(p, item);
				k = p;
				p = (k-1)/2;
			}
			else
			{
				break;
			}
		}
	}

	private void heapifyDown()
	{
		int k = 0;
		int l = 2*k + 1;
		while(l < this.list.size())
		{
			int max = l, r = l+1;
			if(r < list.size())
			{
				if(list.get(r).compareTo(list.get(l)) > 0)
				{
					max++;
				}
			}
			if(list.get(max).compareTo(list.get(k)) > 0)
			{
				T item = this.list.get(k);
				this.list.set(k, list.get(max));
				this.list.set(max, item);
				k = max;
				l = 2*k+1;
			}
			else
			{
				break;
			}
		}
	}
	
	public T delete()
	{
		if(list.size() < 1) return null;
		if(list.size() == 1) return list.remove(0);
		T item = this.list.get(0);
		list.set(0, list.remove(list.size()-1));
		heapifyDown();
		return item;
	}
	
	
}
