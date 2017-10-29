package String;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LetterCombinationPhoneNumber {

	public List<String> letterCombinations(String digits) {
    
		LinkedList<String> ans = new LinkedList<String>();
	    String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	    ans.add("");
	    for(int i =0; i<digits.length();i++){
	        int x = Character.getNumericValue(digits.charAt(i));
	        while(ans.peek().length()==i){
	            String t = ans.poll();
	            for(char s : mapping[x].toCharArray())
	                ans.add(t+s);
	        }
	    }
	    return ans;
    }
	
	public static void main(String[] args) {
		LetterCombinationPhoneNumber l = new LetterCombinationPhoneNumber();
		l.letterCombinations("23").forEach(System.out::println);
	}
}
