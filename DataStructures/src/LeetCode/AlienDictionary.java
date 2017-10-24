package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;


class AlienDictionary {
	class CircularException extends Exception{
		
		
	}
	
	Map<Character,Set<Character>> vertices = new HashMap<>();
	
    public String alienOrder(String[] words) {
    	
    	for(String s : words)
    		for(char c : s.toCharArray())
    			if(!vertices.containsKey(c))
    				vertices.put(c, new HashSet<>());
    	
    	for(int s = 0 ; s < words.length-1; s++)
    	{
    		String s1 = words[s];
    		String s2 = words[s+1];
    		int len = s1.length() >= s2.length() ? s2.length() : s1.length();
    		for(int i = 0; i < len ; i++)
    		{
    			if(s1.charAt(i) != s2.charAt(i))
    			{
    				vertices.get(s1.charAt(i)).add(s2.charAt(i));
    				break;
    			}
    		}
    	}
    	Stack<Character> stack  = new Stack<>();
    	Set<Character> visited = new HashSet<>();
    	Set<Character> alphabets = vertices.keySet();
    	Iterator itr = alphabets.iterator(); 
    	while(itr.hasNext())
    	{
    		char c = (char) itr.next();
    		if(!visited.contains(c))
				try {
					doTopologicalSort(c, visited, stack, vertices);
				} catch (CircularException e) {
					
				}
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	while(!stack.isEmpty())
    		sb.append(stack.pop());
    	return sb.toString();
    }

	private void doTopologicalSort(char c, Set<Character> visited, Stack<Character> stack, Map<Character,Set<Character>> map) throws CircularException {
		
			visited.add(c);
			Set<Character> edges = map.get(c);
			for(char c1 : edges)
			{
				if(!visited.contains(c1))
					doTopologicalSort(c1, visited, stack, map);
				else if(visited.contains(c1) && !stack.contains(c1))
				{
					stack.clear();
					visited.addAll(map.keySet());
					throw new CircularException();
				}

			}
			stack.push(c);
	}
	
	public static void main(String[] args) {
		
		AlienDictionary ad = new AlienDictionary();
		String[] words = {"ri","xz","qxf","jhsguaw","dztqrbwbm","dhdqfb","jdv","fcgfsilnb","ooby"};
		System.out.println(ad.alienOrder(words));
	}
}
