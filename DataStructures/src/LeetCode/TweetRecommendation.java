package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class TweetRecommendation {

	
	public static void main(String[] args)
	{
		
	}
	
	public static int[] getRecommendations(int[][] followEdges,int[][] likeEdges, int targetUser, int threshold )
	{
		/*TreeMap<Integer, Integer> map = new TreeMap<>();
		List<Integer> connections = new ArrayList<>();
		*/
		HashSet<Integer> set = Arrays.stream(followEdges).filter(t -> t[0] == (targetUser)).map(t -> t[1]).collect(Collectors.toCollection(HashSet::new));
		//list.stream().forEach(t -> t[1]);
		TreeMap<Integer, Long> map1= Arrays.stream(likeEdges).filter(t -> set.contains(t[0])).collect(Collectors.groupingBy(t -> t[1],TreeMap::new, Collectors.counting()));
		
		/*for(int[] arr : followEdges)
		{
			if(arr[0] == (targetUser))
			{
				connections.add(arr[1]);
			}
		}
		for(int[] arr : likeEdges)
		{
			if(connections.contains(arr[0]))
			{
				if(map.containsKey(arr[1]))
				{
					map.put(arr[1], map.get(arr[1]) + 1);
				}
				else
				{
					map.put(arr[1],1);
				}
			}
		}*/
		int[] list = map1.entrySet().stream().filter(x -> x.getValue() >= threshold).mapToInt(y -> y.getKey()).sorted().toArray();
		return list;
	}
}
