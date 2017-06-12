package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class BellmanFordSingleSourceShortestPath {

	/*
	 * shortest path from one point to other point in graph like Djikstra's algorithm.
	 * But allows negative weight.
	 * relatively slower than,time complexity O(VE) space complexity O(V)
	 * all pair shortest paths complexity O(V^2 x E)
	 * finds -ve weight cycle.
	 * 
	 */
	
	
	public HashMap<VertexInt, Integer> findShortestPath(DirectedWeightedGraph dwg, VertexInt source)
	{
		
		List<Edge> edges = new ArrayList<Edge>();
		HashMap<VertexInt, VertexInt> parentMap = new HashMap<VertexInt, VertexInt>();
		HashMap<VertexInt, Integer> distance = new HashMap<VertexInt, Integer>();
		
		for(LinkedList<Edge> ls : dwg.edges)
		{
			for(Edge e : ls)
			{
				edges.add(e);
			}
		}
		
		for(VertexInt v : dwg.vertices)
		{
			distance.put(v, Integer.MAX_VALUE);
			parentMap.put(v, null);
		}
		distance.put(source,0);
		
		int nv = dwg.vertices.size() - 1;
	
		for(int i = 0; i < nv ; i++)
		{
			for(Edge e : edges)
			{
				VertexInt src = e.endPoint1;
				VertexInt des = e.endPoint2;
				int sd = distance.get(src);
				if(distance.get(des) > sd + e.weight)
				{
					distance.put(des, sd + e.weight);
					parentMap.put(des, src);
				}
			}
		}
		
		for(Edge e : edges)
		{
			VertexInt src = e.endPoint1;
			VertexInt des = e.endPoint2;
			int sd = distance.get(src);
			if(distance.get(des) > sd + e.weight)
			{
				System.err.println("Negative Cycle Detected");
				System.exit(0);
			}
		}
		return distance;
	}
	
	public static void main(String[] args)
	{
		DirectedWeightedGraph dwg = new DirectedWeightedGraph(5);
		VertexInt v0 = new VertexInt(0);
		VertexInt v1 = new VertexInt(1);
		VertexInt v2 = new VertexInt(2);
		VertexInt v3 = new VertexInt(3);
		VertexInt v4 = new VertexInt(4);
		
		dwg.vertices.add(v0);
		dwg.vertices.add(v1);
		dwg.vertices.add(v2);
		dwg.vertices.add(v3);
		dwg.vertices.add(v4);
		
        dwg.addEdge(v0, v3, 8);
        dwg.addEdge(v0, v1, 4);
        dwg.addEdge(v0, v2, 5);
        dwg.addEdge(v1, v2, -3);
        dwg.addEdge(v2, v4, 4);
        dwg.addEdge(v3, v4, 2);
        dwg.addEdge(v4, v3, 1);
        
        BellmanFordSingleSourceShortestPath ssp = new BellmanFordSingleSourceShortestPath();
        HashMap<VertexInt,Integer> map = ssp.findShortestPath(dwg, v0);
        for(VertexInt v : map.keySet())
        {
        	System.out.println("Src " + v0.value + " destination "+ v.value + " distance "+map.get(v));
        }
	}
}
