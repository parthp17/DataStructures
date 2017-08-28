package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class TweetRecommendation {

	
	public static void main(String[] args)
	{
		
		String[][] followEdges = new String[][]{{"A","B"},{"A","C"},{"B","C"},{"B","D"},{"C","D"},{"C","A"}};
		String[][] likeEdges = new String[][]{{"B","T1"},{"C","T2"},{"D","T3"},{"B","T2"},{"B","T3"},{"D","T2"},{"D","T1"}};
		getRecommendations(followEdges, likeEdges, "A", 2).forEach(System.out::println);
	}
	
	public static List<String> getRecommendations(String[][] followEdges,String[][] likeEdges, String targetUser, int threshold )
	{
		TreeMap<String, Integer> map = new TreeMap<>();
		List<String> connections = new ArrayList<>();
		
		for(String[] sarr : followEdges)
		{
			if(sarr[0].equals(targetUser))
			{
				connections.add(sarr[1]);
			}
		}
		for(String[] sarr : likeEdges)
		{
			if(connections.contains(sarr[0]))
			{
				if(map.containsKey(sarr[1]))
				{
					map.put(sarr[1], map.get(sarr[1]) + 1);
				}
				else
				{
					map.put(sarr[1],1);
				}
			}
		}
		
		List<String> list = map.entrySet().stream().filter(x -> x.getValue() >= threshold).map(y -> y.getKey()).collect(Collectors.toList());
		return list;
	}
}
