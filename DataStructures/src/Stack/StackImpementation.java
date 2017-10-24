package Stack;

public class StackImpementation {

	public static void main(String[] args)
	{
		/*Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		stack.push(3);
		stack.push(5);
		stack.push(7);
		System.out.println(stack.peek());
		stack.push(9);
		System.out.println(stack.pop());
		System.out.println(stack.getSize());
		System.out.println(stack.isEmpty());
		stack.pop();
		stack.pop();
		System.out.println(stack.getSize());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.getSize());
		System.out.println(stack.isEmpty());
		*/
		StackUtility s =new StackUtility();
		System.out.println(s.longestRecatangleArea(new int[]{2,3,4,1}));
	}
}
