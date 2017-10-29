package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class grouopAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> container = new ArrayList<>();
        for(String s : strs)
        {
        	char[] carr = s.toCharArray();
        	Arrays.sort(carr);
        	List<String> ls = null;
        	if(map.containsKey(String.valueOf(carr)))
        	{
        		ls = map.get(String.valueOf(carr));
        		ls.add(s);
        	}
        	else
        	{
        		ls = new ArrayList<>();
        		ls.add(s);
        		map.put(String.valueOf(carr), ls);
        		container.add(ls);
        	}
        }
        return container;
    }
}
