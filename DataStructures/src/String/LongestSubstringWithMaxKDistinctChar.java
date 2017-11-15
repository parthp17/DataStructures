package String;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithMaxKDistinctChar {

	public int lengthOfLongestSubstringKDistinct(String s, int k) {
    
		if(k == 0 || s ==null || s.length() == 0) return 0;
		int max = 0;
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		int start = 0;
		int i = 0;
		
			for( ; i < s.length() && start < s.length();i++)
			{
				max = max >= i-start ? max : i - start;
				while(map.keySet().size() == k && !map.containsKey(s.charAt(i)))
				{
					int val = map.get(s.charAt(start));
					val -= 1;
					if(val == 0)
					{
						map.remove(s.charAt(start));
					}
					else
					{
						map.put(s.charAt(start), val);
					}
					start++;
				}
				if(map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) > 0)
				{
					map.put(s.charAt(i), map.get(s.charAt(i))+1);
				}
				else
				{
					map.put(s.charAt(i), 1);
				}
			}
		return max = max >= i-start ? max : i-start;
    }
	
	public static void main(String[] args) {
		
		LongestSubstringWithMaxKDistinctChar l = new LongestSubstringWithMaxKDistinctChar();
		System.out.println(l.lengthOfLongestSubstringKDistinct("eebe", 2));
	}
}
