package String;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

	public List<String> generateParenthesis(int n) {
    
		List<String> ls = new ArrayList<>();
		if(n < 1)return ls;
		backTrack(ls, "",0,0,n);
		return ls;
    }

	private void backTrack(List<String> ls, String string, int i, int j, int n) {
		
		if(string.length() == n*2)
		{
			ls.add(string);
			return;
		}
		
		if(i < n)
			backTrack(ls, string+'(', i+1, j, n);
		if(j < i)
			backTrack(ls, string + ')', i, j+1, n);
	}
	
	public static void main(String[] args) {

		GenerateParenthesis gp = new GenerateParenthesis();
		gp.generateParenthesis(3).forEach(System.out::println);
	}
	
	
}
