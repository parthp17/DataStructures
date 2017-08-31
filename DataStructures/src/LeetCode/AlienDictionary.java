package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

class Vertex{
	char value;
	boolean visited = false;
	public Vertex(char c) {
		this.value = c;
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof Vertex && this.value == ((Vertex)obj).value;
	}
	
	@Override
	public int hashCode() {
		return value;
	}
}
class Solution {
	
	Set<Vertex> vertices = new HashSet<>();
	ArrayList<LinkedList<Vertex>> edges = new ArrayList<>();
	
    public String alienOrder(String[] words) {
    	
    	for(int s = 0 ; s < words.length ; s++)
    	{
    		for(int c = 0; c < words[s].length(); c++)
    		{
    			Vertex v; 
    			if(vertices.contains( v = new Vertex(words[s].charAt(c))))
    				vertices.add(v);
    		}
    		
    		if(s > 0)
    		{
    			
    			
    		}
    		
    		
    	}
    	return null;
        /*boolean[][] graph = new boolean[26][26];
        int[] visited = new int[26];
        Arrays.fill(visited, -1);
        for (int i = 0; i <
         words.length; i++) {
            for (char c : words[i].toCharArray()) {
                visited[c - 'a'] = 0;
            }
            if (i > 0) {
                String w1 = words[i - 1], w2 = words[i];
                int len = Math.min(w1.length(), w2.length());
                for (int j = 0; j < len; j++) {
                    char c1 = w1.charAt(j), c2 = w2.charAt(j);
                    if (c1 != c2) {
                        graph[c1 - 'a'][c2 - 'a'] = true;
                        break;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (visited[i] == 0 && !dfs(graph, visited, sb, i)) {
                return "";
            }
        }
        return sb.reverse().toString();
    }
    
    private boolean dfs(boolean[][] graph, int[] visited, StringBuilder sb, int i) {
        visited[i] = 1;
        for (int j = 0; j < 26; j++) {
            if (graph[i][j]) {
                if (visited[j] == 1) {
                    return false;
                }
                if (visited[j] == 0 && !dfs(graph, visited, sb, j)) {
                    return false;
                }
            }
        }
        visited[i] = 2;
        sb.append((char) (i + 'a'));
        return true;*/
    }
}
