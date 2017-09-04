package Stack;

import java.util.Arrays;
import java.util.Stack;
import java.util.function.IntConsumer;

public class StackUtility {

	public <T> void reverseStack(java.util.Stack<T> s)
	{
		if(s.isEmpty()) return;
		T t = s.pop();
		reverseStack(s);
		insertAtBottom(s, t);
	}
	private <T> void insertAtBottom(Stack<T> s, T t)
	{
		if(s.isEmpty())
		{
			s.push(t);
			return;
		}
		T temp = s.pop();
		insertAtBottom(s, t);
		s.push(temp);
	}
	
	public void sortStack(java.util.Stack<Integer> s)
	{
		if(s.isEmpty()) return;
		int t = s.pop();
		sortStack(s);
		sort(s,t);
	}
	
	private void sort(java.util.Stack<Integer> s, int t)
	{
		if(s.isEmpty())
		{
			s.push(t);
		}
		else
		{
			int i = s.peek();
			if(t > i)
			{
				s.push(t);
			}
			else
			{
				s.pop();
				sort(s,t);
				s.push(i);
			}
		}
	}
	
	public int[] increasingSpan(int[] arr)
	{
		int[] span = new int[arr.length];
		Stack<Integer> stack = new Stack<>();
		int  p;
		for(int i =0; i < arr.length; i++)
		{
			while(!stack.isEmpty() && arr[i] > arr[stack.peek()]) stack.pop();
			p = stack.isEmpty() ? -1 : stack.peek();
			span[i] = i - p;
			stack.push(i);
		}
		return span;
	}
	
	public int longestRecatangleArea(int[] arr)
	{
		if(arr == null || arr.length == 0) return 0;
		Stack<Integer> stack = new Stack<>();
		int maxArea = Integer.MIN_VALUE;
		int i = 0;
		while( i < arr.length )
		{
			if(stack.isEmpty() || arr[i] > arr[stack.peek()]) stack.push(i++);
			else
			{
				int top = stack.pop();
				maxArea = Math.max(maxArea, arr[top]*(stack.isEmpty() ? i : i - stack.peek() - 1));
			}
		}
		while(!stack.isEmpty())
		{
			int  top = stack.pop();
			maxArea = Math.max(maxArea, arr[top]*(stack.isEmpty() ? i : i - stack.peek() - 1));
		}
		return maxArea;
	}
	
	public static void main(String[] args)
	{
		StackUtility st = new StackUtility();
		java.util.Stack<Integer> s = new Stack<Integer>();
		s.push(1);
		s.push(3);
		s.push(4);
		s.push(5);
		s.push(2);
		System.out.println(st.longestRecatangleArea(new int[]{3,1,3,2,2}));
	}
	
}