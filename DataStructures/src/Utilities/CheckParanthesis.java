package Utilities;
import java.util.Stack;

public class CheckParanthesis {

	
	
	public static String[] checkParanthesis(String[] str)
	{
		Stack<Character> stack = new Stack<Character>();
		String[] answer = new String[Integer.parseInt(str[0])];
		for(int i = 1; i < str.length; i++)
		{
			char[] array = str[i].toCharArray();
			
			for(char c : array)
			{
				if(c == '[' || c == '{' || c == '(') stack.push(c);
				else if((c == ']' || c == '}' || c == ')') && !stack.isEmpty())
				{
					if((c==']' && stack.peek() == '[') || (c=='}' && stack.peek() == '{') || (c==')' && stack.peek() == '('))
					{
						stack.pop();
						answer[i-1] = "YES";
					}
					else
					{
						answer[i-1] = "NO";
					}
				}
				else{
					continue;
				}
			}
			
			if(stack.empty() && !answer[i-1].equals("NO"))
				answer[i-1] = "YES";
			else
				answer[i-1] = "NO";
			
			stack.clear();
		}
		return answer;
	}
}
