package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromePair {

	public List<List<Integer>> palindromePairs(String[] words) {
     
		List<List<Integer>> container = new ArrayList<>();
		Map<String,Integer> map = new HashMap<String,Integer>();
		for(int i =0 ; i < words.length ; i++) map.put(words[i], i);
		List<Integer> ls = null;
		for(int i = 0; i< words.length;i++)
		{
			for(int j = 0; j <= words[i].length() ;j++)
			{
				String s1 = words[i].substring(0, j);
				String s2 = words[i].substring(j);
				if(isPalindrome(s1))
				{
					String rs2 = reverse(s2);
					if(map.containsKey(rs2) && i != map.get(rs2))
					{
						ls = new ArrayList<>();
						ls.add(map.get(rs2));
						ls.add(i);
						container.add(ls);
					}
					
				}
				
				if(isPalindrome(s2))
				{
					String rs1 = reverse(s1);
					if(map.containsKey(rs1) && i != map.get(rs1) && s2.length() != 0)
					{
						ls = new ArrayList<>();
						ls.add(i);
						ls.add( map.get(rs1));
						container.add(ls);
					}
				}
			}
		}
		return container;
		
    }
	
	private boolean isPalindrome(String s)
	{
		if(s == null || s.length() ==1 || s.length() == 0) return true;
		else return s.charAt(0) == s.charAt(s.length()-1) && isPalindrome(s.substring(1,s.length()-1));
	}
	
	private String reverse(String s)
	{
		if(s ==null || s.length() == 0 ) return s;
		return (reverse(s.substring(1)) + s.charAt(0));
	}
	
	public static void main(String[] args) {
		PalindromePair pp = new PalindromePair();
		pp.palindromePairs(new String[]{"abcd", "dcba", "lls", "s", "sssll"}).forEach(System.out::println);
	}
}
