package LeetCode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class GeneticMutation {

	public int minimumMutations(String start, String end, String[] bank)
	{
		if(start.equals(end)) return 0;
		char[] charSet = new char[]{'A','G','C','T'};
		Set<String> visited = new HashSet<String>();
		Set<String> bankSet = new HashSet<String>();
		for(String s : bank)
			bankSet.add(s);
		Queue<String> q = new LinkedList<String>();
		q.offer(start);
		visited.add(start);
		int level = 0;
		while(!q.isEmpty())
		{
			int size = q.size();
			while(size-- > 0)
			{
				String current = q.poll();
				if(current.equals(end)) return level;
				char[] currArr = current.toCharArray();
				for(int i =0 ; i < currArr.length ; i++ )
				{
					char cOld = currArr[i];
					for(char c : charSet)
					{
						currArr[i] = c;
						String newS = new String(currArr);
						if(bankSet.contains(newS) && !visited.contains(newS))
						{
							visited.add(newS);
							q.offer(newS);
						}
					}
					currArr[i] = cOld;
				}
			}
			level++;
		}
		return -1;
		
	}
	
}
