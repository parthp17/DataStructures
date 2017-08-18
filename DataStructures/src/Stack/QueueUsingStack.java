package Stack;

public class QueueUsingStack<T> {

	private Stack<T> s1 = new Stack<T>();
	private Stack<T> s2 = new Stack<T>();
	
	public void enqueue(T t)
	{
		s1.push(t);
	}
	
	public T dequeue()
	{
		if(s2.isEmpty())
		{
			while(!s1.isEmpty())
			{
				s2.push(s1.pop());
			}
		}
		return s2.pop();
	}
}
