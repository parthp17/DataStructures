package HackerRank.HomeAway;

import java.util.Arrays;
import java.util.Stack;

public class BalancedParenthesis {

	
	static int[] balancedOrNot(String[] expressions, int[] maxReplacements) {
		int[] answer = new int[expressions.length];
        Stack<Character> stack = new Stack<>();
        char[] array = null;
        boolean flag = true;
        int len  = expressions.length;
        int[] repl = Arrays.copyOf(maxReplacements, len);
        for(int i = 0; i < expressions.length ; i++){
        	flag = true;
			array = expressions[i].toCharArray();
			for(char c : array)
			{
				if(c == '<') stack.push(c);
				else if(c == '>')
				{
					if(!stack.isEmpty()) stack.pop();
					else if(stack.isEmpty() && repl[i] > 0)
					{
						repl[i]--;
					}
					else
						flag = false;
				}
				else{
					continue;
				}
			}
			if(stack.empty() && flag)
				answer[i] = 1;
			else
				answer[i] = 0;
			stack.clear();
		}
        return answer;
    }
	
	public static void main(String[] args) {
		
		int[] arr= balancedOrNot(new String[]{"<<<><><>"}, new int[]{2});
		Arrays.stream(arr).forEach(System.out::println);
	}
}
