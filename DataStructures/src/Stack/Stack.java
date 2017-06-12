package Stack;

public class Stack<T> {

	T array[];
	int top;
	private final static int DEFAULT_SIZE = 10;
	
	public Stack()
	{
		this.array = (T[]) new Object[DEFAULT_SIZE];
		this.top = 0;
	}
	public Stack(int size)
	{
		this.array = (T[]) new Object[size];
		this.top = 0;
	}
	
	public void push(T t)
	{
		if(top < array.length)
		{
			array[top++] = t;
		}
	}
	
	public T peek()
	{
		if(top > 0)
		{
			return array[top-1];
		}
		return null;
	}
	
	public T pop()
	{
		T element = null;
		if(top > 0)
		{
			top--;
			element = array[top];
			array[top] = null;
		}
		return element;
	}
	
	public int getSize()
	{
		return top;
	}
	
	public boolean isEmpty()
	{
		return top == 0;
	}
	
}
