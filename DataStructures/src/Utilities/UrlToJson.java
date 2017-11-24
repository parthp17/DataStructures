package Utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class UrlToJson {

	
	public static void main(String[] args) {
		
		
		System.out.println(urlParses("a=1&a=2&a=3"));
		
	}
	
	
	public static Map<String, Object> urlParses(String s)
	{
		Map<String, Object> map = new HashMap<>();
		
		
		if(s == null || s.length() < 3) return map;
		
		String[] arr = s.split("&");
		
		for(String s1 : arr)
		{
			String[] sarr = s1.split("=");
			if(map.containsKey(sarr[0]))
			{
				Object stemp = map.get(sarr[0]);
				if( stemp instanceof String )//first time it would be string          check
				{
					List<String> ls = new ArrayList<>();
					ls.add((String)stemp);
					ls.add(sarr[1]);
					map.put(sarr[0], ls);
				}
				else // 2nd or more time
				{
					List<String> ls = (List<String>) map.get(sarr[0]);
					
					ls.add(sarr[1]);
				}
			}
			else
			{
				map.put(sarr[0], sarr[1]);
			}	
		}
		return map;
		
	}
}
