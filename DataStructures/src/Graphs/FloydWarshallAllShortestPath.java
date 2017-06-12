package Graphs;

import java.util.Arrays;
import java.util.LinkedList;

public class FloydWarshallAllShortestPath {

	/*
	 *Time complexity - O(V^3)
	 *Space complexity - O(V^2)
	 *find shortest path for all vertices to all other vertices.
	 */
	public int[][] findAllShortestPath(DirectedWeightedGraph dwg)
	{
		int size = dwg.vertices.size();
		int i = 0;
		int j = i;
		int k= i;
		int[][] distance = new int[size][size];
		for(int[] arr : distance)
		{
			Arrays.fill(arr, Integer.MAX_VALUE);
		}
		VertexInt[][] mapping = new VertexInt[size][size];
		for(VertexInt[] arr : mapping)
		{
			Arrays.fill(arr, null);
		}
		int src = 0;
		int dest = 0;
		for(LinkedList<Edge> ls : dwg.edges)
		{
			for(Edge e: ls)
			{
				dest = dwg.vertices.indexOf(e.endPoint2);
				distance[src][dest] = e.weight;
				mapping[src][dest] = e.endPoint1;
			}
			src++;
		}
		for(int x=0;x<size;x++)
		{
			distance[x][x] = 0;
		}
		
		for(; k < size; k++)
		{
			for(i=0;i < size; i++)
			{
				for(j=0; j < size ; j++)
				{
					if(distance[i][k] == Integer.MAX_VALUE || distance[k][j] == Integer.MAX_VALUE) continue;
					if(distance[i][j] > distance[i][k] + distance[k][j])
					{
						distance[i][j] = distance[i][k]+ distance[k][j];
						mapping[i][j] = mapping[k][j];
					}
				}
			}
		}
		for(int x=0;x<size;x++)
		{
			if(distance[x][x] < 0 )
			{
			System.err.println("Negative weight cycle found");
			System.exit(1);
			}
		}
		StringBuilder s= null;
		for(VertexInt[] arr: mapping)
		{
			s = new StringBuilder();
			for(VertexInt v : arr)
			{
				if(v == null)
				{
					s.append(null + "\t\t"); 
				}
				else
				{
					s.append(String.valueOf(v.value) + "\t\t");
				}
			}
			System.out.println(s.toString());
		}
		System.out.println();
		return distance;
	}
	
	public static void main(String[] args)
	{
		DirectedWeightedGraph dwg = new DirectedWeightedGraph(5);
		VertexInt v0 = new VertexInt(0);
		VertexInt v1 = new VertexInt(1);
		VertexInt v2 = new VertexInt(2);
		VertexInt v3 = new VertexInt(3);
		
		
		dwg.vertices.add(v0);
		dwg.vertices.add(v1);
		dwg.vertices.add(v2);
		dwg.vertices.add(v3);
		
		
		dwg.addEdge(v0, v1, 3);
		dwg.addEdge(v0, v2, 6);
		dwg.addEdge(v0, v3, 15);
		dwg.addEdge(v1, v2, -2);
		dwg.addEdge(v2, v3, 2);
		dwg.addEdge(v3, v0, 1);
		
		FloydWarshallAllShortestPath asp = new FloydWarshallAllShortestPath();
		StringBuilder s ;
		int [][] distance = asp.findAllShortestPath(dwg);
		for(int[] arr: distance)
		{
			s = new StringBuilder();
			for(int i : arr)
				s.append(String.valueOf(i) + "\t\t");
			System.out.println(s.toString());
		}
	}
}
