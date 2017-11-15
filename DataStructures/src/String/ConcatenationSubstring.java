package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConcatenationSubstring {

	public List<Integer> findSubstring(String s, String[] words) {
    
		List<Integer> answer = new ArrayList<>();
		if(s == null || words ==null  || s.length() == 0|| words.length == 0) return answer;
		int eachlen = words[0].length();
		int totalLen = words.length * eachlen;
		if(totalLen > s.length()) return answer;
		Map<Integer,String> map = new HashMap<>();
		Matcher m = null;
		for(String s1 : words)
		{
			if(s.indexOf(s1) == -1) return answer;
			m = Pattern.compile(s1).matcher(s);
			while(m.find())
			{
				map.put(m.start(), s1);
			}
		}
		for(int i = 0; i< s.length() ;)
		{
			if(map.containsKey(i))
			{
				Set<String> set = new HashSet<>();
				int in = i;
				boolean flag = true;
				for(int count = 0; count < words.length; count++)
				{
					if(!map.containsKey(in) || !set.add(map.get(in)))
					{
						flag = false;
						break;
					}
					else
					{
						in = in + eachlen;
					}
					
				}
				if(flag) 
					answer.add(i);
				i+=eachlen;
			}
			else
			{
				i++;
			}
		}
		
		return answer;
    }
	
	public static void main(String[] args) {
		
		ConcatenationSubstring cs = new ConcatenationSubstring();
		cs.findSubstring("barfoofoobarthefoobarman", new String[]{"bar","foo","the"}).forEach(System.out::println);
	}
}
