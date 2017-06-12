package Graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class HamiltonianCircuit {

	
	public void findHamiltonianCircuit(int[][] graph)
	{
		int len = graph.length;
		
		int col = 0;
		boolean flag= false;
		for(int row = 0 ; row < len ; row++)
		{
			if(graph[row][col] == 1)
			{
				Set<Integer> set= new HashSet<Integer>();
				if(findHamiltonianCircuit(graph,set,row))
				{
					System.out.println(row);
					flag = true;
					break;
				}
			}
		}
		if(!flag) System.out.println("Nohamiltonian ciruit foun");
	}
	
	private boolean findHamiltonianCircuit(int[][] graph, Set<Integer> set, int col)
	{
		if(col == 0 && set.size() == graph.length-1)
		{
			set.add(0);
			return true;
		}
		if(col == 0 && set.size() != graph.length-1) return false;
		if(set.contains(col))return false;
		
		boolean retVal = false;
		set.add(col);
		for(int row = 0 ; row < graph.length; row++)
		{
			if(!set.contains(row) && graph[row][col] == 1)
			{
				
				retVal = findHamiltonianCircuit(graph,set, row);
				if(retVal)
				{
					System.out.println(row);
					break;
				}
				else
				{
					set.remove(row);
				}
			}
		}
		return retVal;
	}
	
	public static void main(String[] args)
	{
		HamiltonianCircuit hm = new HamiltonianCircuit();
		int graph[][] =  {{0, 1, 0, 1, 0},
	            {1, 0, 1, 1, 1},
	            {0, 1, 0, 0, 1},
	            {1, 1, 0, 0, 1},
	            {0, 1, 1, 1, 0},
	        };
		hm.findHamiltonianCircuit(graph);
	}
	
	
}
